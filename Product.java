import java.util.Scanner;

class Product {
    private String productName;
    private int productPrice;

    public Product(String name, int price) {
        this.productName = name;
        this.productPrice = price;
    }

    public String getName() {
        return productName;
    }

    public int getPrice() {
        return productPrice;
    }
}
