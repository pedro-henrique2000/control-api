package com.controlfood.interfaces.http.controller;

import com.controlfood.application.order.CreateOrder;
import com.controlfood.domain.entities.Order;
import com.controlfood.interfaces.http.controller.api.OrderControllerApi;
import com.controlfood.interfaces.http.dto.OrderDto;
import com.controlfood.interfaces.http.mapper.OrderDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class OrderController implements OrderControllerApi {

    private final CreateOrder createOrder;
    private final OrderDtoMapper orderDtoMapper;

    @Override
    public ResponseEntity<Void> createOrder(OrderDto orderDto) {
        Order order = createOrder.invoke(orderDtoMapper.toEntity(orderDto));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
