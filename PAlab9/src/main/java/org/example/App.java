package org.example;

import org.example.enitites.Continent;
import org.example.repository.ContinentRepo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
//    public static void testJPA() {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("ExamplePU");
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//        Continent continent = new Continent(5, "Asia");
//        em.persist(continent);
//
//        Continent c = (Continent)em.createQuery(
//                        "select e from Continent e where e.name='Europe'")
//                .getSingleResult();
//        c.setName("Africa");
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//    }

    public static void main( String[] args )
    {
        ContinentRepo continentRepo = new ContinentRepo();
        Continent test = new Continent(5, "Asia");
        continentRepo.create(test);
        System.out.println(continentRepo.findByID(5));
        System.out.println(continentRepo.findByName("Asia"));
    }
}
