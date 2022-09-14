package com.controlfood.interfaces.http.controller.api;

import com.controlfood.interfaces.http.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("v1/api/orders")
public interface OrderControllerApi {

    @PostMapping
    ResponseEntity<Object> createOrder(@Valid @RequestBody OrderDto orderDto);

}
