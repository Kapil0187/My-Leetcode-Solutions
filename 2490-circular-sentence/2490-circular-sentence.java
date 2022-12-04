class Solution {
    public boolean isCircularSentence(String sentence) {
        for(int i=0;i<sentence.length();i++)
        {
            char ch = sentence.charAt(i);
            if(ch==' ')
            {
               if(sentence.charAt(i-1)!=sentence.charAt(i+1))
                   return false;
            }
        }
        return (sentence.charAt(0)==sentence.charAt(sentence.length()-1));
    }
}