package org.gendao.service;

import org.gendao.dao.search.hibernate.GenericDao;
import org.gendao.dao.search.person.PersonSearchData;
import org.gendao.dao.search.person.PersonSearchStrategyFactory;
import org.gendao.model.Person;

import java.util.List;

public class PersonService {

    private GenericDao<PersonSearchData, Person, Integer> dao;

    private PersonSearchStrategyFactory personSearchStrategyFactory;

    public List<Person> findByName(PersonSearchData searchData) {
        return dao.searchMany(searchData, personSearchStrategyFactory.byName());
    }

}
