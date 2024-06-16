package model;

import java.math.BigDecimal;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected BigDecimal value;
    protected BigDecimal shortDailyCost;
    protected BigDecimal longDailyCost;
    protected BigDecimal insuranceCost;

    public Vehicle(String brand,
                   String model,
                   BigDecimal value,
                   BigDecimal longDailyCost,
                   BigDecimal shortDailyCost,
                   BigDecimal insuranceCostDaily) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.longDailyCost = longDailyCost;
        this.shortDailyCost = shortDailyCost;
        this.insuranceCost = insuranceCostDaily;
    }

    public abstract BigDecimal calculateInsurance(long actualRentalDays);
    public abstract BigDecimal getActualDailyInsurance();
    public  BigDecimal getInitialDailyInsurance(){
        return value.multiply(insuranceCost);
    }

    public BigDecimal getInsuranceDiscount(){
        return getInitialDailyInsurance().subtract(getActualDailyInsurance());
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

    public BigDecimal getShortDailyCost() {
        return shortDailyCost;
    }

    public Vehicle setShortDailyCost(BigDecimal shortDailyCost) {
        this.shortDailyCost = shortDailyCost;
        return this;
    }

    public BigDecimal getLongDailyCost() {
        return longDailyCost;
    }

    public Vehicle setLongDailyCost(BigDecimal longDailyCost) {
        this.longDailyCost = longDailyCost;
        return this;
    }

    public BigDecimal getInsuranceCost() {
        return insuranceCost;
    }

    public Vehicle setInsuranceCost(BigDecimal insuranceCost) {
        this.insuranceCost = insuranceCost;
        return this;
    }

    public String getBrandAndModel() {
        return this.brand + " " + this.model;
    }
}
