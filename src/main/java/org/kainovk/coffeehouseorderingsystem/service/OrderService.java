package org.kainovk.coffeehouseorderingsystem.service;

import org.kainovk.coffeehouseorderingsystem.dto.Order;
import org.kainovk.coffeehouseorderingsystem.dto.OrderEvent;

public interface OrderService {

    void publishEvent(OrderEvent event);

    Order findOrder(int id);
}
