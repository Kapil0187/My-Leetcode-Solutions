class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1)
            return stones[0];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b)->(b-a));
        for(int i=0;i<stones.length;i++)
        {
            q.add(stones[i]);
        }
        while(q.size()>1)
        {
            int first = q.poll();
            int second = q.poll();
            if(first==second)
            {
              q.add(first-second);
            }
            else
            {
                if(first>second)
                {
                    q.add(first-second);
                }
                else
                {
                    q.add(second-first);
                }
            }
        }
        return q.peek();
    }
}