package org.kainovk.coffeehouseorderingsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kainovk.coffeehouseorderingsystem.dto.Order;
import org.kainovk.coffeehouseorderingsystem.dto.OrderEvent;
import org.kainovk.coffeehouseorderingsystem.exception.NotFoundException;
import org.kainovk.coffeehouseorderingsystem.exception.NotValidException;
import org.kainovk.coffeehouseorderingsystem.mapper.OrderEventMapper;
import org.kainovk.coffeehouseorderingsystem.mapper.OrderMapper;
import org.kainovk.coffeehouseorderingsystem.model.OrderEntity;
import org.kainovk.coffeehouseorderingsystem.model.OrderEventEntity;
import org.kainovk.coffeehouseorderingsystem.model.Status;
import org.kainovk.coffeehouseorderingsystem.repository.OrderRepository;
import org.kainovk.coffeehouseorderingsystem.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void publishEvent(OrderEvent dto) {
        OrderEventEntity event = OrderEventMapper.INSTANCE.toEntity(dto);
        log.debug("mapped order event: {}", event);

        OrderEntity order;
        if (Objects.equals(dto.getType(), Status.REGISTERED.toString())) {
            order = new OrderEntity();
            order.setEvents(new HashSet<>());
        } else if (dto.getOrderId() != null) {
            Optional<OrderEntity> foundOrder = orderRepository.findById(dto.getOrderId());
            if (foundOrder.isPresent()) {
                order = foundOrder.get();
            } else {
                throw new NotFoundException("Order not found");
            }
        } else {
            throw new NotFoundException("Order not found");
        }

        if (!isEventValid(order, event)) {
            throw new NotValidException("Event status is not valid");
        }

        order.setStatus(Status.valueOf(dto.getType()));
        order.getEvents().add(event);
        event.setTimestamp(LocalDateTime.now());
        event.setOrder(order);
        orderRepository.save(order);
    }

    @Override
    public Order findOrder(int id) {
        return orderRepository.findById(id)
                .map(OrderMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NotFoundException("Order not found"));
    }

    private boolean isEventValid(OrderEntity order, OrderEventEntity event) {
        Status orderStatus = order.getStatus();
        Status eventType = event.getType();

        switch (eventType) {
            case REGISTERED:
                return orderStatus == null;
            case CANCELLED:
                return orderStatus != null && orderStatus != Status.CANCELLED && orderStatus != Status.COMPLETED;
            case IN_PROGRESS:
                return orderStatus == Status.REGISTERED;
            case READY_FOR_PICKUP:
                return orderStatus == Status.IN_PROGRESS;
            case COMPLETED:
                return orderStatus == Status.READY_FOR_PICKUP;
            default:
                return false;
        }
    }
}
