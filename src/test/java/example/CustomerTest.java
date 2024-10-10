package example;

import example.entity.Customer;
import example.entity.Rental;
import example.entity.movie.ChildrensMovie;
import example.entity.movie.NewReleaseMovie;
import example.entity.movie.RegularMovie;
import example.service.RentalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerTest {

    @Autowired
    private RentalService rentalService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe");
    }

    @Test
    void testGetName() {
        assertEquals("John Doe", customer.getName());
    }

    @Test
    void testBuildStatementWithNoRentals() {
        String expected = "Rental Record for John Doe\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";
        assertEquals(expected, rentalService.generateCustomerStatement(customer));
    }

    @Test
    void testBuildStatementWithOneRegularMovie() {
        customer.addRental(new Rental(new RegularMovie("Regular Movie"), 3));
        String expected = "Rental Record for John Doe\n" +
                "\tRegular Movie\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, rentalService.generateCustomerStatement(customer));
    }

    @Test
    void testBuildStatementWithOneNewReleaseMovie() {
        customer.addRental(new Rental(new NewReleaseMovie("New Release"), 2));
        String expected = "Rental Record for John Doe\n" +
                "\tNew Release\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expected, rentalService.generateCustomerStatement(customer));
    }

    @Test
    void testBuildStatementWithOneChildrensMovie() {
        customer.addRental(new Rental(new ChildrensMovie("Children's Movie"), 4));
        String expected = "Rental Record for John Doe\n" +
                "\tChildren's Movie\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, rentalService.generateCustomerStatement(customer));
    }

    @Test
    void testBuildStatementWithMultipleMovies() {
        customer.addRental(new Rental(new RegularMovie("Regular Movie"), 3));
        customer.addRental(new Rental(new NewReleaseMovie("New Release"), 2));
        customer.addRental(new Rental(new ChildrensMovie("Children's Movie"), 4));
        String expected = "Rental Record for John Doe\n" +
                "\tRegular Movie\t3.5\n" +
                "\tNew Release\t6.0\n" +
                "\tChildren's Movie\t3.0\n" +
                "Amount owed is 12.5\n" +
                "You earned 4 frequent renter points";
        assertEquals(expected, rentalService.generateCustomerStatement(customer));
    }
}