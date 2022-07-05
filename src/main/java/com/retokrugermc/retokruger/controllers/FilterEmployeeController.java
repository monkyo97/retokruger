package com.retokrugermc.retokruger.controllers;

import com.retokrugermc.retokruger.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class FilterEmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/filterstatusvaccine/{status}")
    private List<?>findByState(@PathVariable(value = "status") Integer status){
        return employeeRepository.findByState(status);
    }

    @GetMapping("/filternamevaccine/{name}")
    private List<?> findByVaccineName(@PathVariable(value = "name") String status){
        return employeeRepository.findByVaccineName(status);
    }

    @GetMapping("/filterdatevaccine")
    private List<?> findByVaccineDate(@RequestParam Date datein, @RequestParam Date dateout){
        return employeeRepository.findByVaccineDate(datein,dateout);
    }

}
