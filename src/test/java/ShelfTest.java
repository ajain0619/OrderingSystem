import model.Order;
import model.Shelf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelfTest {

    private Shelf shelf;

    @BeforeEach
    void setup() {
        shelf = new Shelf("hot");
    }

    @Test
    void testShelfAttributes() {
        assertEquals("hot", shelf.getTemperature());
        assertTrue(shelf.getOrders().isEmpty());
    }

    @Test
    void testAddOrder() {
        Order order = new Order("Order1", "hot", 15, 0.5);
        shelf.addOrder(order);

        assertEquals(1, shelf.getOrders().size());
        assertEquals(order, shelf.getOrders().peek());
    }

    @Test
    void testRemoveOrder() {
        Order order = new Order("Order1", "hot", 15, 0.5);
        shelf.addOrder(order);

        Order removedOrder = shelf.removeOrder();
        assertEquals(order, removedOrder);
        assertTrue(shelf.getOrders().isEmpty());
    }
}
