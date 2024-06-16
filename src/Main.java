import model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("Subaru",
                "Outback",
                BigDecimal.valueOf(15000),
                3);

        Motorcycle motorcycle = new Motorcycle("Triumph",
                "660",
                BigDecimal.valueOf(10000.00),
                20);

        CargoVan van = new CargoVan("Citroen",
                "Jumper",
                BigDecimal.valueOf(20000.00),
                8);

        Rental rental = new Rental(1,"Mario Stefanov",
                LocalDate.of(2024,6,16),
                car,
                LocalDate.of(2024,5,15),
                LocalDate.of(2024,5,25),
                LocalDate.of(2024,5,25));

        Invoice invoice = new Invoice(rental);

       // invoice.printInvoice();

        Rental rental2 = new Rental(1,"Viktor Ivanov",
                LocalDate.of(2024,6,16),
                car,
                LocalDate.of(2024,3,10),
                LocalDate.of(2024,3,14),
                LocalDate.of(2024,3,13));
        Invoice invoice2 = new Invoice(rental2);
       // invoice2.printInvoice();

        Rental rental3 = new Rental(1,
                "Tsvetelina Petkova",
                LocalDate.of(2024,6,16),
                van,
                LocalDate.of(2024,6,3),
                LocalDate.of(2024,6,18),
                LocalDate.of(2024,6,13));

        Invoice invoice3 = new Invoice(rental3);
        invoice3.printInvoice();
        System.out.println();
    }
}