package com.retokrugermc.retokruger.services;

import com.retokrugermc.retokruger.dto.CreateVaccineEmployeeRequest;
import com.retokrugermc.retokruger.models.VaccineEmployee;

import java.util.List;

public interface IVaccineEmployeeService {

    List<VaccineEmployee> findAll();

    void deleteById(Integer id);

    VaccineEmployee findById(Integer id);

    VaccineEmployee updateVaccineEmployee(CreateVaccineEmployeeRequest request, Integer id);

    VaccineEmployee saveVaccineEmployee(CreateVaccineEmployeeRequest request, Integer id);

}
