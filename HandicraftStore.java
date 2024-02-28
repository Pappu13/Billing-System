import java.util.Scanner;

class HandicraftStore {
    private Product[] products;
    private final double CHARITY_PERCENTAGE = 0.12;

    public HandicraftStore() {
        products = new Product[10];
        products[0] = new Product("Handmade Bag ", 3500);
        products[1] = new Product("Glay Art", 4000);
        products[2] = new Product("Happy Buddha", 3000);
        products[3] = new Product("Batik Painting", 5500);
        products[4] = new Product("Beaded Jewellery", 7500);
        products[5] = new Product("Glass Painting", 2500);
        products[6] = new Product("Pachisi", 2000);
        products[7] = new Product("Floral Candle", 1500);
        products[8] = new Product("Painted Wooden Art", 4800);
        products[9] = new Product("Bamboo Painting", 4500);
    }

    public int[] takeCustomerOrders() {
        Scanner input = new Scanner(System.in);
        int[] selectedProductsCount = new int[products.length];

        System.out.println("Menu:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i].getName() + " - Rs " + products[i].getPrice());
        }

        while (true) {
            System.out.print("Enter the product number (1 to finish): ");
            int selectedOption = input.nextInt();

            if (selectedOption == 0) {
                break;
            }

            if (selectedOption > 0 && selectedOption <= products.length) {
                System.out.print("Enter the number of pieces for " + products[selectedOption - 1].getName() + ": ");
                int pieces = input.nextInt();
                selectedProductsCount[selectedOption - 1] += pieces;
            } else {
                System.out.println("Invalid product number. Please try again.");
            }
        }

        return selectedProductsCount;
    }

    public double[] calculateTotalBill(int[] selectedProductsCount) {
        int totalPrice = 0;
        for (int i = 0; i < products.length; i++) {
            totalPrice += products[i].getPrice() * selectedProductsCount[i];
        }

        double charityAmount = totalPrice * CHARITY_PERCENTAGE;
        double storeAmount = totalPrice - charityAmount;

        return new double[] { totalPrice, charityAmount, storeAmount };
    }

    public Product[] getProducts() {
        return products;
    }
}
