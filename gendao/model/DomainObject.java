package org.gendao.model;

import java.io.Serializable;

public class DomainObject<ID extends Serializable> {

    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

}
