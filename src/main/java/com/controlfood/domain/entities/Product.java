package com.controlfood.domain.entities;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
public class Product {

    private Long id;
    private String name;
    private int quantity;
    private String description;
    private BigDecimal price;
    private String url;
    private Status status;
    private List<Tags> tags;

}
