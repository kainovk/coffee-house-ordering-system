package org.kainovk.coffeehouseorderingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer orderId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer customerId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer employeeId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime estimatedDeliveryDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer itemId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cancellationReason;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private LocalDateTime timestamp;
}
