package example;

public record Rental(Movie movie, int daysRented) {

    public double getCharge() {
        double result = 0;
        switch (movie.type()) {
            case REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += daysRented * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        return (movie.type() == MovieType.NEW_RELEASE) && daysRented > 1 ? 2 : 1;
    }
}