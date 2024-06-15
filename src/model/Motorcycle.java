package model;

import java.math.BigDecimal;

public class Motorcycle extends Vehicle {

    private int riderAge;

    public Motorcycle(String brand, String model, BigDecimal value, int riderAge) {
        super(brand, model, value);
        this.riderAge = riderAge;
    }

    public int getRiderAge() {
        return riderAge;
    }

    public Motorcycle setRiderAge(int riderAge) {
        this.riderAge = riderAge;
        return this;
    }
}
