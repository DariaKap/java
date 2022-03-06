package Lesson24;

import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBBook {
    private static final Properties DB_SETTINGS = new Properties();

    static {
        try {
            DB_SETTINGS.load(DBBook.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static void dropAndCreateTable() {
        try (final Connection connection = DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));

             final PreparedStatement dropTableBooks = connection.prepareStatement("drop table if exists books");
             final PreparedStatement dropTableGenres = connection.prepareStatement("drop table if exists genres");
             final PreparedStatement dropTablePublishers = connection.prepareStatement("drop table if exists publishers");
             final PreparedStatement dropTableAuthors = connection.prepareStatement("drop table if exists authors");
             final PreparedStatement createTableGenres = connection.prepareStatement(
                     """
                             create table genres
                             (
                                 id   int auto_increment,
                                 name varchar(300) not null unique,
                                 constraint genres_pk
                                 primary key (id)
                             );
                             """);
             final PreparedStatement createTablePublishers = connection.prepareStatement(
                     """
                             create table publishers
                             (
                                 id   int auto_increment,
                                 name varchar(300) not null unique,
                                 constraint publishers_pk
                                 primary key (id)
                             );
                             """);
             final PreparedStatement createTableAuthors = connection.prepareStatement(
                     """
                             create table authors
                             (
                                 id   int auto_increment,
                                 name varchar(300) not null unique,
                                 constraint authors_pk
                                 primary key (id)
                             );
                             """);
             final PreparedStatement createTableBooks = connection.prepareStatement(
                     """
                             create table books
                             (
                                 id           int auto_increment,
                                 isbn         varchar(300) not null,
                                 name         varchar(300) not null,
                                 author_id    int not null,
                                 genre_id     int not null,
                                 publisher_id int not null,
                                 year         varchar(4) not null,
                                 num_of_pages int,
                                 url          varchar(400),
                                 constraint books_pk
                                 primary key (id),
                                 constraint books_author_id_fk
                                     foreign key (author_id) references authors (id),
                                 constraint books_genre_id_fk
                                     foreign key (genre_id) references genres (id),
                                 constraint books_publisher_id_fk
                                     foreign key (publisher_id) references publishers (id)
                             );
                             """);
        ) {
            // удаление таблиц, если они есть
            dropTableBooks.execute();
            dropTableGenres.execute();
            dropTablePublishers.execute();
            dropTableAuthors.execute();
            // создание таблиц
            createTableGenres.execute();
            createTablePublishers.execute();
            createTableAuthors.execute();
            createTableBooks.execute();
        }
    }

    @SneakyThrows
    private static int insertDictTblAndGetID(String tableName, String value) {
        String getQuery = "select id from " + tableName + " where name = ?";
        String insertQuery = "insert into " + tableName + "(name) values (?)";
        try (final Connection connection = DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));

             final PreparedStatement getStatement = connection.prepareStatement(getQuery);
             final PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        ) {
            getStatement.setString(1, value);
            int id = 0;
            ResultSet result = getStatement.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
            } else {
                insertStatement.setString(1, value);
                insertStatement.execute();
                result = insertStatement.getGeneratedKeys();
                if (result.next()) {
                    id = result.getInt(1);
                }
            }
            return id;
        }
    }

    @SneakyThrows
    public static int insertBook(Book book) {
        try (final Connection connection = DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));

             final PreparedStatement insertStatement = connection.prepareStatement("""
                             insert into books(isbn,name,author_id, genre_id,publisher_id, year,num_of_pages, url)
                             values (?, ?, ?, ?, ?, ?, ?, ?)""",
                     Statement.RETURN_GENERATED_KEYS);
        ) {
            int genre_id = insertDictTblAndGetID("genres", book.getGenre());
            int author_id = insertDictTblAndGetID("authors", book.getAuthor());
            int publisher_id = insertDictTblAndGetID("publishers", book.getPublisher());
            insertStatement.setString(1, book.getIsbn());
            insertStatement.setString(2, book.getName());
            insertStatement.setInt(3, author_id);
            insertStatement.setInt(4, genre_id);
            insertStatement.setInt(5, publisher_id);
            insertStatement.setString(6, book.getYear());
            insertStatement.setInt(7, book.getPages());
            insertStatement.setString(8, book.getUrl());
            insertStatement.execute();
            ResultSet result = insertStatement.getGeneratedKeys();
            int id = 0;
            if (result.next()) {
                id = result.getInt(1);
            }
            return id;
        }
    }

    @SneakyThrows
    public static void loadBooks(List<Book> books) {
        for (Book b : books) {
            insertBook(b);
        }
    }

    @SneakyThrows
    public static List<Book> searchBookByAuthor(String value) {
        try (final Connection connection = DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));

             final PreparedStatement getStatement = connection.prepareStatement("""
                     select b.isbn, a.name a_name, b.name b_name, g.name g_name, p.name p_name, b.year, b.num_of_pages, b.url
                     from genres g, publishers p, authors a, books b
                     where lower(a.name) like lower(?)
                     and b.author_id = a.id
                     and b.genre_id = g.id
                     and b.publisher_id = p.id""");
        ) {
            getStatement.setString(1, "%"+value+"%");
            ResultSet result = getStatement.executeQuery();
            List<Book> books = new ArrayList<>();
            try (final ResultSet resultSet = getStatement.executeQuery()) {
                while (resultSet.next()) {
                    Book book = new Book(resultSet.getString("isbn"),
                            resultSet.getString("a_name"),
                            resultSet.getString("b_name"),
                            resultSet.getString("g_name"),
                            resultSet.getString("p_name"),
                            resultSet.getString("year"),
                            resultSet.getInt("num_of_pages"),
                            resultSet.getString("url"));
                    books.add(book);
                }
                return books;
            }
        }
    }
    @SneakyThrows
    public static List<Book> searchBookByName(String value) {
        try (final Connection connection = DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));

             final PreparedStatement getStatement = connection.prepareStatement("""
                     select b.isbn, a.name a_name, b.name b_name, g.name g_name, p.name p_name, b.year, b.num_of_pages, b.url
                     from genres g, publishers p, authors a, books b
                     where lower(b.name) like lower(?)
                     and b.author_id = a.id
                     and b.genre_id = g.id
                     and b.publisher_id = p.id""");
        ) {
            getStatement.setString(1, "%"+value+"%");
            ResultSet result = getStatement.executeQuery();
            List<Book> books = new ArrayList<>();
            try (final ResultSet resultSet = getStatement.executeQuery()) {
                while (resultSet.next()) {
                    Book book = new Book(resultSet.getString("isbn"),
                            resultSet.getString("a_name"),
                            resultSet.getString("b_name"),
                            resultSet.getString("g_name"),
                            resultSet.getString("p_name"),
                            resultSet.getString("year"),
                            resultSet.getInt("num_of_pages"),
                            resultSet.getString("url"));
                    books.add(book);
                }
                return books;
            }
        }
    }
}