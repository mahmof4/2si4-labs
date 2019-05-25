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

public class MultiplyTest {
    public static void main(String[] args) {    
        HugeInteger n1, n2, n3;
            n2= new HugeInteger("9999");
            n3= new HugeInteger("9999");
            n1=n2.multiply(n3);
            System.out.println("Test multiply.1 - Multiply Method:\nTesting for both positive, same length\n"+n1.toString());       
            System.out.println("\n*************************************************************\n");

            n2= new HugeInteger("1234");
            n3= new HugeInteger("1234");
            n1=n2.multiply(n3);
            System.out.println("Test multiply.1 - Multiply Method:\nTesting for both positive, same length\n"+n1.toString());       
            System.out.println("\n*************************************************************\n");

            n2= new HugeInteger("5");
            n3= new HugeInteger("3414");
            n1=n2.multiply(n3);
            System.out.println("Test multiply.2 - Multiply Method:\nTesting for both positive, different lengths\n"+n1.toString());       
            System.out.println("\n*************************************************************\n");
            
            n2= new HugeInteger("1111111111111111111111111111111111111111111111111111111111111111111111");
            n3= new HugeInteger("1111111111111111111111111111111111111111111111111111111111111111111111");
            n3= new HugeInteger("70000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
            n1=n2.multiply(n3);
            System.out.println("Test multiply.3 - Multiply Method:\nTesting for both positive, different lengths\n"+n1.toString());       
            System.out.println("\n*************************************************************\n");
            
            n2= new HugeInteger("");
            n3= new HugeInteger("1231");
            n1=n2.multiply(n3);
            System.out.println("Test multiply.4 - Multiply Method:\nTesting for different mag, same lengths\n"+n1.toString());       
            System.out.println("\n*************************************************************\n");
            
            n2= new HugeInteger("9");
            n3= new HugeInteger("-5644");
            n1=n2.multiply(n3);
            System.out.println("Test multiply.5 - Multiply Method:\nTesting for different mag, different lengths\n"+n1.toString());       
            System.out.println("\n*************************************************************\n");   
    }
}
