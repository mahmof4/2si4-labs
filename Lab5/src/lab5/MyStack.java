/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;
import java.util.EmptyStackException;

/**
 *
 * @author Fahad
 */

public class MyStack 
{
    
   private Node head;
   
   
   public MyStack()
   {
       head=null;
       
   }
   
   
   public boolean isEmpty()
   {
       return head==null;
       
   }
   
   
   public void push(TNode z)
   {
       head = new Node(z,head);
   }
   
   
   public TNode pop() throws EmptyStackException//remves the Last in item
   {
       if(isEmpty()){
           throw new EmptyStackException();
       }else{
           TNode z = head.element;
           head=head.next;
           return z;
       }
   }
   
   public TNode top()
   {
       return head.element;
   }
}