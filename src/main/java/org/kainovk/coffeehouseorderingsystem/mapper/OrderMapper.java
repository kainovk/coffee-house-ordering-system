package org.kainovk.coffeehouseorderingsystem.mapper;

import org.kainovk.coffeehouseorderingsystem.dto.Order;
import org.kainovk.coffeehouseorderingsystem.model.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderEntity toEntity(Order dto);

    Order toDto(OrderEntity entity);
}
