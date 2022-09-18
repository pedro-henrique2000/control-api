package com.controlfood.infrastructure.database.repositories.jpa.specifications;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCriteria {

    private String key;
    private Object value;
    private SearchOperation operation;

}
