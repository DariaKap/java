package Lesson25;

import Lesson25.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.function.Consumer;

public class JPARunner {

    private static final Configuration CONFIG;
    private static SessionFactory sessionFactory;

    static {
        // SessionFactory in Hibernate 5 example
        CONFIG = new Configuration();
        CONFIG.configure();
    }
    public static void main(String[] args) {
        runInsideSession(session -> {
            final Book firstBook = session.find(Book.class, 1);
            System.out.println(firstBook.getName());


            Query<Book> searchQuery = session.createQuery("from Book where name like :name", Book.class);
            searchQuery.setParameter("name", "%нежно%");
            searchQuery.getResultList().forEach(System.out::println);

        });

    }
    public static void runInsideSession(Consumer<Session> consumer) {
        try (final Session session = getCurrentSessionFromConfig()) {
            Transaction transaction = session.beginTransaction();
            consumer.accept(session);
            transaction.commit();
        }
    }
    public static Session getCurrentSessionFromConfig() {
        SessionFactory sessionFactory = CONFIG.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
