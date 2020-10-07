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
  
  
        Stack<Node> s = new Stack<Node>(); 
        Node curr = root; 
  
        // traverse the tree 
        while (curr != null || s.size() > 0) 
        { 
  
            /* Reach the left most Node of the 
            curr Node */
            while (curr !=  null) 
            { 
                /* place pointer to a tree node on 
                   the stack before traversing 
                  the node's left subtree */
                //s.push(curr); 
                s.push(new Node(0));
                curr = curr.left;
                
                
                
            } 
  
            /* Current must be NULL at this point */
            curr = s.pop(); 
  
            System.out.print(curr.data + " "); 
  
            /* we have visited the node and its 
               left subtree.  Now, it's right 
               subtree's turn */
            curr = curr.right; 
        } 
    } 
   // from https://stackoverflow.com/questions/20731833/constructing-a-binary-tree-in-java
    public void add(Node parent)
    {
           parent.left = new Node(0);
           parent.right = new Node(1);
    }
    
    public static void main(String args[]) 
    { 
  
        /* creating a binary tree and entering 
        the nodes */
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(0); 
        tree.root.right = new Node(1); 
        tree.root.left.left = new Node(0); 
        tree.root.left.right = new Node(1); 
        tree.inorder(); 
    } 
} 
