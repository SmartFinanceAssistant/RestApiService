package com.company.sfa.api.controllers;

import com.company.sfa.api.DTO.GroceriesDTO;
import com.company.sfa.api.entity.Groceries;
import com.company.sfa.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class groceriesController {
    private PersonService personService;
    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}/groceries")
    public List<GroceriesDTO> getGroceriesByPersonId(@PathVariable("id") Long personId){
        return personService.getPersonGroceries(personId);
    }
}
