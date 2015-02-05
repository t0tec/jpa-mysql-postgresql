package org.t0tec.tutorials.jmp.persistence;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public abstract class PersistentStatusEnumUserType<T extends Enum<T>> implements UserType {

  private Class<T> clazz = null;

  protected PersistentStatusEnumUserType(Class<T> c) {
    this.clazz = c;
  }

  private static final int[] SQL_TYPES = {Types.VARCHAR};

  public int[] sqlTypes() {
    return SQL_TYPES;
  }

  public Class returnedClass() {
    return clazz;
  }

  @Override
  public Object nullSafeGet(ResultSet resultSet, String[] names,
                            SessionImplementor sessionImplementor, Object o)
      throws HibernateException, SQLException {
    String name = resultSet.getString(names[0]);
    T result = null;
    if (!resultSet.wasNull()) {
      result = Enum.valueOf(clazz, name);
    }
    return result;
  }

  @Override
  public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index,
                          SessionImplementor sessionImplementor)
      throws HibernateException, SQLException {
    if (null == value) {
      preparedStatement.setNull(index, Types.VARCHAR);
    } else {
      preparedStatement.setString(index, ((Enum) value).name());
    }
  }

  public Object deepCopy(Object value) throws HibernateException {
    return value;
  }

  public boolean isMutable() {
    return false;
  }

  public Object assemble(Serializable cached, Object owner) throws HibernateException {
    return cached;
  }

  public Serializable disassemble(Object value) throws HibernateException {
    return (Serializable) value;
  }

  public Object replace(Object original, Object target, Object owner) throws HibernateException {
    return original;
  }

  public int hashCode(Object x) throws HibernateException {
    return x.hashCode();
  }

  public boolean equals(Object x, Object y) throws HibernateException {
    if (x == y) {
      return true;
    }
    if (null == x || null == y) {
      return false;
    }
    return x.equals(y);
  }
}
