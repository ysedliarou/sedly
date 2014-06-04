package org.gendao.dao.search.person;

import org.gendao.dao.search.hibernate.AbstractSearchStrategy;
import org.gendao.model.Person;
import org.hibernate.Session;

import java.util.List;

public class SearchStrategies {

    public static class ByName extends AbstractSearchStrategy<List<Person>, PersonSearchData, Person, Integer> {

        @Override
        public List<Person> hibernateSearch(PersonSearchData searchData, Session session) {
            return session.createQuery("from Person p where p.name = :name")
                    .setString("name", searchData.getName())
                    .list();
        }

    }

}
