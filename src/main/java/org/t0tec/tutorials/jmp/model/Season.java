package org.t0tec.tutorials.jmp.model;

import org.hibernate.annotations.Type;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@Entity
@Table(name = "season")
public class Season implements Serializable {

  @Id
  @Column(name = "year", columnDefinition = "smallint")
  private int year;

  @Column(name = "url", length = 500)
  private String url;

  public Season() {}

  public Season(int year, String url) {
    this.year = year;
    this.url = url;
  }

  public int getYear() {
    return this.year;
  }

  public String getUrl() {
    return this.url;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    Season season = (Season) o;

    if (this.year != season.year) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return this.year;
  }
}
