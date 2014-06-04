package org.gendao.model;

public class Person extends DomainObject<Integer> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
