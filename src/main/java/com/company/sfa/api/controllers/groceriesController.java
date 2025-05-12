package com.company.sfa.api.controllers;

import com.company.sfa.api.DTO.GroceriesDTO;
import com.company.sfa.api.DTO.PersonDTO;
import com.company.sfa.api.entity.Person;
import com.company.sfa.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groceries")
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
    @PostMapping("/addGroceries")
    public String addGroceries(@RequestBody GroceriesDTO groceriesDTO){
        return personService.addGroceriesToPerson(groceriesDTO);
    }
}
