class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hasmap = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            hasmap.put(arr[i],hasmap.getOrDefault(arr[i],0)+1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int val : hasmap.keySet())
        {
            if(!set.contains(hasmap.get(val)))
                set.add(hasmap.get(val));
            else
                return false;
        }
        return hasmap.size()==set.size();
    }
}