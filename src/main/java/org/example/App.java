package org.example;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class App
{
    public static void main( String[] args ) {
        // otwarcie połączenia z bazą
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        saveEmployee(entityManager);
//        getEmployee(entityManager);
//        updateEmployee(entityManager);
//        refreshEmployee(entityManager);
//        deleteEmployee(entityManager);
//        detachAndMergeEmployee(entityManager);

        // dodanie książek
        generateData(entityManager);


        // zamknięcie połączenia z bazą
        entityManager.close();
        entityManagerFactory.close();

    }

    private static void generateData(EntityManager entityManager){


        Chapter chapter1 = new Chapter(
                "NazwaRozdziału1"
        );

        Chapter chapter2 = new Chapter(
                "NazwaRozdziału2"
        );

        Chapter chapter3 = new Chapter(
                "NazwaRozdziału3"
        );

        Chapter chapter4 = new Chapter(
                "NazwaRozdziału4"
        );

        Chapter chapter5 = new Chapter(
                "NazwaRozdziału5"
        );

        Chapter chapter6 = new Chapter(
                "NazwaRozdziału6"
        );

        Book book1 = new Book(
                "Książka pierwsza",
                LocalDate.of(2020,01,12),
                List.of(chapter1,chapter2)
        );

        Book book2 = new Book(
                "Książka druga",
                LocalDate.of(2021,04,7),
                List.of(chapter3,chapter4)
        );

        Book book3 = new Book(
                "Książka trzecia",
                LocalDate.of(2012,07,30),
                List.of(chapter5)
        );

        Book book4 = new Book(
                "Książka czwarta",
                LocalDate.of(1999,01,19),
                List.of(chapter6)
        );

        Author author1 = new Author(
                "ImięAutora1",
                "NazwiskoAutora1",
                List.of(book1,book2)
                );

        Author author2 = new Author(
                "ImięAutora2",
                "NazwiskoAutora2",
                List.of(book3)
        );

        Author author3 = new Author(
                "ImięAutora3",
                "NazwiskoAutora3",
                List.of(book4)
        );

        entityManager.getTransaction().begin();
        entityManager.persist(author1);
        entityManager.persist(author2);
        entityManager.persist(author3);
        entityManager.persist(chapter1);
        entityManager.persist(chapter2);
        entityManager.persist(chapter3);
        entityManager.persist(chapter4);
        entityManager.persist(chapter5);
        entityManager.persist(chapter6);
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.persist(book3);
        entityManager.persist(book4);





        entityManager.getTransaction().commit();

    }
}
