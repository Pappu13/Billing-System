import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HandicraftStore store = new HandicraftStore();
        Scanner input = new Scanner(System.in);

        int numberOfCustomers = 5;
        for (int i = 0; i < numberOfCustomers; i++) {
            System.out.print("\nEnter customer name: ");
            String customerName = input.nextLine();
            Customer customer = new Customer(customerName);

            int[] selectedProductsCount = store.takeCustomerOrders();

            double[] amounts = store.calculateTotalBill(selectedProductsCount);

            int totalOrderedProducts = 0;
            Product[] orderedProducts = new Product[store.getProducts().length];
            int[] orderedProductCounts = new int[store.getProducts().length];
            double[] orderedProductPrices = new double[store.getProducts().length];

            for (int j = 0; j < store.getProducts().length; j++) {
                if (selectedProductsCount[j] > 0) {
                    orderedProducts[totalOrderedProducts] = store.getProducts()[j];
                    orderedProductCounts[totalOrderedProducts] = selectedProductsCount[j];
                    orderedProductPrices[totalOrderedProducts] = selectedProductsCount[j]
                            * store.getProducts()[j].getPrice();
                    totalOrderedProducts++;
                }
            }
            Product[] finalOrderedProducts = Arrays.copyOf(orderedProducts, totalOrderedProducts);
            int[] finalOrderedProductCounts = Arrays.copyOf(orderedProductCounts, totalOrderedProducts);
            double[] finalOrderedProductPrices = Arrays.copyOf(orderedProductPrices, totalOrderedProducts);

            Bill bill = new Bill(customer, amounts[0], amounts[1], amounts[2], finalOrderedProducts,
                    finalOrderedProductCounts, finalOrderedProductPrices);

            bill.displayCustomerBill();

            System.out.println("\nThank you for choosing Himalayan Handicraft Store.");
            System.out.println("Visit us again soon!");

            System.out.print("\nDo you want to continue with the next customer? (yes/no): ");
            String repeat = input.nextLine();
            if (!repeat.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
}
