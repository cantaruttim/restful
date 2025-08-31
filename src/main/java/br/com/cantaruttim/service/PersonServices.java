package br.com.cantaruttim.service;

import br.com.cantaruttim.data.v1.PersonDTO;
import br.com.cantaruttim.data.v2.PersonDTOv2;
import br.com.cantaruttim.exception.ResourceNotFoundException;
import static br.com.cantaruttim.mapper.ObjectMapper.parseListObject;
import static br.com.cantaruttim.mapper.ObjectMapper.parseObject;

import br.com.cantaruttim.mapper.custom.PersonMapper;
import br.com.cantaruttim.model.Person;
import br.com.cantaruttim.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;


@Service
public class PersonServices {

    // operacoes para cadastrar uma pessoa

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;


    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");
        return parseListObject(
                repository.findAll(),
                PersonDTO.class
        );
    }


    public PersonDTO findById(Long id) {
        logger.info("Finding One Person!");

        var entity = repository.findById(id)
                .orElseThrow(
                        // lambda funtion
                        () -> new ResourceNotFoundException(
                                "No records found for this ID"
                        )
                );
        return parseObject(entity, PersonDTO.class);

    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating One Person!");
        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOv2 createv2(PersonDTOv2 person) {
        logger.info("Creating One Person V2!");
        var entity = converter.convertDTOtoEntity(person);
        return converter.convertEntityToDTO(repository.save(entity));
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

    public PersonDTO update(PersonDTO person) {
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

        return parseObject(repository.save(entity), PersonDTO.class);
    }

}
