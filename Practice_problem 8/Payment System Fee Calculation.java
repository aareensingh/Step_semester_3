import java.util.*;

interface PaymentMethod
{
    double calculateAmount(double amount);
    String getType();
}

class Card implements PaymentMethod
{
    public double calculateAmount(double amount)
    {
        return amount + amount * 0.02;
    }

    public String getType()
    {
        return "CARD";
    }
}

class Wallet implements PaymentMethod
{
    public double calculateAmount(double amount)
    {
        return amount + amount * 0.01;
    }

    public String getType()
    {
        return "WALLET";
    }
}

class BankTransfer implements PaymentMethod
{
    public double calculateAmount(double amount)
    {
        return amount;
    }

    public String getType()
    {
        return "BANKTRANSFER";
    }
}

class Payment
{
    PaymentMethod method;
    double amount;

    Payment(PaymentMethod method, double amount)
    {
        this.method = method;
        this.amount = amount;
    }

    double getFinalAmount()
    {
        return method.calculateAmount(amount);
    }
}

public class PaymentSystem
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Payment> payments = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod method;

            if(type.equals("CARD"))
                method = new Card();
            else if(type.equals("WALLET"))
                method = new Wallet();
            else
                method = new BankTransfer();

            payments.add(new Payment(method, amount));
        }

        double total = 0;

        for(Payment payment : payments)
        {
            double adjustedAmount = payment.getFinalAmount();
            System.out.printf("%s: %.2f%n", payment.method.getType(), adjustedAmount);
            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
