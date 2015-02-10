package org.t0tec.tutorials.jmp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.t0tec.tutorials.jmp.model.Circuit;
import org.t0tec.tutorials.jmp.model.Driver;
import org.t0tec.tutorials.jmp.model.Gender;
import org.t0tec.tutorials.jmp.model.Race;
import org.t0tec.tutorials.jmp.model.Season;
import org.t0tec.tutorials.jmp.persistence.CustomPersistence;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class Main {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    testJPAImplementation("jpa-mysql");
    testJPAImplementation("jpa-postgresql");
  }

  private static void testJPAImplementation(final String persistenceUnit) {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    try {
      emf = CustomPersistence.createEntityManagerFactory(persistenceUnit);
      em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();

      GregorianCalendar birthdate = new GregorianCalendar();
      birthdate.setLenient(false);
      birthdate.set(1985, 0, 7);

      Driver hamilton =
          new Driver("Hamilton", 44, "HAM", "Lewis", "Hamilton", birthdate.getTime(), "British",
                     Gender.MALE,
                     "http://en.wikipedia.org/wiki/Lewis_Hamilton");

//      birthdate.set(1941, 2, 26);
//      Driver lombardi =
//          new Driver("Lombardi", null, "LOM", "Lella", "Lombardi", birthdate.getTime(), "Italian",
//                     Gender.FEMALE, "http://en.wikipedia.org/wiki/Lella_Lombardi");

      tx.begin();
      em.persist(hamilton);
      tx.commit();

      logger.info("Inserted id: {}", hamilton.getId());

    } catch (Exception e) {
      logger.error("failed: " + e.getMessage());
    } finally {
      if (em != null) {
        em.close();
      }

      if (emf != null) {
        emf.close();
      }
    }

  }

  private static void createRace(final String persistenceUnit) {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    try {
      emf = CustomPersistence.createEntityManagerFactory(persistenceUnit);
      em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();

      GregorianCalendar birthdate = new GregorianCalendar();
      birthdate.setLenient(false);
      birthdate.set(1985, 0, 7);

      Season season = new Season(2015, "wiki_2015_season");

      Circuit circuit =
          new Circuit("Melbourne", "Melbourne Grand Prix Circuit", "Albert Park", "Australia",
                      -37.849722,
                      144.968333, 5.303, 16,
                      "http://en.wikipedia.org/wiki/Melbourne_Grand_Prix_Circuit");

      GregorianCalendar date = new GregorianCalendar();
      date.setLenient(false);
      date.set(2015, 2, 15);

      GregorianCalendar time = new GregorianCalendar();
      time.set(GregorianCalendar.HOUR_OF_DAY, 16);
      time.set(GregorianCalendar.MINUTE, 00);
      time.set(GregorianCalendar.SECOND, 00);

      Race race =
          new Race(season, circuit, 1, "Australian Grand Prix", date.getTime(), time.getTime(),
                   "wiki_melbourne_race_2015");

      tx.begin();
      em.persist(season);

      em.persist(circuit);

      em.persist(race);

      tx.commit();

      logger.info("Inserted id: {}", race.getId());

    } catch (Exception e) {
      logger.error("failed: " + e.getMessage());
    } finally {
      if (em != null) {
        em.close();
      }

      if (emf != null) {
        emf.close();
      }
    }
  }

}
