package com.company.sfa.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    private List<Groceries> groceriesList;

}
