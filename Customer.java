import java.util.Scanner;

class Customer {
    private String customerName;
    private static int customerCount = 1;
    private int customerNumber;

    public Customer(String name) {
        this.customerName = name;
        this.customerNumber = customerCount++;
    }

    public String getName() {
        return customerName;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
}
