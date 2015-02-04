package org.t0tec.tutorials.jmp;

import org.t0tec.tutorials.jmp.persistence.PersistentEnum;

/**
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public enum Gender implements PersistentEnum {
  MALE('M'),
  FEMALE('F');

  private final Character id;

  Gender(Character id) {
    this.id = id;
  }

  @Override
  public Character getId() {
    return id;
  }
}
