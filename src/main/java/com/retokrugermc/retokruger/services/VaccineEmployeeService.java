package com.retokrugermc.retokruger.services;

import com.retokrugermc.retokruger.dto.CreateVaccineEmployeeRequest;
import com.retokrugermc.retokruger.models.Employee;
import com.retokrugermc.retokruger.models.VaccineEmployee;
import com.retokrugermc.retokruger.repository.EmployeeRepository;
import com.retokrugermc.retokruger.repository.VaccineEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineEmployeeService implements IVaccineEmployeeService {

    @Autowired
    private VaccineEmployeeRepository vaccineEmployeeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<VaccineEmployee> findAll() {
        return (List<VaccineEmployee>) vaccineEmployeeRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public VaccineEmployee findById(Integer id) {
        return vaccineEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public VaccineEmployee updateVaccineEmployee(CreateVaccineEmployeeRequest request, Integer id) {
        return null;
    }

    @Override
    public VaccineEmployee saveVaccineEmployee(CreateVaccineEmployeeRequest request, Integer id) {
        Employee employeeData = employeeRepository.findById(id).orElse(null);

        if(employeeData.getVaccineStatus()== 1){
            VaccineEmployee vaccineEmployee = VaccineEmployee.builder()
                    .nameVaccine(request.getNameVaccine())
                    .dateVaccine(request.getDateVaccine())
                    .numberOfDosis(request.getNumberOfDosis())
                    .employeeId(id)
                    .build();
            vaccineEmployeeRepository.save(vaccineEmployee);
            return vaccineEmployee;
        }else{
            return null;
        }
    }

}
