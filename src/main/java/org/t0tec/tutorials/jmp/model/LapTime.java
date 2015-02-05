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
@Table(name = "lap_time")
public class LapTime implements Serializable {

  @Id
  @ManyToOne
  @JoinColumn(name = "race_id", referencedColumnName = "id", nullable = false)
  private Race race;

  @Id
  @ManyToOne
  @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
  private Driver driver;

  @Id
  @Column(name = "lap")
  private int lap;

  @Column(name = "position")
  private int position;

  @Column(name = "time")
  private int time;
}
