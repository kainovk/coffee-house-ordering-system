# Coffee House Ordering System

### Example API Usage

`http://localhost:8080/orders/publish-event`:
1. Create and cancel
```json
{
    "type": "REGISTERED",
    "customerId": 11,
    "employeeId": 22,
    "itemId": 33,
    "price": 21.5,
    "estimatedDeliveryDate": "2023-09-20T11:00:00"
}
```

```json
{
  "type": "CANCELLED",
  "orderId": 1,
  "cancellationReason": "not what I wanted"
}
```

2. Until completed
```json
{
    "type": "REGISTERED",
    "customerId": 11,
    "employeeId": 22,
    "itemId": 33,
    "price": 21.5,
    "estimatedDeliveryDate": "2023-09-20T11:00:00"
}
```

```json
{
  "type": "IN_PROGRESS",
  "orderId": 2,
  "employeeId": 123
}
```

```json
{
  "type": "READY_FOR_PICKUP",
  "orderId": 2,
  "employeeId": 321
}
```

```json
{
  "type": "COMPLETED",
  "orderId": 2,
  "employeeId": 151
}
```

`http://localhost:8080/orders/{id}`:

```json
{
    "id": 2,
    "status": "CANCELLED",
    "events": [
        {
            "id": 3,
            "type": "CANCELLED",
            "cancellationReason": "not what I wanted",
            "timestamp": "2023-07-17T21:32:15.625964"
        },
        {
            "id": 2,
            "type": "REGISTERED",
            "customerId": 22,
            "employeeId": 33,
            "itemId": 44,
            "price": 21.5,
            "timestamp": "2023-07-17T21:32:11.030599"
        }
    ]
}
```

```json
{
    "id": 1,
    "status": "COMPLETED",
    "events": [
        {
            "id": 4,
            "type": "IN_PROGRESS",
            "employeeId": 313,
            "timestamp": "2023-07-17T21:32:22.521349"
        },
        {
            "id": 6,
            "type": "READY_FOR_PICKUP",
            "employeeId": 33,
            "timestamp": "2023-07-17T21:34:02.834039"
        },
        {
            "id": 7,
            "type": "COMPLETED",
            "employeeId": 1515,
            "timestamp": "2023-07-17T21:35:12.850717"
        },
        {
            "id": 1,
            "type": "REGISTERED",
            "customerId": 22,
            "employeeId": 33,
            "itemId": 44,
            "price": 21.5,
            "timestamp": "2023-07-17T21:31:23.080385"
        }
    ]
}
```
