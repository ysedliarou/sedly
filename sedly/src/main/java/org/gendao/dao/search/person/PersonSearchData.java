package org.gendao.dao.search.person;

import org.gendao.dao.search.SearchData;
import org.gendao.model.Person;

public class PersonSearchData extends SearchData<Person, Integer> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
