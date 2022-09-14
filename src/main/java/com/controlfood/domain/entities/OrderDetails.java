package com.controlfood.domain.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderDetails {

    private Long id;

    private Product product;

    private int quantity;

}
