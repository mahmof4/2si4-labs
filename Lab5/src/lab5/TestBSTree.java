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
public class TestBSTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
                int[] d1 = {1,2,3,4,5,6,7};
                int[] d2 = {0,5, 6, 7,8,9,10,15};
                int test_isIn_yes = 6;
                int test_isIn_no  = 1;
                int addTo_a2 = 0;
                int addTo_a3 = 20;
                 
                int remove_a2 = 2;
                int remove_a3 = 20;
                int remove_a3_2 = 10;
                int remove_a3_root = 7;
                
		System.out.println("Test1---constructor1" );
                BSTree a1 = new BSTree();
		a1.printRec();
                System.out.println("size is: "+a1.size());
                System.out.println("\n");
		 
		System.out.println("Test2---constructor2" );
		BSTree a2 = new BSTree(d1);
                System.out.println("Print In Recursion: ");
		a2.printRec();
                System.out.println("height is: "+a2.height());
                System.out.println("size is: "+a2.size());
                System.out.println("Print Non Recursion: ");
                a2.printNonRec();
                System.out.println();
                System.out.println("Print Level Order");
                a2.printLevelOrder();
		System.out.println("\n");
		
		System.out.println("Test3---constructor2" );
		BSTree a3 = new BSTree(d2);
                System.out.println("Print In Recursion: ");
		a3.printRec();
                System.out.println("height is: "+a3.height());
                System.out.println("size is: "+a3.size());
                System.out.println("Print Non Recursion: ");
                a3.printNonRec();
                System.out.println();
                System.out.println("Print Level Order");
                a3.printLevelOrder();
		System.out.println("\n");
		
		System.out.println("Test4---isIn(1)---yes" );
		System.out.println(a3.isIn(test_isIn_yes));
		System.out.println("\n");
		
		System.out.println("Test5---isIn(3)---no" );
		System.out.println(a3.isIn(test_isIn_no));
		System.out.println("\n");
		
		System.out.println("Test6---add()" );
                System.out.println("element added is "+addTo_a2);
		a2.add(addTo_a2);
                System.out.println("Print In Recursion: ");
		a2.printRec();
                System.out.println("height is: "+a2.height());
                System.out.println("size is: "+a2.size());
                System.out.println("Print Non Recursion: ");
                a2.printNonRec();
                System.out.println();
                System.out.println("Print Level Order");
                a2.printLevelOrder();
		System.out.println("\n");
		
                System.out.println("Test7---add()" );
                System.out.println("element added is "+addTo_a3);
		a3.add(addTo_a3);
                System.out.println("Print In Recursion: ");
		a3.printRec();
                System.out.println("height is: "+a3.height());
                System.out.println("size is: "+a3.size());
                System.out.println("Print Non Recursion: ");
                a3.printNonRec();
                System.out.println();
                System.out.println("Print Level Order");
                a3.printLevelOrder();
		System.out.println("\n");

			
		
		System.out.println("Test8---remove()-leaf" );
                System.out.println("element removed is "+remove_a2);
		a2.remove(remove_a2);
                System.out.println("Print In Recursion: ");
		a2.printRec();
                System.out.println("height is: "+a2.height());
                System.out.println("size is: "+a2.size());
                System.out.println("Print Non Recursion: ");
                a2.printNonRec();
                System.out.println();
                System.out.println("Print Level Order");
                a2.printLevelOrder();
		System.out.println("\n");
		
		System.out.println("Test9---remove()-leaf" );
                System.out.println("element removed is "+remove_a3);
		a3.remove(remove_a3);
                System.out.println("Print In Recursion: ");
		a3.printRec();
                System.out.println("height is: "+a3.height());
                System.out.println("size is: "+a3.size());
                System.out.println("Print Non Recursion: ");
                a3.printNonRec();
                System.out.println();
                System.out.println("Print Level Order");
                a3.printLevelOrder();
		System.out.println("\n");
		
		System.out.println("Test10---remove()-with one child" );
                System.out.println("element removed is "+remove_a3_2);
		a3.remove(remove_a3_2);
                System.out.println("Print In Recursion: ");
		a3.printRec();
                System.out.println("height is: "+a3.height());
                System.out.println("size is: "+a3.size());
                System.out.println("Print Non Recursion: ");
                a3.printNonRec();
                System.out.println();
                System.out.println("Print Level Order");
                a3.printLevelOrder();
		System.out.println("\n");
                
                System.out.println("Test11---remove root-with two children" );
                System.out.println("element removed is "+remove_a3_root);
		a3.remove(remove_a3_root);
                System.out.println("Print In Recursion: ");
		a3.printRec();
                System.out.println("height is: "+a3.height());
                System.out.println("size is: "+a3.size());
                System.out.println("Print Non Recursion: ");
                a3.printNonRec();
                System.out.println();
                System.out.println("Print Level Order");
                a3.printLevelOrder();
		System.out.println("\n");


    }
    
}