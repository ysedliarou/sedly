package org.gendao.dao.search;

import org.gendao.model.DomainObject;

import java.io.Serializable;

public interface SearchStrategy<R, SD extends SearchData<T, ID>, T extends DomainObject<ID>, ID extends Serializable> {

    R search(SD searchData, Object searchProvider);

}
