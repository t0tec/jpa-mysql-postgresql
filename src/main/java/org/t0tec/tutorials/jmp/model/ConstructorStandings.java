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
@Table(name = "constructor_standings")
public class ConstructorStandings implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;

  @ManyToOne
  @JoinColumn(name = "race_id", referencedColumnName = "id", nullable = false)
  private Race race;

  @ManyToOne
  @JoinColumn(name = "constructor_id", referencedColumnName = "id", nullable = false)
  private Constructor constructor;

  @Column(name = "points", nullable = false)
  private double points;

  @Column(name = "position")
  private int position;

  @Column(name = "wins", nullable = false)
  private int wins;

  public ConstructorStandings() {
  }

  public ConstructorStandings(Race race, Constructor constructor, double points, int position,
                              int wins) {
    this.race = race;
    this.constructor = constructor;
    this.points = points;
    this.position = position;
    this.wins = wins;
  }

  public long getId() {
    return this.id;
  }

  public Race getRace() {
    return this.race;
  }

  public Constructor getConstructor() {
    return this.constructor;
  }

  public double getPoints() {
    return this.points;
  }

  public int getPosition() {
    return this.position;
  }

  public int getWins() {
    return this.wins;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    ConstructorStandings that = (ConstructorStandings) o;

    if (!this.constructor.equals(that.constructor)) {
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
    result = 31 * result + this.constructor.hashCode();
    return result;
  }
}
