package org.t0tec.tutorials.jmp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.t0tec.tutorials.jmp.model.Circuit;
import org.t0tec.tutorials.jmp.model.Driver;
import org.t0tec.tutorials.jmp.model.Gender;
import org.t0tec.tutorials.jmp.model.Race;
import org.t0tec.tutorials.jmp.model.Result;
import org.t0tec.tutorials.jmp.model.Season;
import org.t0tec.tutorials.jmp.model.Status;
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

  private static EntityManagerFactory emfMysql;

  private static EntityManagerFactory emfPostgresql;

  public static void main(String[] args) {
    emfMysql = CustomPersistence.createEntityManagerFactory("jpa-mysql");
    emfPostgresql = CustomPersistence.createEntityManagerFactory("jpa-postgresql");

    Main main = new Main();

    main.startMysql();
    main.startPostgresql();
    main.getDriverAndCompare();
    main.createRace();
    main.createResult();

    emfMysql.close();
    emfPostgresql.close();
  }

  private void startMysql() {
    EntityManager em = emfMysql.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    GregorianCalendar birthdate = new GregorianCalendar();
    birthdate.setLenient(false);
    birthdate.set(1985, 0, 7);

    Driver hamilton =
        new Driver("Hamilton", 44, "HAM", "Lewis", "Hamilton", birthdate.getTime(), "British",
                   Gender.MALE,
                   "http://en.wikipedia.org/wiki/Lewis_Hamilton");

    em.persist(hamilton);

    // logger.info("Inserted id: {}", id);

    birthdate.set(1941, 2, 26);
    Driver lombardi =
        new Driver("Lombardi", null, "LOM", "Lella", "Lombardi", birthdate.getTime(), "Italian",
                   Gender.FEMALE, "http://en.wikipedia.org/wiki/Lella_Lombardi");

    em.persist(lombardi);

    tx.commit();
    em.close();
  }

  private void startPostgresql() {
    EntityManager em = emfPostgresql.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    GregorianCalendar birthdate = new GregorianCalendar();
    birthdate.setLenient(false);
    birthdate.set(1985, 0, 7);

    Driver hamilton =
        new Driver("Hamilton", 44, "HAM", "Lewis", "Hamilton", birthdate.getTime(), "British",
                   Gender.MALE,
                   "http://en.wikipedia.org/wiki/Lewis_Hamilton");

    em.persist(hamilton);

    // logger.info("Inserted id: {}", id);

    birthdate.set(1941, 2, 26);
    Driver lombardi =
        new Driver("Lombardi", null, "LOM", "Lella", "Lombardi", birthdate.getTime(), "Italian",
                   Gender.FEMALE, "http://en.wikipedia.org/wiki/Lella_Lombardi");

    em.persist(lombardi);

    tx.commit();
    em.close();
  }

  private void getDriverAndCompare() {
    EntityManager emPostgresql = emfPostgresql.createEntityManager();
    EntityTransaction postgresqlTx = emPostgresql.getTransaction();
    postgresqlTx.begin();

    Driver hamiltonP = emPostgresql.find(Driver.class, 1l);

    postgresqlTx.commit();
    emPostgresql.close();

    EntityManager emMysql = emfMysql.createEntityManager();
    EntityTransaction mysqlTx = emMysql.getTransaction();
    mysqlTx.begin();

    Driver hamiltonM = emMysql.find(Driver.class, 1l);

    mysqlTx.commit();
    emMysql.close();

    logger.info("Equals: {}", hamiltonP.equals(hamiltonM));
  }

  private void createRace() {

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

//    EntityManager emMysql = emfMysql.createEntityManager();
//    EntityTransaction mysqlTx = emMysql.getTransaction();
//    mysqlTx.begin();
//
//    emMysql.merge(season);
//
//    emMysql.merge(circuit);
//
//    emMysql.merge(race);
//
//    mysqlTx.commit();
//    emMysql.close();

    EntityManager emPostgresql = emfPostgresql.createEntityManager();
    EntityTransaction postgresqlTx = emPostgresql.getTransaction();
    postgresqlTx.begin();

    emPostgresql.persist(season);

    emPostgresql.persist(circuit);

    emPostgresql.persist(race);

    postgresqlTx.commit();
    emPostgresql.close();
  }

  private void createResult() {
    Result result = new Result();
    result.setStatus(Status.ACCIDENT);

        EntityManager emMysql = emfMysql.createEntityManager();
    EntityTransaction mysqlTx = emMysql.getTransaction();
    mysqlTx.begin();

    emMysql.persist(result);

    mysqlTx.commit();
    emMysql.close();
  }
}
