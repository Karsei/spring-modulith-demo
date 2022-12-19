package kr.pe.karsei.springmodulithdemo.inventory;

import kr.pe.karsei.springmodulithdemo.order.OrderCompleted;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryManagement {

//    private final InventoryInternal dependency;

    @Async
    @TransactionalEventListener
    void on(OrderCompleted event) throws InterruptedException {

        var orderId = event.getOrderId();

        log.info("Received order completion for {}.", orderId);

        // Simulate busy work
        Thread.sleep(1000);

        log.info("Finished order completion for {}.", orderId);
    }
}