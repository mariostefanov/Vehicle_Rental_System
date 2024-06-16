package model;

import java.math.BigDecimal;

public class Car extends Vehicle {

    private int safetyRating;

    public Car(String brand, String model, BigDecimal value, int safetyRating) {
        super(brand, model, value, BigDecimal.valueOf(15.00), BigDecimal.valueOf(20.00), BigDecimal.valueOf(0.0001));
        this.safetyRating = safetyRating;
    }

    @Override
    public BigDecimal calculateInsurance(long actualRentalDays) {

        BigDecimal insurancePerDay = getActualDailyInsurance();
        return insurancePerDay.multiply(BigDecimal.valueOf(actualRentalDays));
    }

    @Override
    public BigDecimal getActualDailyInsurance() {
        BigDecimal insurancePerDay = getInitialDailyInsurance();

        if (safetyRating >= 4) {
            insurancePerDay = insurancePerDay.multiply(BigDecimal.valueOf(0.9));
        }
        return insurancePerDay;
    }

    public int getSafetyRating() {
        return safetyRating;
    }

    public Car setSafetyRating(int safetyRating) {
        this.safetyRating = safetyRating;
        return this;
    }
}
