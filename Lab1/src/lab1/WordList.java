/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Fahad
 */
public class WordList {
    private int size; //size of the list
    private String[] arraywords; //array to store the words
    private int capacity; //stores the capacity of the list, size of array
    
    public WordList(int capacity){
        this.capacity = capacity;
        this.size=0;
        //empty WordList of specified capacity
        this.arraywords = new String[this.capacity];
    }
    
    public WordList(String[] arrayOfWords){
        this.size=arrayOfWords.length;
        this.capacity=2*this.size; //this array's capacity is doubled
        this.arraywords=new String[this.capacity];
        String X; //temporary string
        
        for(int i=0;i<size;i++){
            arraywords[i]=arrayOfWords[i];
        }
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                //i and j are compared as no comparison is needed when words are same
                if(i!=j){
                    //repeated words
                    if(arraywords[i]==arraywords[j]){
                        //repeated word becomes null
                        arraywords[j]=null;
                        //size is decremented
                        size--;
                    }
                }
            }
        }
        
        //after repeated words become null
        for(int i=0;i<size;i++){
            if(arraywords[i]==null){
                for(int j=i;j<(size-1);j++){
                    //present element is stored into temporary string
                    X=arraywords[j];
                    //present element which becomes next
                    arraywords[j]=arraywords[j+1];
                    //next element which becomes present
                    arraywords[j+1]=X;
                }
            }
        }
        
        //left side has words and right has null, in array
        int sorted=0; //indicates if array is sorted or no
        while(sorted==0){
            for(int i=1;i<size;i++){
                //if present word is further than the second
                if(arraywords[i-1].compareTo(arraywords[i])>0){
                    //swapping the words
                    X=arraywords[i-1]; //x is temporary
                    arraywords[i-1]=arraywords[i];
                    arraywords[i]=X;
                }
                
                for(int j=0;j<size-1;j++){
                    //if present word is further than the second
                    if(arraywords[j+1].compareTo(arraywords[j])>0){
                        //the list is sorted
                        sorted=1;
                    }
                    
                    //if present word is before
                    else{
                        //the list is not sorted
                        sorted=0;
                        break;
                    }
                }
                
            }
            
        }
        
    }
    
    public int getSize(){
        return this.size; //returns the size of this list
    }
    
    public int getCapacity(){
        return this.capacity; //returns capacity of this list
    }
    
    public String getWordAt(int i) throws ArrayIndexOutOfBoundsException{
        String arrayword = new String(); //creating new String object
        //according to requirement valid positions are bw 0 and n-1
        if(i>=0 && i<size){
            arrayword=arraywords[i];
        }
        //if the input index does not correspond to valid position
        else{
            throw new ArrayIndexOutOfBoundsException("InValid Input");
        }
        //a new String object representing the word at position i in the list
        return arrayword;
    }
   
    public void insert(String newword){
        //if word is not in the list
        if(find(newword)==-1){
            //if there is space in the last
            if(capacity>size){
                int location=size;
                
                for(int i=0;i<size;i++){
                    //from left side, determine where to insert the new word
                    if(arraywords[i].compareTo(newword)>0){
                        //assign index to location
                        location=i;
                        break;
                    }
                }
                int last=size;
                
                //move everything by one from the location
                while(last>location){
                    arraywords[last]=arraywords[--last];
                }
                
                //increase size of the list
                size++;
                //insert the new word in the list
                arraywords[location]=newword;
            }
            
            else{
                String[] List= new String[2*capacity];
                for(int i=0;i<size;i++){
                    List[i]=arraywords[i];
                }
                int location=size;
                
                for(int i=0;i<size;i++){
                    //from left side, determine where to insert the new word
                    if(List[i].compareTo(newword)>0){
                        location=i;
                        break;
                    }
                }
                int last=size;
                
                //move everything by one from the location
                while(last>location){
                    List[last]=List[--last];
                }
                
                List[location]=newword;
                size++;
                capacity=2*capacity;
                arraywords=List;
            }
            
        } 
        
    }
    
    public int find(String word){
        int min=0;
        int max=this.size-1;
        int middle;
        
        while(min<=max){
            middle=(min+max)/2;
            //if word is in the middle
            if(word==arraywords[middle]){
                return middle;
            }
            //if positive move right
            if(word.compareTo(arraywords[middle])>0){
                min=middle+1;
            }
            //if negative move left
            else{
                max=middle-1;
            }
        }
        return -1; //if the word is not found
    }
    
    public void remove(String word){
        int init=0; //checks if word exists
        int location=0;
        
        //for loop checks if word exists in the array
        for(int i=0;i<this.size;i++){
            if(word==arraywords[i]){
                init=1;//if word exists
                location=i;
                break;
            }
        }
        
        //if word exists in the array of words
        if(init==1){
            size--; //decrease the size of array
            for(int i=location;i<size;i++){
                arraywords[i]=arraywords[i+1]; //move the words backwards
            }
            arraywords[size]=null; //at nth index word becomes null because array is 1 less than before
        }
        
    }
    
    public WordList sublist(char init, char fin){
        WordList subList = new WordList(2*this.capacity); //new array of double capacity
        int x=-1;
        
        //each letter in range of init and fin
        for(int i=init;i<=fin;i++){
            //each element in the array
            for(int j=0;j<size;j++){
                //if letter match
                if(arraywords[j].charAt(0)==i){
                    x++; //indices for words of sublist
                    //storing words in sublist
                    subList.arraywords[x]=arraywords[j];
                }
            }
        }
        
        subList.size=x+1;
        subList.capacity=subList.size*2;
        
        //when list is empty
        if(subList.arraywords[0]==null){
            //this array capacity equal to sublist capacity
            subList.capacity=this.capacity;
        }
        //returns new list called sublist
        return subList;
    }
    
    public int countInRange( char init, char fin ){
        int min=0;
        int max=size-1;
        int middle;
        
        //binary search method for init
        while(min<=max){
            middle=(min+max)/2;
            //when first letter is less than init then move right
            if(this.arraywords[middle].charAt(0)<init){
                min=middle+1;
            }
            //when first letter is more than init then move left
            else{
                max=middle-1;
            }
        }
        //tells the starting word
        int first_element=min;
        
        min=0;
        max=size-1;
        
        //binary search again for fin
        while(min<=max){
            middle=(min+max)/2;
            //when first letter is great than fin then move left
            if(this.arraywords[middle].charAt(0)>fin){
                max=middle-1;
            }
            //otherwise move right
            else{
                min=middle+1;
            }
        }
        //tells last word
        int second_element=max;
        
        //when nothing is found
        if(first_element==0 && second_element==size-1){
            return 0;
        }
        
        return (second_element-first_element+1);
    }
    
    public String toString(){
        String alphaList = new String();
        //when list has space
        if (size<capacity){
            for (int i=0;i<this.size;i++){
                alphaList=alphaList + (this.arraywords[i] + "\n");
            }
        }
        
        //when list is full
        if (size>capacity){
            for (int i=0;i<this.capacity-1;i++){
                alphaList=alphaList + (this.arraywords[i] + "\n");
            }
        }
        
        //when list is empty
        if (arraywords[0]==null){
            alphaList="The list is empty";
        }
        return alphaList;
    }
    
}