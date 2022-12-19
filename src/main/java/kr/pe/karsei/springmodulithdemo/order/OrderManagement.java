package kr.pe.karsei.springmodulithdemo.order;

import kr.pe.karsei.springmodulithdemo.order.internal.OrderInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderManagement {
    private final ApplicationEventPublisher events;
    private final OrderInternal orderInternal;
//    private final InventoryInternal inventoryInternal;

    @Transactional
    public void complete(Order order) {
        events.publishEvent(new OrderCompleted(order.getId()));
    }
}
