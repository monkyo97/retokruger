package com.retokrugermc.retokruger.services;


import com.retokrugermc.retokruger.dto.EditEmployeeRequest;
import com.retokrugermc.retokruger.models.Employee;
import com.retokrugermc.retokruger.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(@RequestBody EditEmployeeRequest request, @PathVariable (value = "id") Integer id ) {

        Employee employeeData = employeeRepository.findById(id).orElse(null);

        employeeData.setDateOfBirth(request.getDateOfBirth());
        employeeData.setHomeAddress(request.getHomeAddress());
        employeeData.setPhone(request.getPhone());
        employeeData.setVaccineStatus(request.getVaccineStatus());

        employeeRepository.save(employeeData);
        return employeeData;
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

}
