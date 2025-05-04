package com.company.sfa.api.DAO;

import com.company.sfa.api.entity.Groceries;
import com.company.sfa.api.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> index() {
        return entityManager.createQuery(
                "select p from Person p LEFT JOIN FETCH p.groceriesList"
                , Person.class)
                .getResultList();
    }

    public List<Groceries> getPersonGroceries(Long personId) {
        return entityManager.find(Person.class,personId).getGroceriesList();
    }


}
