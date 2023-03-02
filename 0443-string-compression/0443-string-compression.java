class Solution {
    public int compress(char[] chars) {
        String s = "";
        int count = 0;
        char temp = chars[0];
        for(int i=0;i<chars.length;i++)
        {
            if(chars[i]==temp)
            {
                count++;
            }
            else
            {
                if(count==1)
                    s += temp;
                else
                    s = s + temp+count;
                temp = chars[i];
                count = 1;
            }
        }
        if(count==1)
            s += temp;
        else
            s = s + temp+count;
        for(int i=0;i<s.length();i++)
        {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}