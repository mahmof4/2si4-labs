/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Fahad
 */


public class Node{
    
    String object;
    Node move;
    
    public Node(String nobject, Node nnode){
        
        object=nobject;
        move=nnode;
    }
}