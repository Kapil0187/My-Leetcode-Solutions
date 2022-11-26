class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        while(j<s.length())
        {
            char ch = s.charAt(j);
            if(!set.contains(ch))
            {
                set.add(ch);
                j++;
            }
            else
            {
                while(set.contains(ch) && i<s.length())
                {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(ch);
                j++;
            }
            if(set.size()>max)
                max = set.size();
        }
        return max;
    }
}