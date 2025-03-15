package br.com.springrest.springrest.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springrest.springrest.exception.ResourceNotFoundException;
import br.com.springrest.springrest.exception.handler.CustomEntityResponseHandler;
import br.com.springrest.springrest.model.Person;
import br.com.springrest.springrest.repository.PersonRepository;

@Service
public class PersonServices {

    private final CustomEntityResponseHandler customEntityResponseHandler;
    
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    PersonServices(CustomEntityResponseHandler customEntityResponseHandler) {
        this.customEntityResponseHandler = customEntityResponseHandler;
    }
    
    public List<Person> findAll(){
        return repository.findAll();
        
    }

    public Person create(Person person){
        logger.info("creating one person");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one person");
        Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("no records") );
   
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting one person");
        Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no records") );
        repository.delete(entity);
    }

    public Person findById(Long id){
        logger.info("Finding one Person");
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no records") );
    }

}
