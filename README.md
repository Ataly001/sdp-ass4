# Assignment 4 - Facade Pattern

## Project Description

This project is a simple online order system using the Facade Pattern.

The `OrderFacade` connects four services:

- **InventoryService** - checks and manages stock.
- **PaymentService** - handles payments and refunds.
- **ShippingService** - creates and cancels shipping.
- **NotificationService** - sends notifications.

## How It Works

The client uses `OrderFacade` to place or cancel orders.

If payment or shipping fails, the system returns the money or item.

## Testing

The project has 7 tests:

1. Successful order
2. Failed payment
3. Out of stock
4. Cancel order
5. Shipping failure
6. Cancel again
7. Multiple orders

## How to Run

Run `Main.java`.

## Design Pattern

Facade makes the client code simpler by hiding the work of different services.