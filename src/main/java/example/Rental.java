package example;

import example.movie.Movie;

public record Rental(Movie movie, int daysRented) {

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}