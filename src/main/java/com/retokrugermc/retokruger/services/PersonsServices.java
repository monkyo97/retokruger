package com.retokrugermc.retokruger.services;

import com.retokrugermc.retokruger.dto.CreatePersonRequest;
import com.retokrugermc.retokruger.models.Employee;
import com.retokrugermc.retokruger.models.Person;
import com.retokrugermc.retokruger.repository.EmployeeRepository;
import com.retokrugermc.retokruger.repository.PersonsRepository;
import com.retokrugermc.retokruger.validations.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PersonsServices implements IPersonsService {

    @Autowired
    private PersonsRepository personsRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Person savePerson(@RequestBody CreatePersonRequest request) {

        Validation validation = new Validation();
        String passwordEncrypt= request.getIdentification();

        if(request.getLastName().isEmpty() || request.getFirstName().isEmpty() || request.getEmail().isEmpty() || request.getIdentification().isEmpty()) {
            System.out.println("campos vacios");
            return null;
        }else if(!validation.requireNumbers(request.getIdentification())) {
            System.out.println("solo numeros identificador");
            return null;
        }else if(!validation.lengthIdentification(request.getIdentification())) {
            System.out.println("solo 10 numeros");
            return null;
        }else if(!validation.requireText(request.getFirstName()) || !validation.requireText(request.getLastName())) {
            System.out.println("Nombre o Apellido No Valido");
            return null;
        }else if(!validation.validateEmail(request.getEmail())) {
            System.out.println("Email No Valido");
            return null;
        }else{
        Person person = Person.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .identification(request.getIdentification())
                .email(request.getEmail())
                .nameUser(request.getEmail())
                .passwordUser(passwordEncoder.encode(passwordEncrypt))
                .rol("Employee")
                .build();
        personsRepository.save(person);

        saveEmployee(Integer .valueOf(person.getPersonId()));

            return person;
        }
    }

    @Override
    public void saveEmployee(Integer id) {
        Employee employee = Employee.builder()
                .personId(id)
                .build();
        employeeRepository.save(employee);
    }

    @Override
    public List<Person> findAll() {
        var persons = (List<Person>) personsRepository.findAll();
        return persons;
    }

    public void deleteById(Integer id) {
        personsRepository.deleteById(id);
    }

    @Override
    public Person findById(Integer id) {
        System.out.println(id);
        return personsRepository.findById(id).orElse(null);
    }

    @Override
    public Person updatePerson(@RequestBody CreatePersonRequest request, @PathVariable (value = "id") Integer id ) {

        Person personData = personsRepository.findById(id).orElse(null);
        Validation validation = new Validation();

        if(request.getLastName().isEmpty() || request.getFirstName().isEmpty() || request.getEmail().isEmpty() || request.getIdentification().isEmpty()) {
            System.out.println("campos vacios");
            return null;
        }else if(!validation.requireNumbers(request.getIdentification())) {
            System.out.println("solo numeros identificador");
            return null;
        }else if(!validation.lengthIdentification(request.getIdentification())) {
            System.out.println("solo 10 numeros");
            return null;
        }else if(!validation.requireText(request.getFirstName()) || !validation.requireText(request.getLastName())) {
            System.out.println("Nombre o Apellido No Valido");
            return null;
        }else if(!validation.validateEmail(request.getEmail())) {
            System.out.println("Email No Valido");
            return null;
        }else {
            personData.setIdentification(request.getIdentification());
            personData.setFirstName(request.getFirstName());
            personData.setLastName(request.getLastName());
            personData.setEmail(request.getEmail());

            personsRepository.save(personData);

            return personData;
        }
    }

}
