import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showAllProducts() {
        for (Product p : products) {
            System.out.println("----------------------");
            System.out.println(p.getDetails());
        }
    }
}