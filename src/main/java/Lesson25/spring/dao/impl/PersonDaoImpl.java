package Lesson25.spring.dao.impl;

import Lesson25.spring.dao.PersonDAO;

public class PersonDaoImpl implements PersonDAO {
    @Override
    public void save(){
        System.out.println("Person has been successfully saved");
    }
}
