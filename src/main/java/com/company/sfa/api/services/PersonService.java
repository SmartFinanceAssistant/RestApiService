package com.company.sfa.api.services;

import com.company.sfa.api.DAO.PersonDAO;
import com.company.sfa.api.DTO.GroceriesDTO;
import com.company.sfa.api.DTO.PersonDTO;
import com.company.sfa.api.entity.Groceries;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private PersonDAO personDAO;
    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional
    public List<GroceriesDTO> getPersonGroceries(Long personId){

        return groceriesDTOListConverter(personDAO.getPersonGroceries(personId));
    }
    @Transactional
    public String addPerson(PersonDTO personDTO){
        return personDAO.addPerson(personDTO);
    }
    @Transactional
    public String addGroceriesToPerson(GroceriesDTO groceriesDTO){
        return personDAO.addGroceriesToPerson(groceriesDTO);
    }

    public GroceriesDTO groceriesDTOConverter(Groceries groceries){
        GroceriesDTO groceriesDTO = new GroceriesDTO();
        groceriesDTO.setType(groceries.getType());
        return groceriesDTO;
    }
    public List<GroceriesDTO> groceriesDTOListConverter(List<Groceries> groceriesList){
        List<GroceriesDTO> groceriesDTOList = new ArrayList<>();
        for(Groceries groceries : groceriesList){
            groceriesDTOList.add(groceriesDTOConverter(groceries));
        }
        return groceriesDTOList;
    }

}
