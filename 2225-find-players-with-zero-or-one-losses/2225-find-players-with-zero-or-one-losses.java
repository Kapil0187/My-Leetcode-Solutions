class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> winhas = new HashMap<>();
        HashMap<Integer,Integer> loshas = new HashMap<>();
        for(int i=0;i<matches.length;i++)
        {
            int w = matches[i][0];
            int l = matches[i][1];
            winhas.put(w,winhas.getOrDefault(w,0)+1);
            loshas.put(l,loshas.getOrDefault(l,0)+1);
        }
        
        ArrayList<List<Integer>> ans = new ArrayList<>();
        List<Integer> winlist = new ArrayList<>();
        List<Integer> loslist = new ArrayList<>();
        
        for(int n : winhas.keySet())
        {
            if(!loshas.containsKey(n))
                winlist.add(n);
        }
        Collections.sort(winlist);
        ans.add(winlist);
        
        for(int n : loshas.keySet())
        {
            if(loshas.get(n)==1)
                loslist.add(n);
        }
        Collections.sort(loslist);
        ans.add(loslist);
        return ans;
    }
}