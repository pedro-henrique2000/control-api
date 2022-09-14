package com.controlfood.infrastructure.database.repositories;

import com.controlfood.domain.entities.Order;
import com.controlfood.domain.protocols.CreateOrderRepository;
import com.controlfood.infrastructure.database.mapper.OrderMapper;
import com.controlfood.infrastructure.database.model.OrderModel;
import com.controlfood.infrastructure.database.repositories.jpa.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRepository implements CreateOrderRepository {

    private final JpaOrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order create(Order order) {
        OrderModel orderModel = orderRepository.save(orderMapper.toModel(order));
        return orderMapper.toEntity(orderModel);
    }

}
