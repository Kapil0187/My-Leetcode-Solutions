class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length()!=t.length())
           return false;
       int[] friqS = new int[26];
       int[] friqt = new int[26];
      
       for(int i=0;i<s.length();i++)
       {
           friqS[s.charAt(i)-'a']++;
           friqt[t.charAt(i)-'a']++;
       }
       for(int i=0;i<26;i++)
       {
           if(friqS[i]==friqt[i])
               continue;
           else
               return false;
       }
        return true;
    }
}