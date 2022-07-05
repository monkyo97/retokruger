package com.retokrugermc.retokruger.controllers;

import com.retokrugermc.retokruger.dto.EditEmployeeRequest;
import com.retokrugermc.retokruger.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<?> getAllEmployee(@RequestParam(required = false) String persons){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PutMapping("/employeeupdate/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody EditEmployeeRequest request, @PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(employeeService.updateEmployee(request,id));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> findById(@PathVariable (value = "id") Integer id ){
        return ResponseEntity.ok(employeeService.findById(id));
    }


}
