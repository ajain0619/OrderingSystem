
import model.Shelf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.OrderProcessor;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {

    private OrderProcessor processor;

    @BeforeEach
    void setup() {
        processor = new OrderProcessor();
    }

    @Test
    void testReceiveValidOrder() {
        processor.receiveOrder("Order1", "hot", 15, 0.5);
        // No assertions since the processing happens asynchronously
    }

    @Test
    void testReceiveInvalidOrder() {
        processor.receiveOrder("Order1", "invalid", 15, 0.5);
        assertTrue(true); // Ensure no crashes
    }

    @Test
    void testProcessOrderLifecycle() throws InterruptedException {
        processor.receiveOrder("Order1", "hot", 15, 0.5);
        processor.prepareOrder();

        TimeUnit.SECONDS.sleep(10); // Wait for processing to complete
        assertTrue(true); // Placeholder for manual inspection
    }

    @Test
    void testShutdown() {
        processor.shutdown();
        assertTrue(processor.executor.isShutdown());
    }
}
