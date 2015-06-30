package org.gendao.dao;

import org.gendao.model.DomainObject;

import java.io.Serializable;

public interface Dao<T extends DomainObject<ID>, ID extends Serializable> {

    Class<T> getDaoClass();

    T find(ID id);

}
