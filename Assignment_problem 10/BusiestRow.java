import java.util.Scanner;
public class BusiestRow{
static void busiestRow(int[][] grid){
int maxTotal=-1,rowIndex=0;
for(int i=0;i<grid.length;i++){
int total=0;
for(int j=0;j<grid[i].length;j++)
total+=grid[i][j];
if(total>maxTotal){
maxTotal=total;
rowIndex=i;
}
}
System.out.println("Row "+rowIndex+", Total "+maxTotal);
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int r=sc.nextInt(),c=sc.nextInt();
int[][] grid=new int[r][c];
for(int i=0;i<r;i++)
for(int j=0;j<c;j++)
grid[i][j]=sc.nextInt();
busiestRow(grid);
sc.close();
}
}
