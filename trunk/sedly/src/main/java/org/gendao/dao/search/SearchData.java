package org.gendao.dao.search;

import org.gendao.model.DomainObject;

import java.io.Serializable;

public class SearchData<T extends DomainObject<ID>, ID extends Serializable> {

    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

}
