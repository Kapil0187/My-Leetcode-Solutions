//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int multi;
    int step;
    Pair(int multi,int step)
    {
        this.multi = multi;
        this.step = step;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        int mod = (int)1e5;
        int dis[] = new int[mod];
        for(int i=0;i<mod;i++)
        {
            dis[i] = (int)1e9;
        }
        dis[start] = 0;
        while(!q.isEmpty())
        {
            int multi = q.peek().multi;
            int step  = q.peek().step;
            q.poll();
            for(int i=0;i<arr.length;i++)
            {
                int newmulti = ((arr[i]%mod)*(multi%mod))%mod;
                if(step+1<dis[newmulti])
                {
                    if(newmulti==end)
                        return step+1;
                    dis[newmulti] = step+1;
                    q.add(new Pair(newmulti,step+1));
                }
            }
        }
        if(dis[end]==(int)1e9)
            return -1;
        return dis[end];
    }
}
