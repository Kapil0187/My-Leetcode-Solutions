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
        int star = 1;
        int space = 0;
        for(int i=1;i<=n*2-1;i++)
        {
            for(int j=1;j<=star;j++)
            {
                System.out.print("*");
            }
            space = (n*2)-(star*2);
            for(int j=1;j<=space;j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=star;j++)
            {
                System.out.print("*");
            }
            if(i<n)
                star++;
            else
                star--;
            System.out.println();
        }
    }
}