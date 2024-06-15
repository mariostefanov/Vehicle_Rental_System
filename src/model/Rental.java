package model;

import java.time.LocalDate;


public class Rental {
    private long rentalId;
    private Vehicle vehicle;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;

    public Rental(long rentalId, Vehicle vehicle, LocalDate reservationStartDate, LocalDate reservationEndDate) {
        this.rentalId = rentalId;
        this.vehicle = vehicle;

        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
    }

    public long getRentalId() {
        return rentalId;
    }

    public Rental setRentalId(long rentalId) {
        this.rentalId = rentalId;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Rental setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    public Rental setReservationStartDate(LocalDate reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
        return this;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public Rental setReservationEndDate(LocalDate reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
        return this;
    }
}
