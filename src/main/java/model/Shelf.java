package model;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Shelf {
    private final String temperature;
    private final ConcurrentLinkedQueue<Order> orders;

    public Shelf(String temperature) {
        this.temperature = temperature;
        this.orders = new ConcurrentLinkedQueue<>();
    }
    public String getTemperature() {
        return temperature;
    }

    public ConcurrentLinkedQueue<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.offer(order);
    }

    public Order removeOrder() {
        return orders.poll();
    }

}
