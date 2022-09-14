package com.controlfood.domain.entities;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class Order {

    private Long id;

    private List<OrderDetails> orderDetails;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
