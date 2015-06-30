package org.gendao.dao.search.person;

import org.gendao.dao.search.hibernate.AbstractSearchStrategy;
import org.gendao.model.Person;

import java.util.List;

public interface PersonSearchStrategyFactory {

    AbstractSearchStrategy<List<Person>, PersonSearchData, Person, Integer> byName();

}
