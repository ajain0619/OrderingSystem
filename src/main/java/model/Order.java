package model;

public class Order {
    private final String id;
    private final String temperature;
    private final int shelfLife;
    private final double decayRate;

    public Order(String id, String temperature, int shelfLife, double decayRate) {
        this.id = id;
        this.temperature = temperature;
        this.shelfLife = shelfLife;
        this.decayRate = decayRate;
    }

    public String getId() {
        return id;
    }

    public String getTemperature() {
        return temperature;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public double getDecayRate() {
        return decayRate;
    }

}
