class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> hasmap = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if(!hasmap.containsKey(str))
            {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hasmap.put(str,list);
            }
            else
                hasmap.get(str).add(strs[i]);
        }
        for(String st : hasmap.keySet())
        {
            ans.add(hasmap.get(st));
        }
        return ans;
    }
}