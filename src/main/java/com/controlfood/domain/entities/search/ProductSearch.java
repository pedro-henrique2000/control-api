package com.controlfood.domain.entities.search;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ProductSearch {

    private String name;
    private BigDecimal price;
    private SortType sort = SortType.DESC;

}
