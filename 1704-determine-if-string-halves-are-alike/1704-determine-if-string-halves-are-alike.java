class Solution {
    public boolean halvesAreAlike(String s) {
        int ca = 0;
        int cb = 0;
        int n = s.length()/2;
        for(int i=0;i<n;i++)
        {
            if(check(s.charAt(i)))
                ca++;
        }
        for(int i=n;i<s.length();i++)
        {
            if(check(s.charAt(i)))
                cb++;
        }
        return (ca==cb);
    }
    public boolean check(char ch)
    {
        switch(ch)
        {
            case 'a':
                return true;
            case 'e':
                return true;
            case 'i':
                return true;
            case 'o':
                return true;
            case 'u':
                return true;
            case 'A':
                return true;
            case 'E':
                return true;
            case 'I':
                return true;
            case 'O':
                return true;
            case 'U':
                return true;
            default:
                return false;
        }
    }
}