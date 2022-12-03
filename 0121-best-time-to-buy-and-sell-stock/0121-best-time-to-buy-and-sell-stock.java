class Solution {
    public int maxProfit(int[] prices) {
        int lest = Integer.MAX_VALUE;
        int pst = 0;
        int op = 0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<lest)
                lest = prices[i];
            pst = prices[i]-lest;
            if(pst>op)
                op = pst;
        }
        return op;
    }
}