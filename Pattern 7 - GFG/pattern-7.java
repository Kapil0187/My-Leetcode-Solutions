//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printTriangle(int n) {
        // code here
        for(int i=1;i<=n;i++)
        {
            
            for(int j=1;j<=(n*2)-1;j++)
            {
                
                if(j>=((n+1)-i)&& j<=((n-1)+i))
                {
                    System.out.print("*");
                    if(j==(n-1)+i)
                        break;
                }
                else 
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}