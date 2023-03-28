//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java
class DisjointSet{
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    DisjointSet(int n){
        for(int i=0;i<=n;i++)
        {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUpar(int node)
    {
        if(parent.get(node)==node)
            return node;
        int ulp = findUpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    public void unionByrank(int u,int v)
    {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if(ulp_u==ulp_v)
            return;
        if(rank.get(ulp_u)<rank.get(ulp_v))
            parent.set(ulp_u,ulp_v);
        else if(rank.get(ulp_v)<rank.get(ulp_u))
            parent.set(ulp_v,ulp_u);
        else
        {
            parent.set(ulp_v,ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
}

class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> mapMailNode = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String mail = accounts.get(i).get(j);
                if(mapMailNode.containsKey(mail)==false)
                {
                    mapMailNode.put(mail,i);
                }
                else
                {
                    ds.unionByrank(i,mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] margeMail = new ArrayList[n];
        for(int i=0;i<n;i++)
            margeMail[i] = new ArrayList<String>();

        for(Map.Entry<String,Integer> it : mapMailNode.entrySet())
        {
            String mail = it.getKey();
            int node = ds.findUpar(it.getValue());
            margeMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(margeMail[i].size()==0)
                continue;
            Collections.sort(margeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : margeMail[i])
            {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
  }
}
     