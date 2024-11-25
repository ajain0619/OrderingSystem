package org.example;

import service.OrderProcessor;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        for (int i = 1; i <= 10; i++) {
            processor.receiveOrder(
                    "Order" + i,
                    getRandomTemperature(),
                    10 + i,
                    0.5 + (i * 0.1)
            );
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        processor.shutdown();
    }

    private static String getRandomTemperature() {
        String[] temps = {"hot", "cold", "frozen"};
        Random random = new Random();
        return temps[random.nextInt(temps.length)];
    }
}