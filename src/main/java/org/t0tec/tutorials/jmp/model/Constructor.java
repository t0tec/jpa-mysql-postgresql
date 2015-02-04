package org.t0tec.tutorials.jmp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@Entity
@Table(name = "constructor")
public class Constructor implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;

  @Column(name = "reference_name", nullable = false)
  private String referenceName;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "country")
  private String country;

  @Column(name = "base")
  private String base;

  @Column(name = "url", length = 500)
  private String url;

  public Constructor() {
  }

  public Constructor(String referenceName, String name, String country, String base, String url) {
    this.referenceName = referenceName;
    this.name = name;
    this.country = country;
    this.base = base;
    this.url = url;
  }

  public long getId() {
    return this.id;
  }

  public String getReferenceName() {
    return this.referenceName;
  }

  public String getName() {
    return this.name;
  }

  public String getCountry() {
    return this.country;
  }

  public String getBase() {
    return this.base;
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

    Constructor that = (Constructor) o;

    if (!this.referenceName.equals(that.referenceName)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return this.referenceName.hashCode();
  }
}
