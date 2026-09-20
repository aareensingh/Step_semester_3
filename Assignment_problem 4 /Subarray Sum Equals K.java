import java.util.*;

class SubarraySumEqualsK
{
    static int subarraySum(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++)
        {
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - k))
                count += map.get(prefixSum - k);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Number of Subarrays: " + subarraySum(nums, k));

        sc.close();
    }
}
