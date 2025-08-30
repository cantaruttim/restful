package br.com.cantaruttim.controller;

import br.com.cantaruttim.model.Person;
import br.com.cantaruttim.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    //private PersonServices service = new PersonServices()
    @Autowired
    private PersonServices service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE, // consome
            produces = MediaType.APPLICATION_JSON_VALUE // produz
    )
    // possibilita pegar o corpo e armazenar o dado
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE, // consome
            produces = MediaType.APPLICATION_JSON_VALUE // produz
    )
    // possibilita pegar o corpo e armazenar o dado
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }


    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
