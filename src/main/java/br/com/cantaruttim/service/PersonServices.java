package br.com.cantaruttim.service;

import br.com.cantaruttim.exception.ResourceNotFoundException;
import br.com.cantaruttim.model.Person;
import br.com.cantaruttim.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class PersonServices {

    // operacoes para cadastrar uma pessoa

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;


    public List<Person> findAll() {
        logger.info("Finding all People!");
        return repository.findAll();
    }


    public Person findById(Long id) {
        logger.info("Finding One Person!");

        return repository.findById(id)
                .orElseThrow(
                        // lambda funtion
                        () -> new ResourceNotFoundException(
                                "No records found for this ID"
                        )
                );
    }

    public Person create(Person person) {
        logger.info("Creating One Person!");
        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting One Person!");
        Person entity = repository
                .findById(id)
                .orElseThrow(
                        // lambda funtion
                        () -> new ResourceNotFoundException(
                                "No records found for this ID"
                        )
                );
        repository.delete(entity);
    }

    public Person update(Person person) {
        logger.info("Updating One Person!");

        Person entity = repository
                    .findById(person.getId())
                    .orElseThrow(
                        // lambda funtion
                        () -> new ResourceNotFoundException(
                                "No records found for this ID"
                        )
                    );

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        // nao deve ser entity?
        return repository.save(entity);
    }

}
