package model;

import java.math.BigDecimal;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected BigDecimal value;
    protected BigDecimal rentalCostDaily;

    public Vehicle(String brand, String model, BigDecimal value, BigDecimal rentalCostDaily) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.rentalCostDaily = rentalCostDaily;
    }


    public String getBrand() {
        return brand;
    }

    public Vehicle setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Vehicle setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public BigDecimal getRentalCostDaily() {
        return rentalCostDaily;
    }

    public Vehicle setRentalCostDaily(BigDecimal rentalCostDaily) {
        this.rentalCostDaily = rentalCostDaily;
        return this;
    }
}
