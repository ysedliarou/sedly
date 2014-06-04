package org.gendao.dao.search.hibernate;

import org.gendao.dao.search.SearchData;
import org.gendao.dao.search.SearchStrategy;
import org.gendao.model.DomainObject;
import org.hibernate.Session;

import java.io.Serializable;

public abstract class AbstractSearchStrategy<R, SD extends SearchData, T extends DomainObject<ID>, ID extends Serializable>
        implements SearchStrategy<R, SD, T, ID> {

    @Override
    public final R search(SD searchData, Object searchProvider) {
        return hibernateSearch(searchData, (Session) searchProvider);
    }

    public abstract R hibernateSearch(SD searchData, Session session);

}
