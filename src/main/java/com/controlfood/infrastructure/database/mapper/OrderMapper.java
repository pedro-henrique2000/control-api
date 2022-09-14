package com.controlfood.infrastructure.database.mapper;

import com.controlfood.domain.entities.Order;
import com.controlfood.domain.entities.OrderDetails;
import com.controlfood.domain.entities.Product;
import com.controlfood.infrastructure.database.model.OrderDetailsModel;
import com.controlfood.infrastructure.database.model.OrderModel;
import com.controlfood.infrastructure.database.model.ProductModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ProductMapper productMapper;

    public OrderModel toModel(Order order) {
        List<OrderDetailsModel> orderDetailsModels = order.getOrderDetails().stream().map(this::toOrderDetailsModel).collect(Collectors.toList());

        OrderModel orderModel = new OrderModel();
        orderModel.setId(order.getId());
        orderModel.setOrderDetails(orderDetailsModels);

        return orderModel;
    }

    private OrderDetailsModel toOrderDetailsModel(OrderDetails orderDetails) {
        ProductModel productModel = productMapper.toModel(orderDetails.getProduct());
        OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
        orderDetailsModel.setProduct(productModel);
        orderDetailsModel.setQuantity(orderDetails.getQuantity());
        orderDetailsModel.setId(orderDetails.getId());
        return orderDetailsModel;
    }

    public Order toEntity(OrderModel orderModel) {
        List<OrderDetails> details = orderModel.getOrderDetails().stream().map(this::toOrderDetailsEntity).collect(Collectors.toList());

        return Order.builder()
                .id(orderModel.getId())
                .createdAt(orderModel.getCreatedAt())
                .updatedAt(orderModel.getUpdatedAt())
                .orderDetails(details)
                .build();
    }

    private OrderDetails toOrderDetailsEntity(OrderDetailsModel orderDetailsModel) {
        Product product = productMapper.toEntity(orderDetailsModel.getProduct());
        return OrderDetails.builder().id(orderDetailsModel.getId()).quantity(orderDetailsModel.getQuantity()).product(product).quantity(orderDetailsModel.getQuantity()).build();
    }

}
