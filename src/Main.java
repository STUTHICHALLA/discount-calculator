import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        System.out.println("==== Discount Calculator ====");

        while (true) {
            System.out.print("\nEnter product name: ");
            String name = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter discount (%): ");
            double discount = sc.nextDouble();
            sc.nextLine(); // clear buffer

            Product product = new Product(name, price, discount);
            manager.addProduct(product);

            System.out.println("\n✅ Final Price: ₹" + product.getFinalPrice());

            System.out.print("\nAdd another product? (yes/no): ");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\n📦 All Products:");
        manager.showAllProducts();

        sc.close();
    }
}