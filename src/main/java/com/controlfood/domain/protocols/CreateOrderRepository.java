package com.controlfood.domain.protocols;

import com.controlfood.domain.entities.Order;

public interface CreateOrderRepository {

    Order create(Order order);

}
