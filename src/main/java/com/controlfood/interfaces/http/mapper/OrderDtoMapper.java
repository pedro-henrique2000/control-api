package com.controlfood.interfaces.http.mapper;

import com.controlfood.domain.entities.OrderRequested;
import com.controlfood.interfaces.http.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoMapper {

    public OrderRequested toEntity(OrderDto orderDto) {
        return OrderRequested.builder().productId(orderDto.getProductId()).quantity(orderDto.getQuantity()).build();
    }

}
