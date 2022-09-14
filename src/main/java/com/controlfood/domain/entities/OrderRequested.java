package com.controlfood.domain.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderRequested {

    private int quantity;

    private Long productId;

}
