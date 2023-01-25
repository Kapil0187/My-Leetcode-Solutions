class Solution {
    public int bulbSwitch(int n) {
       int count =0;
        for(long i=1;i*i<=n;i++){
            count++;
        }
        return count;
    }
}