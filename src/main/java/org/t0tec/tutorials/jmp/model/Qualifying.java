package org.t0tec.tutorials.jmp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@Entity
@Table(name = "qualifying")
public class Qualifying implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;

  @ManyToOne
  @JoinColumn(name = "race_id", referencedColumnName = "id", nullable = false)
  private Race race;

  @ManyToOne
  @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
  private Driver driver;

  @ManyToOne
  @JoinColumn(name = "constructor_id", referencedColumnName = "id", nullable = false)
  private Constructor constructor;

  @Column(name = "number")
  private int driverNumber;

  @Column(name = "position")
  private int position;

  @Column(name = "q1")
  private int q1;

  @Column(name = "q2")
  private int q2;

  @Column(name = "q3")
  private int q3;

  public Qualifying() {
  }

  public Qualifying(Race race, Driver driver, Constructor constructor, int driverNumber,
                    int position,
                    int q1, int q2, int q3) {
    this.race = race;
    this.driver = driver;
    this.constructor = constructor;
    this.driverNumber = driverNumber;
    this.position = position;
    this.q1 = q1;
    this.q2 = q2;
    this.q3 = q3;
  }

  public long getId() {
    return this.id;
  }

  public Race getRace() {
    return this.race;
  }

  public Driver getDriver() {
    return this.driver;
  }

  public Constructor getConstructor() {
    return this.constructor;
  }

  public int getDriverNumber() {
    return this.driverNumber;
  }

  public int getPosition() {
    return this.position;
  }

  public int getQ1() {
    return this.q1;
  }

  public int getQ2() {
    return this.q2;
  }

  public int getQ3() {
    return this.q3;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    Qualifying that = (Qualifying) o;

    if (!this.driver.equals(that.driver)) {
      return false;
    }
    if (!this.race.equals(that.race)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = this.race.hashCode();
    result = 31 * result + this.driver.hashCode();
    return result;
  }
}
