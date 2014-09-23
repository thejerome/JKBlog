package com.efimchick.jkblog.dao.mock;

import com.efimchick.jkblog.dao.PersonDao;
import com.efimchick.jkblog.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jerome on 16.04.2014.
 */
public class PersonDaoMock implements PersonDao {

    @Override
    public Person findById(Long id) {
        return MockModel.instance.persons.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public Person save(Person person) {
        synchronized (MockModel.instance.persons) {
            delete(person);
            MockModel.instance.persons.add(person);
        }
        return person;
    }

    @Override
    public void delete(Person person) {
        MockModel.instance.persons.remove(findById(person.getId()));
    }

    @Override
    public List<Person> findAll(int pageNumber, int perPage) {
        return MockModel.instance.persons.stream().collect(Collectors.toList());
    }


}
