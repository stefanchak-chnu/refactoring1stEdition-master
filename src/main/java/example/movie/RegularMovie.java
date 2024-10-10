package example.movie;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}