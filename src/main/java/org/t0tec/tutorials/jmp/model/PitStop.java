package org.t0tec.tutorials.jmp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "pit_stop")
public class PitStop implements Serializable {

  @Id
  @ManyToOne
  @JoinColumn(name = "race_id", referencedColumnName = "id", nullable = false)
  private Race race;

  @Id
  @ManyToOne
  @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
  private Driver driver;

  @Id
  @Column(name = "stop")
  private int stop;

  @Column(name = "lap")
  private int lap;

  @Column(name = "duration")
  private int duration;

  public PitStop() {
  }

  public PitStop(Race race, Driver driver, int stop, int lap, int duration) {
    this.race = race;
    this.driver = driver;
    this.stop = stop;
    this.lap = lap;
    this.duration = duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    PitStop that = (PitStop) o;

    if (this.stop != that.stop) {
      return false;
    }
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
    result = 31 * result + this.stop;
    return result;
  }
}
