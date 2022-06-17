package org.example.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerSolo {
    private static EntityManagerSolo single_instance = null;

    private EntityManagerFactory fact;

    private EntityManagerSolo() {
        this.fact =
                Persistence.createEntityManagerFactory(
                        "ExamplePU");

    }

    public static synchronized EntityManagerSolo getInstance() {
        if (single_instance == null)
            single_instance = new EntityManagerSolo();

        return single_instance;
    }

    public synchronized EntityManager getEntity() {

        return this.fact.createEntityManager();
    }
}
