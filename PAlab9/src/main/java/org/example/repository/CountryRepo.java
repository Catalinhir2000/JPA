package org.example.repository;

import org.example.database.EntityManagerSolo;
import org.example.enitites.Country;

import javax.persistence.EntityManager;

public class CountryRepo {
    public void create(Country country) {
        EntityManager em = (EntityManager) EntityManagerSolo.getInstance().getEntity();
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        em.close();
    }

    public Country findAll() {
        EntityManager em = (EntityManager) EntityManagerSolo.getInstance().getEntity();
        Country c = (Country) em.createNamedQuery("Country.findAll").getSingleResult();
        em.close();
        return c;
    }

    public Country findByName(String name) {
        EntityManager em = (EntityManager) EntityManagerSolo.getInstance().getEntity();
        Country c = (Country) em.createNamedQuery("Country.findByName").setParameter("name", name).getSingleResult();
        em.close();
        return c;
    }

    public Country findById(int id) {
        EntityManager em = (EntityManager) EntityManagerSolo.getInstance().getEntity();
        Country c = (Country) em.createNamedQuery("Country.findById").setParameter("id", id).getSingleResult();
        em.close();
        return c;
    }
}
