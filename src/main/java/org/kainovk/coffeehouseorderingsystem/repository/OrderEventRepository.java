package org.kainovk.coffeehouseorderingsystem.repository;

import org.kainovk.coffeehouseorderingsystem.model.OrderEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEventRepository extends JpaRepository<OrderEventEntity, Integer> {
}
