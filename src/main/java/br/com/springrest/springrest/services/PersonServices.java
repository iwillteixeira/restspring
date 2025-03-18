package br.com.springrest.springrest.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springrest.springrest.dto.PersonDTO;
import br.com.springrest.springrest.exception.ResourceNotFoundException;
import br.com.springrest.springrest.exception.handler.CustomEntityResponseHandler;
import br.com.springrest.springrest.mapper.ObjectMapper;
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
    
    public List<PersonDTO> findAll(){
        return ObjectMapper.parseListOBjects(repository.findAll(), PersonDTO.class);
        
    }

    public PersonDTO create(PersonDTO person){
        logger.info("creating one person");
        var entity = ObjectMapper.parseObject(person, Person.class);
        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class) ;
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Updating one person");
        Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("no records") );
   
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Deleting one person");
        Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no records") );
        repository.delete(entity);
    }

    public PersonDTO findById(Long id){
        logger.info("Finding one Person");
        var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no records") );
        return ObjectMapper.parseObject(entity, PersonDTO.class);

    }

}
