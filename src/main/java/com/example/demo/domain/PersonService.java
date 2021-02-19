package com.example.demo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final Logger logger = LoggerFactory.getLogger(PersonService.class);


    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    public List<Person> findAll() {

        return personRepository.findAll();
    }

    public Person retrievePersonById(long id) {
        Person person = personRepository.findPersonById(id);
        return person;
    }


    public void savePerson(Person person) {
        Person person1 = personRepository.save(person);
        logger.info("Person : " + person1.toString() + "is added");
    }


    public void deletePerson(Long id) {
        personRepository.deleteById(id);
        logger.info("Person with id:" + id + "is deleted");
    }


}
