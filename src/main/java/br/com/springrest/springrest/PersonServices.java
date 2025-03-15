package br.com.springrest.springrest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.springrest.springrest.exception.handler.CustomEntityResponseHandler;
import br.com.springrest.springrest.model.Person;

@Service
public class PersonServices {

    private final CustomEntityResponseHandler customEntityResponseHandler;
    
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    PersonServices(CustomEntityResponseHandler customEntityResponseHandler) {
        this.customEntityResponseHandler = customEntityResponseHandler;
    }
    
    public List<Person> findAll(){
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person){
        logger.info("creating one person");
        return person;
    }

    public Person update(Person person){
        logger.info("Updating one person");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting one person");
    }

    public Person findById(String id){
        logger.info("Finding one Person");
        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAdress("Uberlandia - Minas Gerais - Brasil");
        person.setGender("Male");
        return person;
    }
    private Person mockPerson(int i) {
        // TODO Auto-generated method stub
        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("FirstName" + i);
        person.setLastName("LastName" + i);
        person.setAdress("Uberlandia - Minas Gerais - Brasil");
        person.setGender("Male");
        return person;
    }
}
