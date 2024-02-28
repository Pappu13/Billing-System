import java.util.Scanner;

class Bill {
    private Customer customer;
    private double totalPrice;
    private double charityAmount;
    private double storeAmount;
    private Product[] orderedProducts;
    private int[] orderedProductCounts;
    private double[] orderedProductPrices;

    public Bill(Customer customer, double totalPrice, double charityAmount, double storeAmount,
            Product[] orderedProducts, int[] orderedProductCounts, double[] orderedProductPrices) {
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.charityAmount = charityAmount;
        this.storeAmount = storeAmount;
        this.orderedProducts = orderedProducts;
        this.orderedProductCounts = orderedProductCounts;
        this.orderedProductPrices = orderedProductPrices;
    }

    public void displayCustomerBill() {

        System.out.println("\n######################################");
        System.out.println("      Himalayan Handicrafts Store     ");
        System.out.println("######################################");
        System.out.println("            Namaste        ");
        System.out.println("Welcome to Himalayan Handicraft Store.");
        System.out.println("\n========================================");
        System.out.println("         Customer Bill #" + customer.getCustomerNumber());
        System.out.println("         Customer Name: " + customer.getName());
        System.out.println("=========================================");
        System.out.println("\nOrdered Products:");
        for (int i = 0; i < orderedProducts.length; i++) {
            System.out.println(orderedProducts[i].getName() + " - " + orderedProductCounts[i] + " pieces - Rs "
                    + orderedProductPrices[i]);
        }
        System.out.println("\nTotal Price: Rs " + totalPrice);
        System.out.println("Charity Amount: Rs " + charityAmount);
        System.out.println("Store Amount: Rs " + storeAmount);
    }
}
