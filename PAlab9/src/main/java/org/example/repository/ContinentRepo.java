package org.example.repository;

import org.example.database.EntityManagerSolo;
import org.example.enitites.Continent;

import javax.persistence.EntityManager;

public class ContinentRepo {
    public void create(Continent continent) {
        EntityManager em = (EntityManager) EntityManagerSolo.getInstance().getEntity();
        em.getTransaction().begin();
        em.persist(continent);
        em.getTransaction().commit();
        em.close();
    }
    public Continent findByID(int ID) {
        EntityManager em = (EntityManager) EntityManagerSolo.getInstance().getEntity();
        Continent m =
                (Continent) em.createNamedQuery("Continent.findById").setParameter("id", ID).getSingleResult();
        em.close();
        return m;

    }
    public Continent findByName(String name) {
        EntityManager em = (EntityManager) EntityManagerSolo.getInstance().getEntity();
        Continent m =
                (Continent) em.createNamedQuery("Continent.findByName").setParameter("name", name).getSingleResult();
        em.close();
        return m;

    }
    public Continent findAll() {
        EntityManager em = (EntityManager) EntityManagerSolo.getInstance().getEntity();
        Continent m =
                (Continent) em.createNamedQuery("Continent.findAll").getSingleResult();
        em.close();
        return m;

    }
}
