public class DiscountCalculator {

    public static double calculate(double price, double discount) {
        return price - (price * discount / 100);
    }
}