package br.com.cantaruttim.service;

import br.com.cantaruttim.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    // operacoes para cadastrar uma pessoa

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

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

}
