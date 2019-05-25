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
import java.lang.String;

public class WordLinkedList{
    
    private int sizeOfList; //size of the list
    private Node refBeg; //reference to the beginning of the linked list
    
    public WordLinkedList(){        
        //creating an empty list
        sizeOfList=0;
        refBeg=null;        
    }
    
    public WordLinkedList(String[] arrayOfWords){
        //creating a WordLinkedList object
        for(int x=0;x<(arrayOfWords.length);x++)
            //stores words from arrayOfWords
            this.insert(arrayOfWords[x]);        
    }
    
    public int getSize(){
        //returns the size of this list
        return sizeOfList;        
    }

    public String getWordAt(int i) throws IndexOutOfBoundsException{
        if(i>=0 && i<sizeOfList){//searching for valid positions
            int check=0;
            Node location=refBeg; //creating a new Node
            
            //this for loops finds the location of word and returns it
            for(;location.move!=null;location=location.move){
                if(check==i){
                    break;}
                check++;
            }return location.object;
        }
        else
            throw new IndexOutOfBoundsException ("This index is not valid!");
    }
    
    public void insert(String newword){
        
        //creating new Nodes
        Node nwNode=new Node(newword,null);        
        Node check=new Node(null,refBeg);
        Node location=check;
        
        if(find(newword)==-1){ //using find function to find word
            for(int x=0;;x++){    
                if(location.move==null){ //if there is no word in list
                    location.move=nwNode;
                    refBeg=check.move;
                    this.sizeOfList++;
                    return;
                } 
                if(location.move.object.compareTo(newword)>0){
                    nwNode.move=location.move;
                    location.move=nwNode;
                    refBeg=check.move; //update refBeg
                    this.sizeOfList++; //increment 
                    return;
                }
                location=location.move; //change location
            }
        }
    }

    public int find(String word)
    {
        if(sizeOfList==0){ //if list is empty
            return -1;}      
        
        Node location=refBeg;
        int check=0;
        
        //this for loop finds the word
        for (;location!=null;location=location.move){
            //if the word is similar
            if ((location.object.compareTo(word))==0){
                return check;
            }
            check++; //increment check
        }return -1;
    }   
    
public String remove(int i) 
    {
        Node location = refBeg;
        int check = 0;
        String word = null;
        
        //if loop to check words
        if (refBeg!=null && (i>0 && i<sizeOfList)){
            for (;location.move!=null;location=location.move){
                if (check==(i-1)){ //check
                    word=location.move.object; //update word
                    location.move=location.move.move;
                    sizeOfList--; //decrement size of the list
                    break; //break the loop
                }                
                check++; //increment check
            }            
            return word; //return the removed
        }
        
        else if (refBeg!=null && i==0){    
            word=refBeg.object; //update word
            refBeg=refBeg.move; //update refBeg
            sizeOfList--; //decrement size of the list
            return word; //return the removed
        }
        else 
            throw new IndexOutOfBoundsException("This index is not valid!");
    }
    
    public void mergeTo(WordLinkedList that){
        Node check =new Node(null,this.refBeg);
        Node loc1=check;
        Node loc2=that.refBeg;
        
        while(loc1.move!=null && loc2!=null){
            
            if(loc2.object.compareTo(loc1.move.object)>0){
                loc1=loc1.move; //update loc1
            }
            
            else if(loc2.object.compareTo(loc1.move.object)<0){
                Node inter=loc2; //new node temporary
                loc2=loc2.move; //update loc2
                inter.move=loc1.move; //next
                
                loc1.move=inter;
                loc1=loc1.move;
                
                that.sizeOfList--; //decrement
                sizeOfList++; //increment 
            }
            
            else{ //else do this
                loc2=loc2.move;
                that.sizeOfList--; //decrement
            }
        }
        
        if(loc2!=null){ //if loc2 is null
            loc1.move=loc2; //next loc1 becomes loc2
            sizeOfList+=that.sizeOfList; //increment
        that.sizeOfList=0; 
        }
        this.refBeg=check.move;
        that.refBeg=null;
    }
        
    public String toString() 
    {
        String nothing=""; //creating new string
	
        if(sizeOfList==0){
	    nothing="The list is empty"; //if size if 0, list is empty
        }
        
        else{
	    nothing=new String(""); //new string
            Node location=refBeg; //location
            
            //for loop to list words in alphabetical order
            for(;location!=null;location=location.move){ 
                nothing=nothing+location.object+"\n";
            }
        }
        return nothing;
    }
}