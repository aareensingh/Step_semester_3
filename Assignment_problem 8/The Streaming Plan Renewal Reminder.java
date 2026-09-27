import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Plan
{
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate)
    {
        this.name = name;
        this.startDate = startDate;
    }

    LocalDate calculateRenewalDate()
    {
        return startDate;
    }
}

class Basic extends Plan
{
    Basic(String name, LocalDate startDate)
    {
        super(name, startDate);
    }

    LocalDate calculateRenewalDate()
    {
        return startDate.plusDays(30);
    }
}

class Standard extends Plan
{
    Standard(String name, LocalDate startDate)
    {
        super(name, startDate);
    }

    LocalDate calculateRenewalDate()
    {
        return startDate.plusDays(90);
    }
}

class Premium extends Plan
{
    Premium(String name, LocalDate startDate)
    {
        super(name, startDate);
    }

    LocalDate calculateRenewalDate()
    {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int n = sc.nextInt();
        ArrayList<Plan> plans = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            String planType = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next(), formatter);

            Plan plan;

            if(planType.equals("BASIC"))
                plan = new Basic(name, startDate);
            else if(planType.equals("STANDARD"))
                plan = new Standard(name, startDate);
            else
                plan = new Premium(name, startDate);

            plans.add(plan);
        }

        for(Plan plan : plans)
        {
            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.println(plan.name + ": " + renewalDate.format(formatter));
        }

        sc.close();
    }
}
