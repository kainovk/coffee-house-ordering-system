package org.kainovk.coffeehouseorderingsystem.mapper;

import org.kainovk.coffeehouseorderingsystem.model.OrderEventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderEventMapper {

    OrderEventMapper INSTANCE = Mappers.getMapper(OrderEventMapper.class);

    OrderEventEntity toEntity(org.kainovk.coffeehouseorderingsystem.dto.OrderEvent dto);

    org.kainovk.coffeehouseorderingsystem.dto.OrderEvent toDto(OrderEventEntity entity);
}
