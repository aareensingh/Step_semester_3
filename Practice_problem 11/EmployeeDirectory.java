import java.util.Scanner;
import java.util.HashMap;

class EmployeeDirectory
{
    static HashMap<String, String> buildLookup(String[][] records)
    {
        HashMap<String, String> lookup = new HashMap<>();

        for(int i = 0; i < records.length; i++)
        {
            lookup.put(records[i][0], records[i][1]);
        }

        return lookup;
    }

    static String getDepartment(HashMap<String, String> lookup, String employeeId)
    {
        if(lookup.containsKey(employeeId))
            return lookup.get(employeeId);

        return "Unknown";
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        String[][] records = new String[n][2];

        System.out.println("Enter employee ID and department:");

        for(int i = 0; i < n; i++)
        {
            records[i][0] = sc.next();
            records[i][1] = sc.next();
        }

        HashMap<String, String> lookup = buildLookup(records);

        System.out.print("Enter employee ID to search: ");
        String employeeId = sc.next();

        System.out.println(getDepartment(lookup, employeeId));

        sc.close();
    }
}
