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
    int step;
    int mult;
    Pair(int step,int mult)
    {
        this.step = step;
        this.mult = mult;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,start));
        int dist[] = new int[100000];
        for(int i=0;i<100000;i++)
            dist[i] = (int)1e9;
        dist[start] = 0;
        while(!q.isEmpty())
        {
            int step = q.peek().step;
            int mult = q.peek().mult;
            q.poll();
            for(int i=0;i<arr.length;i++)
            {
                int newmult = (mult*arr[i])%mod;
                if(step+1<dist[newmult])
                {
                    dist[newmult] = step+1;
                    if(newmult == end)
                        return step+1;
                    q.add(new Pair(step+1,newmult));
                }
            }
        }
        return -1;
    }
}
