//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        ot.print(res[i] + " ");
		    ot.println();
		}
        ot.close();
	}
}



// } Driver Code Ends


// User Function Template for JAVA

class Solution{
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        long ans[] = new long[n];
        Stack<Long> stack = new Stack<>();
        int i=n-1;
        while(i>=0)
        {
            if(stack.isEmpty())
            {
                ans[i] = -1L;
                stack.push(arr[i]);
                --i;
            }
            else if(stack.peek()>arr[i])
            {
                ans[i] = stack.peek();
                stack.push(arr[i]);
                --i;
            }
            else if(stack.peek()<=arr[i])
            {
                stack.pop();
            }
        }
       
        return ans;
    } 
}