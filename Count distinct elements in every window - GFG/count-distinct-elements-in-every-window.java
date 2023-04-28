//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<k)
        {
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            i++;
        }
        ans.add(map.size());
        if(map.get(A[j])==1)
            map.remove(A[j]);
        else
            map.put(A[j],map.getOrDefault(A[j],0)-1);
        j++;
        while(i<n)
        {
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            ans.add(map.size());
            if(map.get(A[j])==1)
                map.remove(A[j]);
            else
                map.put(A[j],map.getOrDefault(A[j],0)-1);
            i++;
            j++;
        }
        return ans;
    }
}

