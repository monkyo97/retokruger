package com.retokrugermc.retokruger.services;


import com.retokrugermc.retokruger.dto.CreatePersonRequest;
import com.retokrugermc.retokruger.models.Person;

import java.util.List;

public interface IPersonsService {

    List<Person> findAll();

    void deleteById(Integer id);

    Person findById(Integer id);

    Person updatePerson(CreatePersonRequest request, Integer id);

    Person savePerson(CreatePersonRequest request);

    void saveEmployee(Integer id);

}
