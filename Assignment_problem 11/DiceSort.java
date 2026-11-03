import java.util.Scanner;
import java.util.Arrays;

class DiceSort
{
    static int[] diceSort(int[] rolls)
    {
        int[] count = new int[7];

        for(int i = 0; i < rolls.length; i++)
        {
            count[rolls[i]]++;
        }

        System.out.print("Counts: ");

        for(int i = 1; i <= 6; i++)
        {
            System.out.print(i + ":" + count[i] + " ");
        }

        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;

        for(int i = 1; i <= 6; i++)
        {
            for(int j = 0; j < count[i]; j++)
            {
                sorted[index] = i;
                index++;
            }
        }

        return sorted;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of dice throws: ");
        int n = sc.nextInt();

        int[] rolls = new int[n];

        System.out.println("Enter dice results (1 to 6):");

        for(int i = 0; i < n; i++)
        {
            rolls[i] = sc.nextInt();

            if(rolls[i] < 1 || rolls[i] > 6)
            {
                System.out.println("Invalid dice result!");
                sc.close();
                return;
            }
        }

        int[] result = diceSort(rolls);

        System.out.println("Sorted: " + Arrays.toString(result));

        sc.close();
    }
}
