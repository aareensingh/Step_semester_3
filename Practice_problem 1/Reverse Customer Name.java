import java.util.*;

public class ReverseCustomer {

    static String reverseCustomerName(String customerName) {
        char[] arr = customerName.toCharArray();
        String reverse = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            reverse += arr[i];
        }

        return reverse;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        sc.close();
    }
}
