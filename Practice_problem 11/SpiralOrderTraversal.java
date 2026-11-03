import java.util.Scanner;
import java.util.ArrayList;

class SpiralOrderTraversal
{
    static ArrayList<Integer> spiralOrder(int[][] grid)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;

        while(top <= bottom && left <= right)
        {
            for(int i = left; i <= right; i++)
                result.add(grid[top][i]);

            top++;

            for(int i = top; i <= bottom; i++)
                result.add(grid[i][right]);

            right--;

            if(top <= bottom)
            {
                for(int i = right; i >= left; i--)
                    result.add(grid[bottom][i]);

                bottom--;
            }

            if(left <= right)
            {
                for(int i = bottom; i >= top; i--)
                    result.add(grid[i][left]);

                left++;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter matrix elements:");

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }

        ArrayList<Integer> result = spiralOrder(grid);

        System.out.println("Spiral Order: " + result);

        sc.close();
    }
}
