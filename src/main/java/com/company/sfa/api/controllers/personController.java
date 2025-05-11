package com.company.sfa.api.controllers;

import com.company.sfa.api.DTO.PersonDTO;
import com.company.sfa.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class personController {
    private PersonService personService;
    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping("addPerson")
    public String addPerson(@RequestBody PersonDTO personDTO){
        return personService.addPerson(personDTO);
    }
}
