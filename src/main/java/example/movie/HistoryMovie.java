package example.movie;

public class HistoryMovie extends Movie {

    public HistoryMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}