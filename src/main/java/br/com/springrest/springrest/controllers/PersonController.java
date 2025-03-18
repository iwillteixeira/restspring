package br.com.springrest.springrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.springrest.springrest.dto.v1.PersonDTO;
import br.com.springrest.springrest.dto.v2.PersonDTOV2;
import br.com.springrest.springrest.model.Person;
import br.com.springrest.springrest.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonServices service;

    @RequestMapping(
        method=RequestMethod.GET,
        produces=MediaType.APPLICATION_JSON_VALUE)

    public List<PersonDTO> findAll(){
        return service.findAll();
    }
    
    @RequestMapping(value = "/{id}", 
        method=RequestMethod.GET,
        produces=MediaType.APPLICATION_JSON_VALUE)

    public PersonDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", 
        method=RequestMethod.DELETE
        )

    public void delete(@PathVariable("id") Long id){
         service.delete(id);
    }

    @RequestMapping(
        method=RequestMethod.POST,
        consumes=MediaType.APPLICATION_JSON_VALUE,
        produces=MediaType.APPLICATION_JSON_VALUE)

    public PersonDTO create(@RequestBody PersonDTO person){
        return service.create(person);
    }

    @PostMapping(value = "/v2",
        consumes=MediaType.APPLICATION_JSON_VALUE,
        produces=MediaType.APPLICATION_JSON_VALUE)

    public PersonDTOV2 create(@RequestBody PersonDTOV2 person){
        return service.createV2(person);
    }

    @RequestMapping(
        method=RequestMethod.PUT,
        consumes=MediaType.APPLICATION_JSON_VALUE,
        produces=MediaType.APPLICATION_JSON_VALUE)

    public PersonDTO update(@RequestBody PersonDTO person){
        return service.update(person);
    }
    
}
