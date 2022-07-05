package com.retokrugermc.retokruger.services;

import com.retokrugermc.retokruger.dto.EditEmployeeRequest;
import com.retokrugermc.retokruger.models.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    Employee updateEmployee(EditEmployeeRequest request, Integer id);

    Employee findById(Integer id);

}
