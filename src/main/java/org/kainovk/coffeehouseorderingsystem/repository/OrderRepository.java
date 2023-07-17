package org.kainovk.coffeehouseorderingsystem.repository;

import org.kainovk.coffeehouseorderingsystem.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
