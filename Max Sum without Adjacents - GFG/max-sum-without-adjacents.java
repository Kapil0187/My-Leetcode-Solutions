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
        int curr = 0;
        int prev = arr[0];
        int prev2 = 0;
        for(int i=0;i<n;i++)
        {
            int takes = arr[i];
            if(i>1)
                takes += prev2;
            int nottakes = 0;
            if(i>0)
                nottakes = prev;
            curr = Math.max(takes,nottakes);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}