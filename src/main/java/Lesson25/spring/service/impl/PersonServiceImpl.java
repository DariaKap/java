package Lesson25.spring.service.impl;

import Lesson25.spring.dao.PersonDAO;
import Lesson25.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @Override
    public void print(){
        personDAO.save();
    }
}
