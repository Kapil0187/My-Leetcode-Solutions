//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
       Node l1 = reverse(first);
       Node l2 = reverse(second);
       Node ans = new Node(0);
       Node temp = ans;
       int curry=0;
       while(l1!=null && l2!=null)
       {
           int sum = l1.data + l2.data+curry;
           if(sum>9)
           {
               sum = sum%10;
               Node t = new Node(sum);
               temp.next = t;
               temp = t;
               curry = 1;
           } 
           else
           {
               Node t = new Node(sum);
               temp.next = t;
               temp = t;
               curry = 0;
           }
           l1 = l1.next;
           l2 = l2.next;
       }
       while(l1!=null)
       {
           int sum = l1.data+curry;
           if(sum>9)
           {
               sum = sum%10;
               Node t = new Node(sum);
               temp.next = t;
               temp = t;
               curry = 1;
           } 
           else
           {
               Node t = new Node(sum);
               temp.next = t;
               temp = t;
               curry = 0;
           }
           l1 = l1.next;
       }
       while(l2!=null)
       {
           int sum = l2.data+curry;
           if(sum>9)
           {
               sum = sum%10;
               Node t = new Node(sum);
               temp.next = t;
               temp = t;
               curry = 1;
           } 
           else
           {
               Node t = new Node(sum);
               temp.next = t;
               temp = t;
               curry = 0;
           }
           l2 =l2.next;
       }
       if(curry==1)
       {
           Node t = new Node(1);
           temp.next = t;
           temp = t;
       }
       ans = reverse(ans.next);
       return ans;
    }
    public static Node reverse(Node head)
    {
        if(head==null||head.next==null)
            return head;
        Node prev = null;
        Node curr = head;
        while(curr!=null)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}