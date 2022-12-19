package kr.pe.karsei.springmodulithdemo.order;

import lombok.Value;

import java.util.UUID;

@Value
public class Order {

    private OrderIdentifier id = new OrderIdentifier(UUID.randomUUID());

    @Value
    public static class OrderIdentifier {
        UUID id;
    }
}