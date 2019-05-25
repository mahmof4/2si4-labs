/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;
import java.util.Queue;

public class BSTree {
    
    private TNode root;
    
    BSTree()
    {
        root = null;
    }
    
    BSTree(int [] sortedInput)
    {
        int len = sortedInput.length;
        
        if(sortedInput.length==0)
        {
            root = null;
        }
        
        root= B_help(sortedInput, 0, len-1);
        
    }
    
    private TNode B_help(int[] list, int start, int end) 
    {      
            TNode L;
            TNode R;
            
            //This is the base case
		if (start > end)
			return null;
 
                 /* set the middle */
		int mid = (start + end) / 2;
                
                //construct both left and right subtree using recursion
        
                L = B_help(list, start, mid - 1);
                R = B_help(list, mid + 1, end);
                
		TNode node = new TNode(list[mid],L,R);
                
                //return the node we want that will be the root at the end
                
		return node;
	}
    
    public boolean isIn(int val)
    {
        
       TNode t = root;
        
       while(t!=null)
       {
           if(val>t.element) //we check to the right of the tree using this loop
           {
               t = t.right;
               continue; //continue because next if statement will run at the end if we dont have a continue
           }
           
           if(val<t.element) //we check to the left of the tree using this loop
           {
               t = t.left;
               continue; //we continue for good form here
           }
           
           else
           {
               return true;
           }
       }
       
        return false;   
    }
    
    public void add(int val) 
    {
        TNode t = root;
            if (t == null) //if we have an empty BST
            {
                  root = new TNode(val,null,null);//make 1 node
                  
            } 
            else
            {
                
                if(isIn(val) == true)//if the number is in the list, we dont add anything
                {
                    return;
                }
                
                while(t!=null) //we loop to the end of a leaf
                {
                    if(val<t.element) //if the value is smaller than the root, it must go in the left subtree
                    {
                        if(t.left != null) //we move over to the left if there is something there
                        {
                            t = t.left;
                           
                        }
                        
                        else
                        {
                            t.left = new TNode(val,null,null); //if there is nothing to the left, we add a new node
                            break;
                        }
                    }
                    if(val>t.element) //we know if this condition is met, we are in the right subtree
                    {
                        if(t.right!=null)//we mvoe over to the right
                        {
                            t = t.right;
                        }
                        else
                        {
                            t.right = new TNode(val,null,null);//if there is nothing there, we add a new node
                            break;
                        }
                    }
                }
            }
               
      }
        
         public void remove(int v){
            remove(v,root);//we use a helping method called R_node so we can use recursion
        }
        
       private TNode remove( int val, TNode t ){
           if( t == null )
               return null; //nothing to return so we spit out null
            
           if( val<t.element)//we look to the left if it is greaetr
               t.left = remove( val, t.left );
           
           //if the element in the node is smaller, we look at the right side
           else if( val>t.element)
               t.right = remove (val, t.right );
           
           
           else if( t.left != null && t.right != null ) // we find the minimum in the right if we have 2 children
           {
               t.element = findMin( t.right ).element;
               t.right = remove( t.element, t.right );
               
               //if the values are the same and there is only one child 
               //we link single child (with it's subtree) directly to the parent of the removed node.
           } 
           else
           {
               
               t = (t.left!=null)? t.left : t.right;
           }
               
               
           return t;
       }
        
       private TNode findMin(TNode tree) //extra method used to assist our remove
       {
           
           if (tree.left == null) {
               return tree;
           }
           return findMin(tree.left);
}
       
       
       
       public int size()//return the number of nodes
       {
           return size(root);//call recursive method count
       }
       
       private int size(TNode t)
       {
           if(t ==null)//base case 
           {
               return 0;
           }
           
           else
           {
               int temp=1;
               return (temp+size(t.left) +size(t.right));//continuously add 1 till we go through every node
           }
           
       }
       
       
      
       public int height()//returns the height
       {
           return height(root);
       }
       
       
       
      private int height(TNode t)//utulising recursion to find the height
{
    
    if(t == null)
        return -1;//return -1 base case
    
   
    int hl = height(t.left);//get the depth of the left subtree
  
    int hr = height(t.right);//depth of right subtree

  
    if(hl < hr)//return maximum depth
        return hr + 1;
    else
        return hl +1;
}
       
  
    public void printRec()//prints integer in recursive fashion by calling other function
    {
        printRec(root);
        System.out.println("");
    }

    /*
    Prints the integers stored in the subtree
rooted in t, in increasing order. This method is recursive.
    */
    private void printRec(TNode t)
    {
        if ( t == null )//base case
        {
            return;
        }
        printRec(t.left);
        System.out.print(t.element+" ");
        printRec(t.right);
    }

   
    
    public void printNonRec()
    {
        if (root == null) {
            return;
        }
        
        //keep the nodes in the path that are waiting to be visited
        MyStack temp = new MyStack();
        
        //sets current as address of root
        TNode node = root;
         
        //Pushes the current node and set current
        //first node to be visited will be the left one
        while (node != null) {
            temp.push(node);
            node = node.left;
        }
         
        // traverse the tree
        while (!temp.isEmpty()) {
           
            // visit the top node
            node = temp.pop();
            System.out.print(node.element + " ");
            
            // if there is a right node 
            // we go the that node and find it lowest value
            if (node.right != null) {
                node = node.right;
                 
                // the next node to be visited is the leftmost
                while (node != null) {
                    temp.push(node);
                    node = node.left;
                }
            }
        }
        
                System.out.println("");

    }
    
    /*
    Prints the integers stored in this BSTree
in level order, using a queue (use the class MyQueue)
    */
   
    
    public void printLevelOrder(){
        Level(root);
    }
    
  
    //method , uses ques to print the elements inlevel order 
 
    private static void Level(TNode t) {  
        
        if(t==null){
            return;
        }
        //make a new Queue 
        MyQueue temp=new MyQueue(); 
        //insert the root
        temp.enqueue(t); 
        
        //keep the process while the queue is not empty 
        while(!temp.isEmpty())  
        {  
            // we remove the node 
            //and print its element 
            TNode temp2=temp.dequeue();
            System.out.printf("%d ",temp2.element);
            
            //then we add its children to the queue 
            if(temp2.left!=null)
                temp.enqueue(temp2.left);
            if(temp2.right!=null)
                temp.enqueue(temp2.right);
        }  
        
        //we repeat the same process 
                    System.out.println("");

    }  
}