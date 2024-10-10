package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static example.MovieType.*;

class CustomerTest {

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
        assertEquals(expected, customer.buildStatement());
    }

    @Test
    void testBuildStatementWithOneRegularMovie() {
        customer.addRental(new Rental(new Movie("Regular Movie", REGULAR), 3));
        String expected = "Rental Record for John Doe\n" +
                "\tRegular Movie\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.buildStatement());
    }

    @Test
    void testBuildStatementWithOneNewReleaseMovie() {
        customer.addRental(new Rental(new Movie("New Release", NEW_RELEASE), 2));
        String expected = "Rental Record for John Doe\n" +
                "\tNew Release\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expected, customer.buildStatement());
    }

    @Test
    void testBuildStatementWithOneChildrensMovie() {
        customer.addRental(new Rental(new Movie("Children's Movie", CHILDRENS), 4));
        String expected = "Rental Record for John Doe\n" +
                "\tChildren's Movie\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.buildStatement());
    }

    @Test
    void testBuildStatementWithMultipleMovies() {
        customer.addRental(new Rental(new Movie("Regular Movie", REGULAR), 3));
        customer.addRental(new Rental(new Movie("New Release", NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Children's Movie", CHILDRENS), 4));
        String expected = "Rental Record for John Doe\n" +
                "\tRegular Movie\t3.5\n" +
                "\tNew Release\t6.0\n" +
                "\tChildren's Movie\t3.0\n" +
                "Amount owed is 12.5\n" +
                "You earned 4 frequent renter points";
        assertEquals(expected, customer.buildStatement());
    }
}