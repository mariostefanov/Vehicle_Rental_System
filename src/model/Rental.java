package model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Rental {
    private long rentalId;
    private String customerName;
    private LocalDate date;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate actualEndDate;

    public Rental(long rentalId,
                  String customerName,
                  LocalDate date, Vehicle vehicle,
                  LocalDate startDate,
                  LocalDate endDate,
                  LocalDate actualEndDate) {
        this.rentalId = rentalId;
        this.customerName = customerName;
        this.date = date;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.actualEndDate = actualEndDate;
    }

    public BigDecimal calculateRental(){
        BigDecimal dailyRent = getDailyRent();

        if (getRentalDays()==getActualRentalDays()){
            return dailyRent.multiply(BigDecimal.valueOf(getActualRentalDays()));
        } else {
            return dailyRent
                    .multiply(BigDecimal.valueOf(getActualRentalDays()))
                    .add(getRentForRemainingDays());
        }
    }

    public BigDecimal getRentForRemainingDays() {
        return getDailyRent().multiply(BigDecimal.valueOf(0.5))
                .multiply(BigDecimal.valueOf(getRentalDays()-getActualRentalDays()));
    }

    public BigDecimal getDailyRent() {
        return getActualRentalDays() > 7 ? vehicle.getLongDailyCost() : vehicle.getShortDailyCost();
    }

    public long getRentalDays() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

     public long getActualRentalDays() {
        return ChronoUnit.DAYS.between(startDate, actualEndDate);
    }

    public long getRentalId() {
        return rentalId;
    }

    public Rental setRentalId(long rentalId) {
        this.rentalId = rentalId;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Rental setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Rental setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Rental setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Rental setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Rental setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public LocalDate getActualEndDate() {
        return actualEndDate;
    }

    public Rental setActualEndDate(LocalDate actualEndDate) {
        this.actualEndDate = actualEndDate;
        return this;
    }

    public BigDecimal calculateTotalCost() {
        return calculateRental().add(vehicle.calculateInsurance(getActualRentalDays()));
    }

    public boolean insuranceChange() {
        return vehicle.getInitialDailyInsurance().compareTo(vehicle.getActualDailyInsurance()) != 0;
    }

    public boolean isEarlyReturnDiscount() {
        return getRentalDays() > getActualRentalDays();
    }

    public BigDecimal getEarlyDiscountForRent() {

        return getRentForRemainingDays();
    }

    public BigDecimal getEarlyDiscountForInsurance() {
        return this.vehicle.calculateInsurance(getRentalDays()).subtract(this.vehicle.calculateInsurance(getActualRentalDays()));
    }
}
