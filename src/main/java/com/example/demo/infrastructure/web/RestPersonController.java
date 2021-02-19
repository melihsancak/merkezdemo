package com.example.demo.infrastructure.web;

import com.example.demo.domain.Person;
import com.example.demo.domain.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
public class RestPersonController {

    private static final Logger logger = LoggerFactory.getLogger(RestPersonController.class);

    private final PersonService personService;

    public RestPersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id) {
        return  personService.retrievePersonById(id);
    }


    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @DeleteMapping("/books/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        logger.info("Person is deleted with id:" + id);
    }

}
