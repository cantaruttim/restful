package br.com.cantaruttim.service;

import br.com.cantaruttim.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    // operacoes para cadastrar uma pessoa

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all People!");

        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Address " + i);
        person.setGender("Gender " + i);

        return person;
    }


    public Person findById(String id) {
        logger.info("Finding One Person!");


        // é aqui que acessamos a base de dados e obtemos os dados reais de
        // uma aplicacao
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Matheus");
        person.setLastName("Cantarutti");
        person.setAddress("São Paulo");
        person.setGender("Masculino");

        return person;
    }

    public Person create(Person person) {
        logger.info("Creating One Person!");

        return person;
    }


}
