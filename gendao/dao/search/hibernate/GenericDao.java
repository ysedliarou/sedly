package org.gendao.dao.search.hibernate;

import org.gendao.dao.Dao;
import org.gendao.dao.search.SearchDao;
import org.gendao.dao.search.SearchData;
import org.gendao.dao.search.SearchStrategy;
import org.gendao.model.DomainObject;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

public class GenericDao<SD extends SearchData, T extends DomainObject<ID>, ID extends Serializable> extends HibernateDaoSupport
        implements Dao<T, ID>, SearchDao<SD, T, ID> {

    private Class<T> daoClass;

    public Class<T> getDaoClass() {
        return daoClass;
    }

    public void setDaoClass(Class<T> daoClass) {
        this.daoClass = daoClass;
    }

    @Override
    public T find(ID id) {
        return (T) getSession().get(getDaoClass(), id);
    }

    @Override
    public T searchOne(SD searchData, SearchStrategy<T, SD, T, ID> transformer) {
        return transformer.search(searchData, getSession());
    }

    @Override
    public List<T> searchMany(SD searchData, SearchStrategy<List<T>, SD, T, ID> transformer) {
        return transformer.search(searchData, getSession());
    }

}
