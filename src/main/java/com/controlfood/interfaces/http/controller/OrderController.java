package com.controlfood.interfaces.http.controller;

import com.controlfood.application.order.CreateOrder;
import com.controlfood.domain.entities.Order;
import com.controlfood.interfaces.http.controller.api.OrderControllerApi;
import com.controlfood.interfaces.http.dto.OrderDto;
import com.controlfood.interfaces.http.mapper.OrderDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController implements OrderControllerApi {

    private final CreateOrder createOrder;
    private final OrderDtoMapper orderDtoMapper;

    @Override
    public ResponseEntity<Object> createOrder(OrderDto orderDto) {
        Order invoke = createOrder.invoke(orderDtoMapper.toEntity(orderDto));
        return ResponseEntity.ok(invoke);
    }

}
