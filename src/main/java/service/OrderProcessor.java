package service;

import model.Shelf;
import model.Order;

import java.util.*;
import java.util.concurrent.*;

public class OrderProcessor {
    private final Map<String, Shelf> shelves = new HashMap<>();
    public final ExecutorService executor = Executors.newFixedThreadPool(10);
    private final Random random = new Random();

    public OrderProcessor() {
        shelves.put("hot", new Shelf("hot"));
        shelves.put("cold", new Shelf("cold"));
        shelves.put("frozen", new Shelf("frozen"));
    }

    public void receiveOrder(String id, String temperature, int shelfLife, double decayRate) {
        Order order = new Order(id, temperature, shelfLife, decayRate);
        Shelf shelf = shelves.get(temperature);
        if (shelf != null) {
            shelf.addOrder(order);
            System.out.println("Order received: " + id);
            executor.submit(() -> processOrder(order));
        } else {
            System.err.println("Invalid temperature category for order: " + id);
        }
    }

    private void processOrder(Order order) {
        try {
            System.out.println("Processing order: " + order.getId());
            int delay = random.nextInt(5) + 1; // Simulate delay
            Thread.sleep(delay * 1000L);
            System.out.println("Order ready for pickup: " + order.getId());
            dispatchCourier(order);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void dispatchCourier(Order order) {
        executor.submit(() -> {
            try {
                System.out.println("Dispatching courier for order: " + order.getId());
                Thread.sleep(random.nextInt(5) * 1000L);
                System.out.println("Courier picked up order: " + order.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }

}
