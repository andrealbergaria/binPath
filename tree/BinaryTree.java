// get 254 bits from tree

// https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
// non-recursive java program for inorder traversal 
import java.util.Stack; 
  
/* Class containing left and right child of 
current node and key value*/

class Node 
{ 
    int data; 
    Node left, right; 
  
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
  


/* Class to print the inorder traversal */
class BinaryTree 
{ 
	
    Node root; 
    void inorder() 
    { 
    	
        if (root == null) 
            return; 
  
        int height = 1;
        Stack<Node> s = new Stack<Node>(); 
        Node curr = root; 
        // traverse the tree 
        
            
            /* Reach the left most Node of the 
            curr Node */
            
            while (height < 4|| s.size() > 0) 
            { 
            	int temp=0;
        		/* Reach the left most Node of the 
                curr Node */
                while (height < 4) 
                { 
                    /* place pointer to a tree node on 
                       the stack before traversing 
                      the node's left subtree */
                    
                    s.push(curr); 
                    curr.left = new Node(1);
                    
                  //  x |= 4; // sets 3rd bit
                    
                    // System.out.println("\nSelected bit "+height);
                     //System.out.println("\nHeight : "+height+"\nExample "+test);
                      
                     //System.out.println("\nTEST "+)
                    curr = curr.left;
                    int mask = (int) Math.pow(2,height-1); 
                    temp |=  mask;
                    System.out.println("\nExample "+Integer.toBinaryString(temp));
                    height++;
                    
                } 
                

            /* Current must be NULL at this point */
            // s.pop goes to the left object
            curr = s.pop();
            height--;
            //System.out.println("\nHeight : "+height+"\nExample "+test);

            /* we have visited the node and its 
               left subtree.  Now, it's right 
               subtree's turn */
            curr.right = new Node(0);
            curr = curr.right;
           height++;
            
        } 
    } 
    
    public static void main(String[] args) 
    { 
  
        /* creating a binary tree and entering 
        the nodes */
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1);
        
        /*tree.root.left = new Node(0);
        tree.root.right = new Node(1);
        
        tree.root.left.left = new Node(0); 
        tree.root.left.right = new Node(1);
        */ 
        tree.inorder(); 
    } 
} 

