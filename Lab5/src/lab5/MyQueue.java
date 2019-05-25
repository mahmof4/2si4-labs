/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author Fahad
 */

public class MyQueue {
    
   private Node front ;
   private Node back ;
    
   public MyQueue( )
   { 
       front = back = new Node(null,null);
   }
   
   public boolean isEmpty()
   {
       return (front ==back);
   }
   
   //get the size of the queue 
   public int getSize()
   {
       int size = 0;
       
       Node p = front;
       while(p.next !=null)
       {
           p=p.next;
           size++;
       }
       return size;
   }
   
   //add a node to the queue 
   
   public void enqueue(TNode temp)
   {
       back.next= new Node(temp,null);
       back = back.next;
   }
   
  
   public TNode dequeue()
   {
       if(isEmpty())
       {
           System.out.println("EmptyQueueException (Queue under flow)");
           return null;
       }
       else
       {
           if(back==front.next)//special case of 1 element
           {
               back =front;
           }
           TNode temp = front.next.element;
           front.next=front.next.next;
           return(temp);
       }
   }
}
