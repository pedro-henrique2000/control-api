package com.controlfood.application.order;

import com.controlfood.application.product.FindProductById;
import com.controlfood.domain.entities.Order;
import com.controlfood.domain.entities.OrderDetails;
import com.controlfood.domain.entities.OrderRequested;
import com.controlfood.domain.entities.Product;
import com.controlfood.domain.errors.BusinessException;
import com.controlfood.domain.protocols.CreateOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateOrder {

    private final CreateOrderRepository createOrderRepository;
    private final FindProductById findProductById;

    public Order invoke(OrderRequested orderRequested) {
        Order order = createOrderEntity(orderRequested);
        return createOrderRepository.create(order);
    }

    private Order createOrderEntity(OrderRequested orderRequested) {
        Product product = findProductById.invoke(orderRequested.getProductId());
        if (product.getQuantity() < orderRequested.getQuantity()) {
            throw new BusinessException("Product Quantity not available!");
        }
        List<OrderDetails> orderDetails = new ArrayList<>();
        orderDetails.add(OrderDetails.builder().product(product).quantity(orderRequested.getQuantity()).build());
        return Order.builder()
                .orderDetails(orderDetails)
                .build();
    }

}
