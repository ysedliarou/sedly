package org.gendao.dao.search;

import org.gendao.model.DomainObject;

import java.io.Serializable;
import java.util.List;

public interface SearchDao<SD extends SearchData, T extends DomainObject<ID>, ID extends Serializable> {

    T searchOne(SD searchData, SearchStrategy<T, SD, T, ID> transformer);

    List<T> searchMany(SD searchData, SearchStrategy<List<T>, SD, T, ID> transformer);

}
