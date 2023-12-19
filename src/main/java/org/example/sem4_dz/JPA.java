package org.example.sem4_dz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * * 2. С помощью JPA(Hibernate) выполнить:
 * * 2.1 Описать сущность Book из пункта 1.1
 * * 2.2 Создать Session и сохранить в таблицу 10 книг
 * * 2.3 Выгрузить список книг какого-то автора
 */
public class JPA {

    public static void main(String[] args) {

        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory();

        Book book1 = new Book("A Tale of Two Cities", "Charles Dickens", 547, 1859);
        Book book2 = new Book("The Little Prince", "Antoine de Saint-Exupéry", 146, 1943);
        Book book3 = new Book("Harry Potter and the Philosopher`s Stone", "J. K. Rowling", 725, 1997);
        Book book4 = new Book("And Then There Were None", "Agatha Christie", 628, 1939);
        Book book5 = new Book("Dream of the Red Chamber", "Cao Xueqin", 958, 1791);
        Book book6 = new Book("The Hobbit", "J. R. R. Tolkien", 957, 1937);
        Book book7 = new Book("Lolita", "Vladimir Nabokov", 391, 1955);
        Book book8 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 740, 1998);
        Book book9 = new Book("Hard Times", "Charles Dickens", 627, 1854);
        Book book10 = new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 559, 1999);

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(book1);
            session.persist(book2);
            session.persist(book3);
            session.persist(book4);
            session.persist(book5);
            session.persist(book6);
            session.persist(book7);
            session.persist(book8);
            session.persist(book9);
            session.persist(book10);
            session.getTransaction().commit();

            List<Book> bookList = session.createQuery(
                    "select book from Book book where author = 'J. K. Rowling' and id > 10", Book.class).getResultList();
            System.out.println("Книги искомого автора:");
            for(Book book : bookList) System.out.println(book.getName());


        }
        sessionFactory.close();
    }


}
