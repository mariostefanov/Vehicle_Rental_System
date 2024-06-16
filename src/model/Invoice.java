package model;

import com.sun.source.tree.IfTree;

public class Invoice {
    private Rental rental;

    public Invoice(Rental rental) {
        this.rental = rental;
    }

    public void printInvoice() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Date: " + rental.getDate());
        System.out.println("Customer name: " + rental.getCustomerName());
        System.out.println("Rented vehicle: " + rental.getVehicle().getBrandAndModel());
        System.out.println();
        System.out.println("Reservation start date: " + rental.getStartDate());
        System.out.println("Reservation end date: " + rental.getEndDate());
        System.out.println("Reserved rental days: " + rental.getRentalDays() + " days");
        System.out.println();
        System.out.println("Actual return date: " + rental.getActualEndDate());
        System.out.println("Actual rental days: " + rental.getActualRentalDays() + " days");
        System.out.println();
        System.out.printf("Rental cost per day: $%.2f%n",rental.getDailyRent());
        if(rental.insuranceChange()) {
            System.out.printf("Initial insurance per day: $%.2f%n", rental.getVehicle().getInitialDailyInsurance());
            System.out.printf("Insurance addition per day: $%.2f%n" ,rental.getVehicle().getInsuranceDiscount());
        }
        System.out.printf("Insurance per day: $%.2f%n", rental.getVehicle().getActualDailyInsurance());
        System.out.println();

        if(rental.isEarlyReturnDiscount()){
            System.out.printf("Early return discount for rent: $%.2f%n", rental.getEarlyDiscountForRent());
            System.out.printf("Early return discount for insurance: $%.2f%n", rental.getEarlyDiscountForInsurance());

        }
        System.out.printf("Total rent: $%.2f%n" , rental.calculateRental());
        System.out.printf("Total insurance: $%.2f%n",rental.getVehicle().calculateInsurance(rental.getActualRentalDays()));
        System.out.printf("Total: $%.2f%n", rental.calculateTotalCost());
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public Rental getRental() {
        return rental;
    }

    public Invoice setRental(Rental rental) {
        this.rental = rental;
        return this;
    }
}
