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

public class SubtractionTest {

    public static void main(String[] args) {    
        HugeInteger n1, n2, n3;
        n2= new HugeInteger("1000");
        n3= new HugeInteger("9");
        n1=n2.subtract(n3);
        System.out.println("Test sub.1 - Sub Method:\nTesting for both positive, same length, positive result\n"+n1.toString());       
        System.out.println("\n*************************************************************\n"); 
        
        n3= new HugeInteger("812363215");
        n2= new HugeInteger("912345678");
        n1=n2.subtract(n3);
        System.out.println("Test sub.1 - Sub Method:\nTesting for both positive, same length, positive result\n"+n1.toString());       
        System.out.println("\n*************************************************************\n"); 
        
        n2= new HugeInteger("812363215");
        n3= new HugeInteger("-912345678");
        n1=n2.subtract(n3);
        System.out.println("Test sub.1 - Sub Method:\nTesting for both positive, same length, positive result\n"+n1.toString());       
        System.out.println("\n*************************************************************\n"); 
        
        n2= new HugeInteger("-812363215");
        n3= new HugeInteger("912345678");
        n1=n2.subtract(n3);
        System.out.println("Test sub.1 - Sub Method:\nTesting for both positive, same length, positive result\n"+n1.toString());       
        System.out.println("\n*************************************************************\n"); 
        
        n2= new HugeInteger("-812363215");
        n3= new HugeInteger("-912345678");
        n1=n2.subtract(n3);
        System.out.println("Test sub.1 - Sub Method:\nTesting for both positive, same length, positive result\n"+n1.toString());       
        System.out.println("\n*************************************************************\n"); 
        
        n2= new HugeInteger("812363215");
        n3= new HugeInteger("45678");
        n1=n2.subtract(n3);
        System.out.println("Test sub.1 - Sub Method:\nTesting for both positive, same length, positive result\n"+n1.toString());       
        System.out.println("\n*************************************************************\n"); 
        
        n2= new HugeInteger("63215");
        n3= new HugeInteger("912345678");
        n1=n2.subtract(n3);
        System.out.println("Test sub.1 - Sub Method:\nTesting for both positive, same length, positive result\n"+n1.toString());       
        System.out.println("\n*************************************************************\n"); 
        
    }
}
