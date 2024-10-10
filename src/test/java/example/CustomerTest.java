package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static example.Movie.MovieType.*;

class CustomerTest {

    private Customer customer;
    private List<Rental> rentals;

    @BeforeEach
    void setUp() {
        rentals = new ArrayList<>();
        customer = new Customer("John Doe", rentals);
    }

    @Test
    void testGetName() {
        assertEquals("John Doe", customer.getName());
    }

    @Test
    void testStatementWithNoRentals() {
        String expected = "Rental Record for John Doe\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    void testStatementWithOneRegularMovie() {
        rentals.add(new Rental(new Movie("Regular Movie", REGULAR), 3));
        String expected = "Rental Record for John Doe\n" +
                "\tRegular Movie\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    void testStatementWithOneNewReleaseMovie() {
        rentals.add(new Rental(new Movie("New Release", NEW_RELEASE), 2));
        String expected = "Rental Record for John Doe\n" +
                "\tNew Release\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    void testStatementWithOneChildrensMovie() {
        rentals.add(new Rental(new Movie("Children's Movie", CHILDRENS), 4));
        String expected = "Rental Record for John Doe\n" +
                "\tChildren's Movie\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    void testStatementWithMultipleMovies() {
        rentals.add(new Rental(new Movie("Regular Movie", REGULAR), 3));
        rentals.add(new Rental(new Movie("New Release", NEW_RELEASE), 2));
        rentals.add(new Rental(new Movie("Children's Movie", CHILDRENS), 4));
        String expected = "Rental Record for John Doe\n" +
                "\tRegular Movie\t3.5\n" +
                "\tNew Release\t6.0\n" +
                "\tChildren's Movie\t3.0\n" +
                "Amount owed is 12.5\n" +
                "You earned 4 frequent renter points";
        assertEquals(expected, customer.statement());
    }
}