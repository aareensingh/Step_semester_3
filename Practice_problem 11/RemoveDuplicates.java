import java.util.Scanner;
import java.util.Arrays;

class RemoveDuplicates
{
    static int removeDuplicates(int[] nums)
    {
        if(nums.length == 0)
            return 0;

        int i = 0;

        for(int j = 1; j < nums.length; j++)
        {
            if(nums[j] != nums[i])
            {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted array elements:");

        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        int length = removeDuplicates(nums);

        System.out.println("Length = " + length);

        System.out.println("Array after removing duplicates:");

        for(int i = 0; i < length; i++)
        {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}
