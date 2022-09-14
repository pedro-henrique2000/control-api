package com.controlfood.infrastructure.database.repositories.jpa;

import com.controlfood.infrastructure.database.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<OrderModel, Long> {
}
