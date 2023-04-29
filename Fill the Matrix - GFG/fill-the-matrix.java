//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java
class Pair{
    int row;
    int col;
    int step;
    Pair(int row,int col,int step)
    {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		Queue<Pair> q = new LinkedList<>();
		int grid[][] = new int[N][M];
		q.add(new Pair(x-1,y-1,0));
		grid[x-1][y-1] = 1;
		int dr[] = new int[]{-1,1,0,0};
		int dc[] = new int[]{0,0,-1,1};
	    int step = 0;
		while(!q.isEmpty())
		{
		    int row = q.peek().row;
		    int col = q.peek().col;
		    step = q.peek().step;
		    q.poll();
		    for(int i=0;i<4;i++)
		    {
		        int drow = row+dr[i];
		        int dcol = col+dc[i];
		        if(drow>=0 && dcol>=0 && drow<N && dcol<M && grid[drow][dcol]==0)
		        {
		            q.add(new Pair(drow,dcol,step+1));
		            grid[drow][dcol] = 1;
		        }
		    }
		}
		return step;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends