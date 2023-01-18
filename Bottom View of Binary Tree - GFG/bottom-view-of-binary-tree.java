//{ Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java
class Tuple{
    Node node;
    int vertical;
    int level;
    Tuple(Node node,int ver,int lev)
    {
        this.node = node;
        this.vertical = ver;
        this.level = lev;
    }
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty())
        {
            Tuple tuple = q.poll();
            Node node = tuple.node;
            int v = tuple.vertical;
            int l = tuple.level;
            if(!map.containsKey(v))
            {
                map.put(v,new TreeMap<>());
            }
            if(!map.get(v).containsKey(l))
            {
                map.get(v).put(l,new ArrayList<>());
            }
            map.get(v).get(l).add(node.data);
            if(node.left!=null)
            {
                q.offer(new Tuple(node.left,v-1,l+1));
            }
            if(node.right!=null)
            {
                q.offer(new Tuple(node.right,v+1,l+1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        //System.out.print(map);
        for(TreeMap<Integer,List<Integer>> mp:map.values())
        {   
            List<Integer> list = new ArrayList<>();
            for(List<Integer> l : mp.values())
            {
                list.add(l.get(l.size()-1));
            }
            ans.add(list.get(list.size()-1));
        }
        return ans;
    }
}