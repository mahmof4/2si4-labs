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

public class AdditionTest {

    public static void main(String[] args) {    
        HugeInteger n1, n2, n3;
        n2= new HugeInteger("5884");
        n3= new HugeInteger("5885");
        n1=n2.add(n3);
        System.out.println("Test add.1 - Add Method:\nTesting for both positive\n"+n1.toString());       
        System.out.println("\n*************************************************************\n");
        
        n2= new HugeInteger("5884");
        n3= new HugeInteger("3885");
        n1=n2.add(n3);
        System.out.println("Test add.2 - Add Method:\nTesting for both positive\n"+n1.toString());       
        System.out.println("\n*************************************************************\n");
        
        n2= new HugeInteger("-1234");
        n3= new HugeInteger("-2324");
        n1=n2.add(n3);
        System.out.println("Test add.2 - Add Method:\nTesting for both positive\n"+n1.toString());       
        System.out.println("\n*************************************************************\n");
        
        n2= new HugeInteger("-5884");
        n3= new HugeInteger("-3885");
        n1=n2.add(n3);
        System.out.println("Test add.2 - Add Method:\nTesting for both positive\n"+n1.toString());       
        System.out.println("\n*************************************************************\n");

        n2= new HugeInteger("900000");
        n3= new HugeInteger("3885");
        n1=n2.add(n3);
        System.out.println("Test add.4 - Add Method:\nTesting for both positive, first array longer\n"+n1.toString());       
        System.out.println("\n*************************************************************\n");

        n2= new HugeInteger("9999999999999999999999999999999999999999999999999999999999999999999999");
        n3= new HugeInteger("111111111111111111111111111111111111111111111111111111111111111111111");
        n1=n2.add(n3);
        System.out.println("Test add.5 - Add Method:\nTesting for both positive, second array longer\n"+n1.toString());       
        System.out.println("\n*************************************************************\n");
        }
}
