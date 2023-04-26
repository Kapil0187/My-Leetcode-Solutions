//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] matrix)
    {
        // code here
        int top = 0;
        int left = 0;
        int right = C-1;
        int bottom = R-1;
       
        int arr[] = new int[R*C];
        int k=0;
        int l = R*C;
        while(left<=right && top<=bottom)
        {
            for(int i=top;i<=right && k<l;i++)
            {
                arr[k++] = (matrix[top][i]);
            }
            if(R==1)
             break;
            top++;
            for(int i=top;i<=bottom && k<l;i++)
            {
                arr[k++] = (matrix[i][right]);
            }
            if(C==1)
                break;
            right--;
            if(left<=right)
            {
                for(int i=right;i>=left && k<l;i--)
                {
                    arr[k++] = (matrix[bottom][i]);
                }
                bottom--;
            }
            if(top<=bottom)
            {
                for(int i=bottom;i>=top && k<l;i--)
                {
                    arr[k++] = (matrix[i][left]);
                }
                left++;
            }
        }
        int i=0;
        int j=arr.length-1;
        while(i<=j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}