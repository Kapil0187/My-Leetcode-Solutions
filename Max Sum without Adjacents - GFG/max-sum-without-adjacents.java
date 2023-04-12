//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        if(n==1)
            return arr[0];
        int dp[] = new int[n];
        dp[0] = arr[0];
        for(int i=0;i<n;i++)
        {
            int takes = arr[i];
            if(i>1)
                takes += dp[i-2];
            int nottakes = 0;
            if(i>0)
                nottakes = dp[i-1];
            dp[i] = Math.max(takes,nottakes);
        }
        return dp[n-1];
    }
}