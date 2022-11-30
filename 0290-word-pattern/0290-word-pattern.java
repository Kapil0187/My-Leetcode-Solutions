class Solution {
    public boolean wordPattern(String pattern, String s) {
        String str[] = s.split(" ");
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        if(str.length==pattern.length())
        {
            for(int i=0;i<pattern.length();i++)
            {
                char ch = pattern.charAt(i);
                if(!map.containsKey(ch) && !set.contains(str[i]))
                {
                    map.put(ch,str[i]);
                    set.add(str[i]);
                }
                else
                {
                    if(map.containsKey(ch) && map.get(ch).equals(str[i]))
                        continue;
                    else
                        return false;
                }
            }
        }
        else
            return false;
        return true;
    }
}