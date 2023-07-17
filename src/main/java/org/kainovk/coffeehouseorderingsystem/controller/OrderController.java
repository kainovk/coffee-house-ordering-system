package org.kainovk.coffeehouseorderingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.kainovk.coffeehouseorderingsystem.dto.Order;
import org.kainovk.coffeehouseorderingsystem.dto.OrderEvent;
import org.kainovk.coffeehouseorderingsystem.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/publish-event")
    public void publishEvent(@RequestBody OrderEvent event) {
        orderService.publishEvent(event);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Integer id) {
        return orderService.findOrder(id);
    }
}
