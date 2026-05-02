public class Product {
    private String name;
    private double price;
    private double discount;

    public Product(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getFinalPrice() {
        return price - (price * discount / 100);
    }

    public String getDetails() {
        return "Product: " + name +
               "\nOriginal Price: ₹" + price +
               "\nDiscount: " + discount + "%" +
               "\nFinal Price: ₹" + getFinalPrice();
    }
}