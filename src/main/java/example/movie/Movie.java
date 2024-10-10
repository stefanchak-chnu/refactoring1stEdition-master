package example.movie;

public abstract class Movie {
    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getCharge(int daysRented);
    public abstract int getFrequentRenterPoints(int daysRented);
}
