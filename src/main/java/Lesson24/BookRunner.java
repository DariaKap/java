package Lesson24;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class BookRunner {

    public static void main(String[] args) {

        Path path = Path.of("src", "main", "resources", "books.csv");
        List<Book> books = CSVBook.getBooks(path);
        System.out.println("Пересоздание таблиц...");
        DBBook.dropAndCreateTable();
        System.out.println("Заполнение таблиц...");
        DBBook.loadBooks(books);

        Scanner in = new Scanner(System.in);
        int number;
        String searchVal;
        String navigation = """
                Выберите одно из следующих действий:
                1. Поиск по названию книги
                2. Поиск по автору
                3. Выход
                >>""";
        System.out.println("Поиск по названию книги или по автору. ");
        do {
            System.out.print(navigation);
            while (!in.hasNextInt()) {
                System.out.print(navigation);
                in.next();
            }
            number = in.nextInt();

            switch (number) {
                case 1:
                    System.out.print("Введите название:");
                    searchVal = in.next();
                    books = DBBook.searchBookByName(searchVal);
                    System.out.println("Найденные книги: ");
                    printBooks(books);
                    break;
                case 2:
                    System.out.print("Введите автора:");
                    searchVal = in.next();
                    books = DBBook.searchBookByAuthor(searchVal);
                    System.out.println("Найденные книги: ");
                    printBooks(books);
                    break;
            }
        } while (number != 3);
    }

    private static void printBooks(List<Book> books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
