//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
       int i=0;
       int j=0;
       int max = 0;
       HashSet<Character> set = new HashSet<>();
       while(i<S.length())
       {
           char ch = S.charAt(i);
           if(!set.contains(ch))
           {
               set.add(ch);
               i++;
           }
           else
           {
               while(set.contains(ch) && j<S.length())
               {
                   set.remove(S.charAt(j));
                   j++;
               }
               set.add(ch);
               i++;
           }
           if(set.size()>max)
            max = set.size();
       }
       return max;
    }
}