package com.retokrugermc.retokruger.controllers;

import com.retokrugermc.retokruger.dto.CreatePersonRequest;
import com.retokrugermc.retokruger.services.PersonsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PersonsController {

    @Autowired
    private PersonsServices personsServices;

    @GetMapping("/persons")
    public ResponseEntity<?> getAllPersons(@RequestParam(required = false) String persons){
        return ResponseEntity.ok(personsServices.findAll());
    }

    @PostMapping("/person")
    public ResponseEntity<?> savePerson(@RequestBody CreatePersonRequest request){
        return ResponseEntity.ok(personsServices.savePerson(request));
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<?> updatePerson(@RequestBody CreatePersonRequest request, @PathVariable (value = "id") Integer id ){
        return ResponseEntity.ok(personsServices.updatePerson(request,id));
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<?> findById(@PathVariable (value = "id") Integer id ){
        return ResponseEntity.ok(personsServices.findById(id));
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable (value = "id") Integer id ){
        personsServices.deleteById(id);
    }

}
