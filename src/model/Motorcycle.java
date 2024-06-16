package model;

import java.math.BigDecimal;

public class Motorcycle extends Vehicle {

    private int riderAge;

    public Motorcycle(String brand, String model, BigDecimal value, int riderAge) {
        super(brand, model, value, BigDecimal.valueOf(10.00), BigDecimal.valueOf(15.00), BigDecimal.valueOf(0.0002));
        this.riderAge = riderAge;
    }

    @Override
    public BigDecimal calculateInsurance(long actualRentalDays) {
        BigDecimal insurancePerDay = getActualDailyInsurance();
        return insurancePerDay.multiply(BigDecimal.valueOf(actualRentalDays));
    }

    @Override
    public BigDecimal getActualDailyInsurance() {
        BigDecimal insurancePerDay = getInitialDailyInsurance();

        if (riderAge < 25) {
            insurancePerDay = insurancePerDay.multiply(BigDecimal.valueOf(1.2));
        }

        return insurancePerDay;
    }


    public int getRiderAge() {
        return riderAge;
    }

    public Motorcycle setRiderAge(int riderAge) {
        this.riderAge = riderAge;
        return this;
    }
}
