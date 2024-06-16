package model;

import java.math.BigDecimal;

public class CargoVan extends Vehicle{

    private int yearsExperience;

    public CargoVan(String brand, String model,BigDecimal value, int yearsExperience) {
        super(brand, model, value,BigDecimal.valueOf(40.00),BigDecimal.valueOf(50.00), BigDecimal.valueOf(0.0003));
        this.yearsExperience = yearsExperience;
    }

    @Override
    public BigDecimal calculateInsurance(long actualRentalDays) {

        BigDecimal insurancePerDay = getActualDailyInsurance();
        return insurancePerDay.multiply(BigDecimal.valueOf(actualRentalDays));
    }

    @Override
    public BigDecimal getActualDailyInsurance() {
        BigDecimal insurancePerDay = getInitialDailyInsurance();
        if (yearsExperience>5){
            insurancePerDay=insurancePerDay.multiply(BigDecimal.valueOf(0.85));
        }

        return insurancePerDay;
    }


    public int getYearsExperience() {
        return yearsExperience;
    }

    public CargoVan setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
        return this;
    }
}
