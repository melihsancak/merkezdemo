package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


    List<Person> findAll();

    Person findPersonById( Long id);

     Person save(Person person);

    void deleteById(long id);

}
