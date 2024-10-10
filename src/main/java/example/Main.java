package example;

import example.movie.ChildrensMovie;
import example.movie.Movie;
import example.movie.NewReleaseMovie;
import example.movie.RegularMovie;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Doe");

        Movie regularMovie = new RegularMovie("The Godfather");
        Movie newReleaseMovie = new NewReleaseMovie("Avengers: Endgame");
        Movie childrensMovie = new ChildrensMovie("Toy Story");
        Movie historyMovie = new ChildrensMovie("WW1");

        customer.addRental(new Rental(regularMovie, 3));
        customer.addRental(new Rental(newReleaseMovie, 2));
        customer.addRental(new Rental(childrensMovie, 4));
        customer.addRental(new Rental(historyMovie, 1));

        System.out.println(customer.buildStatement());
    }
}