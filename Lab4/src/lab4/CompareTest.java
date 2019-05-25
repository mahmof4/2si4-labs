/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author Fahad
 */

public class CompareTest {
    public static void main(String[] args) { 
        HugeInteger n1, n2, n3;
        int n=12;
        n2= new HugeInteger("812363215");
        n3= new HugeInteger("912345678");
        n=n2.compareTo(n3);
        System.out.println("Test compare.1 - Sub Method:\nTesting for both positive, same length, positive result\n"+n);       
        System.out.println("\n*************************************************************\n"); 
        
        n2= new HugeInteger("900");
        n3= new HugeInteger("800");
        n=n2.compareTo(n3);
        System.out.println("Test compare.2 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");         

        n2= new HugeInteger("9000");
        n3= new HugeInteger("800");
        n=n2.compareTo(n3);
        System.out.println("Test compare.3 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");         
    
        n2= new HugeInteger("900");
        n3= new HugeInteger("8000");
        n=n2.compareTo(n3);
        System.out.println("Test compare.4 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");         

        n2= new HugeInteger("-900");
        n3= new HugeInteger("-800");
        n=n2.compareTo(n3);
        System.out.println("Test compare.5 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");         
    
        n2= new HugeInteger("-12345");
        n3= new HugeInteger("-523454");
        n=n2.compareTo(n3);
        System.out.println("Test compare.6 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");         
    
        n2= new HugeInteger("-12313123");
        n3= new HugeInteger("-1313213");
        n=n2.compareTo(n3);
        System.out.println("Test compare.7 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");         
    
        n2= new HugeInteger("900");
        n3= new HugeInteger("-800");
        n=n2.compareTo(n3);
        System.out.println("Test compare.8 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");         

        n2= new HugeInteger("-900");
        n3= new HugeInteger("800");
        n=n2.compareTo(n3);
        System.out.println("Test compare.9 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");         
   
        n2= new HugeInteger("900");
        n3= new HugeInteger("-800");
        n=n2.compareTo(n3);
        System.out.println("Test compare.10 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");         

        n2= new HugeInteger("900");
        n3= new HugeInteger("900");
        n=n2.compareTo(n3);
        System.out.println("Test compare.11 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");

        n2= new HugeInteger("-988");
        n3= new HugeInteger("-988");
        n=n2.compareTo(n3);
        System.out.println("Test compare.11 - Sub Method:\nTesting for both positive, same length, negative result\n"+n);       
        System.out.println("\n*************************************************************\n");
    }
}
