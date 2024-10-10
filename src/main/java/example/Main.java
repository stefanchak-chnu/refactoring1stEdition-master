package example;


public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Doe");

        Movie movie1 = new Movie("The Shawshank Redemption", MovieType.REGULAR);
        Movie movie2 = new Movie("Inception", MovieType.NEW_RELEASE);
        Movie movie3 = new Movie("Toy Story", MovieType.CHILDRENS);

        customer.addRental(new Rental(movie1, 3));
        customer.addRental(new Rental(movie2, 2));
        customer.addRental(new Rental(movie3, 4));

        System.out.println(customer.buildStatement());
    }
}