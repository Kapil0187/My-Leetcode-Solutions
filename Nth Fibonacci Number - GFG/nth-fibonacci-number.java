//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static long nthFibonacci(long n){
        // code here
        if(n==0||n==1)
            return n;
        long curr = 0;
        long prev = 1;
        long prev2 = 0;
        n = n-2;
        while(n>=0)
        {
            curr = prev+prev2;
            prev2 = prev%1000000007;
            prev = curr%1000000007;
            n--;
        }
        
        return prev;
    }
}