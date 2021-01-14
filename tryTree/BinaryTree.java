package tryTree;
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
    
     public int setBit(int num,int pos) {
    	 return num |= pos;
    	 
     }
    
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
            int temporaryNumber=1;
            while (height < 5|| s.size() > 0) 
            { 
            	/* Reach the left most Node of the 
                curr Node */
                while (height <5) 
                { 
                	System.out.println("\nHeight "+height);
                	//System.out.println("\nCurrent height :  "+height);
                    /* place pointer to a tree node on 
                       the stack before traversing 
                      the node's left subtree */
                	// toggle bit
                	//x ^= 0b1;
                	
                    s.push(curr); 
                    curr.left = new Node(1);
                    
                  //  x |= 4; // sets 3rd bit
                    
                    // System.out.println("\nSelected bit "+height);
                     //System.out.println("\nHeight : "+height+"\nExample "+test);
                      //System.out.println("\nTEST "+)
                    curr = curr.left;
                    //mask |= height; 
                //    temporaryNumber = setBit(0b000000,4);
                 //   int temporaryNumber2 = setBit(0b111,2);
                    
                 //   System.out.println("\nTEmp 1  : "+Integer.toBinaryString(temporaryNumber));
                 //   System.out.println("\nTEmp 2  : "+temporaryNumber2);
                    
                    
                  //  num |= pos;
                    //temporaryNumber = setBit(0b0000,2);
                    //temporaryNumber |= height;
                    temporaryNumber |= (int) Math.pow(2,height);
                    		
                    System.out.println("\nTemporary Number : "+Integer.toBinaryString(temporaryNumber));
//                     temporaryNumber |= 1;
                    		 //setBit(temporaryNumber,1);
//                   System.out.println("\nTemporary Number : "+Integer.toBinaryString(temporaryNumber));
                    
                    //mask = (int) Math.pow(2,height-1); 
                   // temp |=  mask;
                    //System.out.println("\n LEFT " + curr.data);
                    
                    height++;
                    
                    
                } 
                //System.out.println("\nLeft branch  : "+Integer.toBinaryString(temporaryNumber)); 

            /* Current must be NULL at this point */
            // s.pop goes to the left object
            curr = s.pop();
            
            
            /* we have visited the node and its 
            left subtree.  Now, it's right 
            subtree's turn */
            curr.right = new Node(0);
            curr = curr.right;
           
            System.out.println("\nLEFT HEIGHT "+height);
            height--;
            
            temporaryNumber |= (int) Math.pow(2,height);
    		System.out.println("\nRight ");
            
//          
            height--;
            
                        
            
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

