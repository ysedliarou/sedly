package org.gendao.dao.search.hibernate;

import org.gendao.dao.search.person.PersonSearchData;
import org.gendao.model.Person;
import org.hibernate.Session;

import java.util.List;

public class PersonSearchStrategyFactory implements org.gendao.dao.search.person.PersonSearchStrategyFactory {

    public final static String BY_NAME_QUERY = "from Person p where p.name = :name";

    public static class ByName extends AbstractSearchStrategy<List<Person>, PersonSearchData, Person, Integer> {
        @Override
        public List<Person> hibernateSearch(PersonSearchData searchData, Session session) {
            return session.createQuery(BY_NAME_QUERY)
                    .setString("name", searchData.getName())
                    .list();
        }
    }

    @Override
    public AbstractSearchStrategy<List<Person>, PersonSearchData, Person, Integer> byName() {
        return new ByName();
    }

}
