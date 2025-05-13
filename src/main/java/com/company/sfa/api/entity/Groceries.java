package com.company.sfa.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Groceries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person owner;
    @Column
    private String type;
    @Column
    private String name;

}
