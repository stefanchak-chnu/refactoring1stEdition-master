package example.service;

import example.entity.Customer;
import example.entity.Rental;
import example.entity.movie.ChildrensMovie;
import example.entity.movie.Movie;
import example.entity.movie.NewReleaseMovie;
import example.entity.movie.RegularMovie;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    public String generateCustomerStatement(Customer customer) {
        return customer.buildStatement();
    }

    public String generateDefaultCustomerStatement() {
        Customer customer = new Customer("John Doe");

        Movie regularMovie = new RegularMovie("The Godfather");
        Movie newReleaseMovie = new NewReleaseMovie("Avengers: Endgame");
        Movie childrensMovie = new ChildrensMovie("Toy Story");
        Movie historyMovie = new ChildrensMovie("WW1");

        customer.addRental(new Rental(regularMovie, 3));
        customer.addRental(new Rental(newReleaseMovie, 2));
        customer.addRental(new Rental(childrensMovie, 4));
        customer.addRental(new Rental(historyMovie, 1));

        return customer.buildStatement();
    }
}