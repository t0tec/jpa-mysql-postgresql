package org.t0tec.tutorials.jmp.persistence;

import org.t0tec.tutorials.jmp.model.Status;

/**
 * @author t0tec (t0tec.olmec@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class StatusUserType extends PersistentStatusEnumUserType<Status> {

  public StatusUserType() {
    super(Status.class);
  }
}
