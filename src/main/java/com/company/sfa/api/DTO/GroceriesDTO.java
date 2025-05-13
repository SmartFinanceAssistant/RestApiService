package com.company.sfa.api.DTO;

import com.company.sfa.api.entity.Person;
import lombok.Data;

@Data
public class GroceriesDTO {
    private String type;
    private Long ownerId;
    private String name;
}
