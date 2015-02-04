package org.t0tec.tutorials.jmp;

import org.t0tec.tutorials.jmp.persistence.PersistentEnumUserType;

/**
 *
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class GenderUserType extends PersistentEnumUserType<Gender> {

  @Override
  public Class<Gender> returnedClass() {
    return Gender.class;
  }

}
