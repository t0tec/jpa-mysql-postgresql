package org.t0tec.tutorials.jmp.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@Entity
@Table(name = "result")
public class Result {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;

  @Column(name = "number")
  private int driverNumber;

  @Column(name = "grid")
  private Integer gridPosition;

  @Column(name = "position")
  private Integer position;

  @Column(name = "position_order")
  private int positionOrder;

  @Column(name = "points")
  private double points;

  @Column(name = "laps")
  private int laps;

  @Column(name = "rank")
  private int rank;

  @Column(name = "race_time")
  private int raceTime;

  // TODO: remove fastestLap and fastestLapTime and introduce LapTime to reference it?
  @Column(name = "fastest_lap")
  private int fastestLap;

  @Column(name = "fastest_lap_time")
  private int fastestLapTime;

  @Column(name = "average_speed", columnDefinition = "decimal(5,2)")
  private double averageSpeed;

  @OneToOne
  @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
  private Status status;

  public Result() {
  }

  public long getId() {
    return this.id;
  }

  public int getDriverNumber() {
    return this.driverNumber;
  }

  public Integer getGridPosition() {
    return this.gridPosition;
  }

  public Integer getPosition() {
    return this.position;
  }

  public int getPositionOrder() {
    return this.positionOrder;
  }

  public double getPoints() {
    return this.points;
  }

  public int getLaps() {
    return this.laps;
  }

  public int getRank() {
    return this.rank;
  }

  public int getRaceTime() {
    return this.raceTime;
  }

  public int getFastestLap() {
    return this.fastestLap;
  }

  public int getFastestLapTime() {
    return this.fastestLapTime;
  }

  public double getAverageSpeed() {
    return this.averageSpeed;
  }

  public Status getStatus() {
    return this.status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
