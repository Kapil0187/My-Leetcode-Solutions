class Solution {
    public boolean isPalindrome(String s) {
        String temp = "";
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch>=65 && ch<= 90 || ch>=97 && ch<=122 || ch>= 48 && ch<=57)
            {
                temp += ch;
            }
        }
        temp = temp.toLowerCase();
        return palindrome(temp);
    }
    public boolean palindrome(String s)
    {
        int left = 0;
        int right = s.length()-1;
        while(left<=right)
        {
            if(s.charAt(left)==s.charAt(right))
            {
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }
}