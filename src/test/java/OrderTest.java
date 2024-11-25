import model.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testOrderAttributes() {
        Order order = new Order("Order1", "hot", 15, 0.5);

        assertEquals("Order1", order.getId());
        assertEquals("hot", order.getTemperature());
        assertEquals(15, order.getShelfLife());
        assertEquals(0.5, order.getDecayRate());
    }
}
