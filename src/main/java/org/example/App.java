package org.example;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App
{
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        saveEmployee(entityManager);
//        getEmployee(entityManager);
//        updateEmployee(entityManager);
//        refreshEmployee(entityManager);
//        deleteEmployee(entityManager);
//        detachAndMergeEmployee(entityManager);

        entityManager.close();
        entityManagerFactory.close();

    }
}
