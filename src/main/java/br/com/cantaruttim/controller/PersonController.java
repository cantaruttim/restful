package br.com.cantaruttim.controller;

import br.com.cantaruttim.data.v1.PersonDTO;
import br.com.cantaruttim.data.v2.PersonDTOv2;
import br.com.cantaruttim.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    //private PersonDTOServices service = new PersonDTOServices()
    @Autowired
    private PersonServices service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE, // consome
            produces = MediaType.APPLICATION_JSON_VALUE // produz
    )
    // possibilita pegar o corpo e armazenar o dado
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @PostMapping(
            value = "/v2",
            consumes = MediaType.APPLICATION_JSON_VALUE, // consome
            produces = MediaType.APPLICATION_JSON_VALUE // produz
    )

    public PersonDTOv2 create(@RequestBody PersonDTOv2 person) {
        return service.createv2(person);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE, // consome
            produces = MediaType.APPLICATION_JSON_VALUE // produz
    )
    // possibilita pegar o corpo e armazenar o dado
    public PersonDTO update(@RequestBody PersonDTO PersonDTO) {
        return service.update(PersonDTO);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
