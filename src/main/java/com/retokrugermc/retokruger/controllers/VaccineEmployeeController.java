package com.retokrugermc.retokruger.controllers;

import com.retokrugermc.retokruger.dto.CreateVaccineEmployeeRequest;
import com.retokrugermc.retokruger.services.VaccineEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class VaccineEmployeeController {

    @Autowired
    private VaccineEmployeeService vaccineEmployeeService;

    @GetMapping("/vaccineEmployee")
    public ResponseEntity<?> getAllVaccineEmployee(@RequestParam(required = false) String vaccineEmployee){
        return ResponseEntity.ok(vaccineEmployeeService.findAll());
    }

    @PostMapping("/vaccineEmployee/{id}")
    public ResponseEntity<?> saveVaccineEmployee(@RequestBody CreateVaccineEmployeeRequest request, @PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(vaccineEmployeeService.saveVaccineEmployee(request,id));
    }

}
