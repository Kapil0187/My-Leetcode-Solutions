//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[] = new int[n+1];
        return function(arr,n-1,dp);
    }
    public int function(int arr[],int ind,int []dp)
    {
        if(ind==0)
            return arr[0];
        if(ind<0)
            return 0;
        if(dp[ind]!=0)
            return dp[ind];
        int pick =  arr[ind] + function(arr,ind-2,dp);
        int notpick = function(arr,ind-1,dp);
        return dp[ind] = Math.max(pick,notpick);
    }
}