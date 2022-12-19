package kr.pe.karsei.springmodulithdemo.order;

import lombok.Value;
import org.jmolecules.event.types.DomainEvent;

@Value
public class OrderCompleted implements DomainEvent {
    Order.OrderIdentifier orderId;
}