package example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String buildStatement() {
        double totalAmount = calculateTotalAmount();
        int frequentRenterPoints = calculateFrequentRenterPoints();
        return generateStatement(totalAmount, frequentRenterPoints);
    }

    private double calculateTotalAmount() {
        return rentals.stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }

    private int calculateFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }

    private String generateStatement(double totalAmount, int frequentRenterPoints) {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental rental : rentals) {
            result.append("\t").append(rental.movie().getTitle()).append("\t")
                    .append(rental.getCharge()).append("\n");
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints)
                .append(" frequent renter points");

        return result.toString();
    }
}