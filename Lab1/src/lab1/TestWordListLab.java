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
public class TestWordListLab {
    
    public static void main(String[] args) {

        //Inputs

        int capacity=8; //capacity
        int capacity2=3; //capacity
        
        int i1=1; //valid position in arraywords2
        int i2=5; //invalid position in arraywords2 ( size<=i2<=capacity-1 )
        int i3=10; //invalid position in arraywords2 ( i3<0 or i3>capacity-1 )
        
        //init and fin for sublist()
        char t1='a';
        char t2='h';
        char t3='b';
        char t4='i';
        char t5='c';
        char t6='l';  
        char t7='d'; 
        char t8='q'; 
        
        String[] arraywords2={"apple", "all", "bag", "cup"}; //For testing insert and remove, Sorted
	String[] arraywords3={"new", "too", "alter", "fever", "broom"}; //For testing constructor 2, Unsorted
        String[] arraywords4={"maple","kite","set","kite"}; //For testing constructor 2, Unsorted
        String[] arraywords5={"fool", "fog","fell","hit", "hithit", "mop", "ny", "egg", "men",  "sup"}; //For testing sublist and find

	String w2="bet";//not in arraywords2
        String w4="bag";//in arraywords2
        String w7="new";//last word of arraywords2
	String w6="fog";//in arraywords5 - test find()
	String w1=w7+"er";
        String w5=w1+"s";
	String w8="aabb"; //smaller than first word in arraywords2
        
	//**************************************************************************************
        
        //Test
 
        //Test 1 - Constructor 1
        
        WordList array1= new WordList(capacity);
        System.out.println("Test 1 - Constructor 1:\n"+"Array:\n"+ array1.toString());
        System.out.println("Capacity="+ array1.getCapacity());
        System.out.println("Size="+ array1.getSize());        
        
        
        System.out.println("-------------------------------------------------------------");
        
        //Test 2 - Constructor 2
        //with sorted array
       
        WordList array2= new WordList(arraywords2);
        //test if words are stored correctly
        System.out.println("Test 2 - Constructor 2 (SORTED):\n"+"Array:\n"+array2.toString());
        System.out.println("capacity="+array2.getCapacity());
        System.out.println("size="+array2.getSize());

	
	System.out.println("-------------------------------------------------------------");
        
        //Test 3 - Constructor 2
        //with unsorted array
        
        WordList array4= new WordList(arraywords3);
        
        System.out.println("Test 3 - Constructor 2 (SORTED WITHOUT REPITIONS):\n"+"Array:\n"+array4.toString());
        System.out.println("Capacity="+array4.getCapacity());
        System.out.println("Size="+array4.getSize());

 
	System.out.println("-------------------------------------------------------------");
        
        //Test 4 - Constructor 2
        //unsorted array with repititions
        
        array4= new WordList(arraywords4);
        
        System.out.println("Test 4 - Constructor 2 (UNSORTED WITH REPITITIONS), Word:\n"+"Array:\n"+array4.toString());
        System.out.println("Capacity="+array4.getCapacity());
        System.out.println("Size="+array4.getSize());
              
        
        System.out.println("-------------------------------------------------------------");
        
        //Test 5
        //insert word in an array 2 at the end
        
        array2.insert(w1);
        System.out.println("Test 5 - Insert a word in an array at the end, Word: "+w1+"\nArray:\n"+array2.toString());
        System.out.println("Capacity="+array2.getCapacity());
        System.out.println("Size="+array2.getSize());
                
             
        System.out.println("-------------------------------------------------------------");
        
        //Test 6
        //insert a word inside an array
        
        array2=new WordList(arraywords2);
        array2.insert(w2);
        System.out.println("Test 6 - Insert a word in an array, Word: "+w2+"\nArray:\n"+array2.toString());
        System.out.println("Capacity="+array2.getCapacity());
        System.out.println("Size="+array2.getSize());


	System.out.println("-------------------------------------------------------------");
        
        //Test 7
        //insert a word in an array at front 
        
        array2=new WordList(arraywords2);
        array2.insert(w8);
        System.out.println("Test 7 - Insert a word in an array at the front, Word: "+w8+"\nArray:\n"+array2.toString());
        System.out.println("Capacity="+array2.getCapacity());
        System.out.println("Size="+array2.getSize());
        

         System.out.println("-------------------------------------------------------------");
        
        //Test 8
        //insert a word in an array when it is already in it
         
        array2=new WordList(arraywords2);
        array2.insert(w4);
        System.out.println("Test 8 - Insert a word when it is already in an array, Word: "+w4+"\nArray:\n"+array2.toString());
        System.out.println("Capacity="+array2.getCapacity());
        System.out.println("Size="+array2.getSize());
        

         System.out.println("-------------------------------------------------------------");
        
        //Test 9
        //insert a word in an empty array
         
        array1= new WordList(capacity);
        array1.insert(w1);
        System.out.println("Test 9 - Insert a word: "+w1+ " in an empty array:\n"+"Array:\n"+array1.toString());
        System.out.println("Capacity="+array1.getCapacity());
        System.out.println("Size="+array1.getSize());
        
        
        System.out.println("-------------------------------------------------------------");
        
        //Test 10
        //insert when size is equal to capacity and word is not in an array
        
        array2= new WordList(capacity2);
        for(int i=0;i<capacity2;i++){
            array2.insert(w1);
            w1=w1+"o";
        }
        System.out.println("Test 10 - insert when size is equal to capacity and word is not in an array, Word: "+w2);
        array2.insert(w2);
        System.out.println("List:\n"+array2.toString());
        System.out.println("Capacity="+array2.getCapacity());
        System.out.println("Size="+array2.getSize());             
        
        
         System.out.println("-------------------------------------------------------------");
        
        //Test 11 
        //getWordAt testing VALID
         
        array2=new WordList(arraywords2);
        try{
            System.out.println("Test 11 - getWordAt(i) (VALID):");
            System.out.println(array2.getWordAt(i1));
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

        
        System.out.println("-------------------------------------------------------------");
        
        //Test 12
        //getWordAt testing INVALID
        try{
            System.out.println("Test 12 - getWordAt(i) (INVALID):");
            System.out.println(array2.getWordAt(i2));
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }


	System.out.println("-------------------------------------------------------------");
        
        //Test 14
        //getWordAt testing INVALID
        
        try{
            System.out.println("Test 13 - getWordAt(i) (INVALID):");
            System.out.println(array2.getWordAt(i3));
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        
        
        System.out.println("-------------------------------------------------------------");
        
        //Test 14
        //find KEY NOT IN ARRAY
        
        array2= new WordList(arraywords5);
        System.out.println("Test 14 - find, KEY NOT IN ARRAY:" + w2);
        int find=array2.find(w2);
        System.out.println("Output: "+ find);


        System.out.println("-------------------------------------------------------------");
        
        //Test 15
        //find KEY IN ARRAY
        
        System.out.println("Test 15 - find, KEY IN ARRAY:" + w6);
        find=array2.find(w6);
        System.out.println("Output: "+ find);
        

        System.out.println("-------------------------------------------------------------");
        
        //Test 16
        //remove word not in array
         
        System.out.println("Test 16 - remove word not in array, Word "+w2);
        array2=new WordList(arraywords2);
        array2.remove(w2);
        System.out.println("Array: \n"+array2.toString());
        System.out.println("Capacity="+array2.getCapacity());
        System.out.println("Size="+array2.getSize());


        System.out.println("-------------------------------------------------------------");
        
        //Test 17
        //remove a word from array
        
        array2= new WordList(arraywords2);
        System.out.println("Test 17 - remove a word from array, Word: "+w4);
        array2.remove(w4);
        System.out.println("Array: \n"+array2.toString());
        System.out.println("Capacity="+array2.getCapacity());
        System.out.println("Size="+array2.getSize());


        System.out.println("-------------------------------------------------------------");
        
        //Test 18 
        //remove a word from empty array
        System.out.println("Test 18 - remove a word from empty array:");
        WordList array5= new WordList(capacity);
        array5.remove(w7);
        System.out.println("Array: \n"+array5.toString());
        System.out.println("Capacity="+array5.getCapacity());
        System.out.println("Size="+array5.getSize());

        
        System.out.println("-------------------------------------------------------------");
        
        //Test 19 
        //sublist EMPTY ARRAY - capacity is positive
        
        System.out.println("Test 19 - Sublist EMPTY ARRAY (" + t3 + "," + t4 +")" );
        WordList array6= new WordList(capacity);
        WordList array7=array6.sublist(t3,t4);
        System.out.println("Sublist: \n"+array7.toString());
        System.out.println("Capacity="+array7.getCapacity());
        System.out.println("Size="+array7.getSize());
        System.out.println("Count in range(" + t3 + "," + t4 +") is: "+array6.countInRange(t3,t4));
        
        System.out.println("-------------------------------------------------------------");
        
        array6= new WordList(arraywords5);
        System.out.println("Test cases 20-23 are based on array: \n"+array6.toString());
        
        
        System.out.println("-------------------------------------------------------------");
        
        //Test 20
        //sublist NON EMPTY ARRAY - capacity is positive
        
        System.out.println("Test 20 - sublist NON EMPTY ARRAY  (" + t1 + "," + t2 +")" );
        array6= new WordList(arraywords5);
        array7=array6.sublist(t1,t2);
        System.out.println("Sublist: \n"+array7.toString());
        System.out.println("Capacity="+array7.getCapacity());
        System.out.println("Size="+array7.getSize());
        System.out.println("Count in range(" + t1 + "," + t2 +") is: "+array6.countInRange(t1,t2));      
        
        
        System.out.println("-------------------------------------------------------------");
        
        //Test 21
        //sublist NON EMPTY SUBLIST, words starting with init and fin are in list
        
        System.out.println("Test 21 - non-empty sublist (" + t3 + "," + t4 +")" );
        array6= new WordList(arraywords5);
        array7=array6.sublist(t3,t4);
        System.out.println("Sublist: \n"+array7.toString());
        System.out.println("Capacity="+array7.getCapacity());
        System.out.println("Size="+array7.getSize());
        System.out.println("Count in range(" + t3 + "," + t4 +") is: "+array6.countInRange(t3,t4));


	System.out.println("-------------------------------------------------------------");
        
        //Test 22 
        //sublist NON EMPTY SUBLIST, init and fin not in list
        
        System.out.println("Test 22 - non-empty sublist (" + t7 + "," + t8 +")" );
        array6= new WordList(arraywords5);
        array7=array6.sublist(t7,t8);
        System.out.println("sublist: \n"+array7.toString());
        System.out.println("capacity="+array7.getCapacity());
        System.out.println("size="+array7.getSize());
        System.out.println("count in range(" + t7 + "," + t8 +") is: "+array6.countInRange(t7,t8));       
        
        
        System.out.println("-------------------------------------------------------------");
        
        //Test 23 
        //sublist PREFIX OR SUFFIX
        
        System.out.println("Test 23 - sublist PREFIX OR SUFFIX (" + t5 + "," + t6 +")" );
        array6= new WordList(arraywords5);
        array7=array6.sublist(t5,t6);
        System.out.println("Sublist: \n"+array7.toString());
        System.out.println("Capacity="+array7.getCapacity());
        System.out.println("Size="+array7.getSize());   
        System.out.println("Count in range(" + t5 + "," + t6 +") is: "+array6.countInRange(t5,t6));    
    }
}