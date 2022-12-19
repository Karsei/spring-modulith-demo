package kr.pe.karsei.springmodulithdemo.order;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.PublishedEvents;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ApplicationModuleTest
@RequiredArgsConstructor
public class OrderIntegrationTests {
    private final OrderManagement orders;

    @Test
    void publishesOrderCompletion(PublishedEvents events) {
        var reference = new Order();
        orders.complete(reference);

        var matchingMapped = events.ofType(OrderCompleted.class)
                .matchingMapped(OrderCompleted::getOrderId, reference.getId()::equals);

        assertNotNull(matchingMapped);
    }
}
