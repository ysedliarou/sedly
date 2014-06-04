package org.gendao;

import org.gendao.dao.search.hibernate.GenericDao;
import org.gendao.dao.search.person.PersonSearchData;
import org.gendao.dao.search.person.SearchStrategies;
import org.gendao.model.Person;

public class Runner {

    public static void main(String[] args) {

        GenericDao<PersonSearchData, Person, Integer> gd = new GenericDao<>();

        PersonSearchData sd = new PersonSearchData();

        gd.searchMany(sd, new SearchStrategies.ByName());


    }



}
