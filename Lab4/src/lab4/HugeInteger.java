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

import java.util.Random;

public class HugeInteger {
    private int[] digits;
    private int size;
    private Random randNum = new Random();
    private boolean negative;
    
    //creates a huge integer from the decimal string representation val
    public HugeInteger(String val) throws IndexOutOfBoundsException{
        int j = 1;
        //if there is element in the string
        if(val != null){
            //string contains optional minus sign
            if(val.charAt(0) == '-'){
                size = val.length() - 1;
                negative = true;
                digits = new int[size]; //array of number of digits
                for(int i=0; i<size; i++){
                    digits[i] = val.charAt(j) - '0';
                    j++;
                }
            }
            //if string does not have minus at beginning
            else{
                size = val.length();
                negative = false;
                digits = new int[size];
                for(int i=0; i<size; i++)
                    digits[i] = val.charAt(i) - '0'; 
            }
        }
        else
            throw new IndexOutOfBoundsException("String digits cannot equal null");
            
    }
 
    //creates a random huge integer of n digits
    public HugeInteger(int n) throws IndexOutOfBoundsException{
        if(n<1){
            throw new IndexOutOfBoundsException("n cannot be less than 1");
        }
        negative = false;
        size = n;
        digits = new int[size];
        for(int i=0; i<size; i++)
            digits[i] = randNum.nextInt(9-0 +1) + 0;
    }
    
    //creates huge integer
    public HugeInteger(int[] arr, boolean sign){
        size = arr.length;
        negative = sign;
        digits = new int[size];
        digits = arr;
    }
    
    //creates huge integer
    public HugeInteger(int cap, boolean sign)throws IndexOutOfBoundsException{
        if(cap<0){
            throw new IndexOutOfBoundsException("n cannot be less than 1");
        }
        size = cap;
        negative = sign;
        digits = new int[size];
    }
   
    //returns a high integer representing sum of this huge integer and h
    public HugeInteger add(HugeInteger h){
        int[] nul = new int[0]; //array of zeros
        HugeInteger Empty = new HugeInteger(nul,false); //Empty huge integer
        //if signs are true
        if(!negative && !h.negative){
            //check compareTo method, if equals 1, if this huge integer is greater than h
            if(compareTo(h) == 1){
                //temp array of size + 1
                int[] temp = new int[size+1];
                int j = temp.length-1;
                int k = size-1;
                //this for loop adds 1 digit at a time, i decrements
                for(int i = h.size-1; i >= 0; i--){
                    //temp array stores the added digits
                    temp[j] = digits[k] + h.digits[i];
                    j--; //j decrements
                    k--; //k decrements
                }
                //this for loop stores rest of digits in temp
                for(int i = k; i >= 0; i--){
                    temp[j] = digits[k];
                    j--;
                    k--;
                }
                //uses recreate method which basically adds array to array
                temp = reCreateAdd(temp);
                //new huge integer t is created
                HugeInteger t = new HugeInteger(temp,false);
                return t;
            }
            //case when compareTo method gives -1
            if(compareTo(h) == -1){
                int[] temp = new int[h.size+1];
                int j = temp.length-1;
                int k = h.size-1; 
                for(int i = size-1; i >= 0; i--){
                    temp[j] = digits[i] + h.digits[k];
                    j--;
                    k--;
                }
                for(int i = k; i >= 0; i--){
                    temp[j] = h.digits[k];
                    j--;
                    k--;
                }
                temp = reCreateAdd(temp);
                HugeInteger t = new HugeInteger(temp,false);
                return t;
            }
            
            //when compareTo gives 0
            if(compareTo(h) == 0){
                int[] temp = new int[size+1];
                int j = temp.length-1;
                for(int i = h.size-1; i >= 0; i--){
                    temp[j] = digits[i] + h.digits[i];
                    j--;
                }
                temp = reCreateAdd(temp);
                HugeInteger t = new HugeInteger(temp,false);
                return t;
            }            
        }
        if(!negative && h.negative){
            h.negative = false;
            return subtract(h);
        }
        if(negative && !h.negative){
            h.negative = true;
            return subtract(h);
        }
        if(negative && h.negative){
            if(compareTo(h) == 1){
                int[] temp = new int[h.size+1];
                int j = temp.length-1;
                int k = h.size-1; 
                for(int i = size-1; i >= 0; i--){
                    temp[j] = digits[i] + h.digits[k];
                    j--;
                    k--;
                }
                for(int i = k; i >= 0; i--){
                    temp[j] = h.digits[k];
                    j--;
                    k--;
                }
                temp = reCreateAdd(temp);
                HugeInteger t = new HugeInteger(temp,true);
                return t;
            }
            if(compareTo(h) == -1){
                int[] temp = new int[size+1];
                int j = temp.length-1;
                int k = size-1; 
                for(int i = h.size-1; i >= 0; i--){
                    temp[j] = digits[k] + h.digits[i];
                    j--;
                    k--;
                }
                for(int i = k; i >= 0; i--){
                    temp[j] = digits[k];
                    j--;
                    k--;
                }
                temp = reCreateAdd(temp);
                HugeInteger t = new HugeInteger(temp,true);
                return t;
            }
            if(compareTo(h) == 0){
                int[] temp = new int[size+1];
                int j = temp.length-1;
                for(int i = h.size-1; i >= 0; i--){
                    temp[j] = digits[i] + h.digits[i];
                    j--;
                }
                temp = reCreateAdd(temp);
                HugeInteger t = new HugeInteger(temp,true);
                return t;
            }            
        }
        return Empty;
    }
    
    public HugeInteger subtract(HugeInteger h){
        //create null array
        int[] nul = new int[0];
        //create huge integer of nothing
        HugeInteger Empty = new HugeInteger(nul,false);
        //check the signs
        if(!negative && !h.negative){
            //check compareTo
            if(compareTo(h) == 0){
                int[] temp = {0};
                HugeInteger t = new HugeInteger(temp,false);
                return t;
            }
            if(compareTo(h) == 1){
                int[] temp = new int[size];
                int j = temp.length-1;
                int k = size-1; 
                for(int i = h.size-1; i >= 0; i--){
                    temp[j] = digits[k] - h.digits[i];
                    j--;
                    k--;
                }
                for(int i = k; i >= 0; i--){
                    temp[j] = digits[k];
                    j--;
                    k--;
                }
                temp = reCreateSub(temp);
                HugeInteger t = new HugeInteger(temp,false);
                return t;
            }
            if(compareTo(h) == -1){
                int[] temp = new int[h.size];
                int j = temp.length-1;
                int k = h.size-1; 
                for(int i = size-1; i >= 0; i--){
                    temp[j] = h.digits[k] - digits[i];
                    j--;
                    k--;
                }
                for(int i = k; i >= 0; i--){
                    temp[j] = h.digits[k];
                    j--;
                    k--;
                }
                temp = reCreateSub(temp);
                HugeInteger t = new HugeInteger(temp,true);
                return t;
            }
                
        }
        if(!negative && h.negative){
            h.negative = false;
            return add(h);
        }
        if(negative && !h.negative){
            h.negative = true;
            return add(h);
        }
        if(negative && h.negative){
            negative = false;
            h.negative = false;
            if(compareTo(h) == 0){
                int[] temp = {0};
                HugeInteger t = new HugeInteger(temp,false);
                return t;
            }
            if(compareTo(h) == 1){
                int[] temp = new int[size];
                int j = temp.length-1;
                int k = size-1; 
                for(int i = h.size-1; i >= 0; i--){
                    temp[j] = digits[k] - h.digits[i];
                    j--;
                    k--;
                }
                for(int i = k; i >= 0; i--){
                    temp[j] = digits[k];
                    j--;
                    k--;
                }
                temp = reCreateSub(temp);
                HugeInteger t = new HugeInteger(temp,true);
                return t;
            }
            if(compareTo(h) == -1){
                int[] temp = new int[h.size];
                int j = temp.length-1;
                int k = h.size-1; 
                for(int i = size-1; i >= 0; i--){
                    temp[j] = h.digits[k] - digits[i];
                    j--;
                    k--;
                }
                for(int i = k; i >= 0; i--){
                    temp[j] = h.digits[k];
                    j--;
                    k--;
                }
                temp = reCreateSub(temp);
                HugeInteger t = new HugeInteger(temp,false);
                return t;
            }
        }
        return Empty;
    }
    
    public HugeInteger multiply(HugeInteger h){
        //create null array
        int[] nul = new int[0];
        //create huge integer
        HugeInteger Empty = new HugeInteger(nul,false);
        //if all the signs are same
        if((!negative && !h.negative) || (negative && h.negative)){
            //double checking the signs by compareTo
            if(compareTo(h) == 1 || compareTo(h) == 0){
                //huge interger of double the size
                HugeInteger prod = new HugeInteger(2*size,false);
                int s1 = h.size - 1;
                for(int i = 0; i < h.size; i++){
                    //temporary huge integer
                    HugeInteger temp = new HugeInteger(2*size,false);
                    int last = temp.size - 1;
                    int s2 = size - 1;
                    for(int j = 0; j < size; j++){
                        //multiplying both huge integers, 1 digit at a time
                        temp.digits[last - i] += h.digits[s1]*digits[s2];
                        s2--;
                        last--;
                    }
                    s1--;
                    temp.reCreateMult(temp.digits);
                    for(int k = 0; k< temp.size; k++){
                        prod.digits[k] += temp.digits[k];
                    }    
                }
                //return statements
                prod.reCreateMult(prod.digits);   
                prod.reSize();
                return prod;
            }
            //second case where size differ
            if(compareTo(h) == -1){
                HugeInteger prod = new HugeInteger(2*h.size,false);
                int s1 = size - 1;
                for(int i = 0; i < size; i++){
                    HugeInteger temp = new HugeInteger(2*h.size,false);
                    int last = temp.size - 1;
                    int s2 = h.size - 1;
                    for(int j = 0; j < h.size; j++){
                        
                        temp.digits[last - i] += digits[s1]*h.digits[s2];
                        s2--;
                        last--;
                    }
                    s1--;
                    temp.reCreateMult(temp.digits);
                    for(int k = 0; k< temp.size; k++)
                        prod.digits[k] += temp.digits[k];
                        
                }
                prod.reCreateMult(prod.digits);   
                prod.reSize();
                return prod;
            }
        }
        //now for different signs
        if((negative && !h.negative) || (!negative && h.negative)){
            if(compareTo(h) == 1 || compareTo(h) == 0){
                HugeInteger prod = new HugeInteger(2*size,true);
                int s1 = h.size - 1;
                for(int i = 0; i < h.size; i++){
                    HugeInteger temp = new HugeInteger(2*size,false);
                    int last = temp.size - 1;
                    int s2 = size - 1;
                    for(int j = 0; j < size; j++){
                        
                        temp.digits[last - i] += h.digits[s1]*digits[s2];
                        s2--;
                        last--;
                    }
                    s1--;
                    temp.reCreateMult(temp.digits);
                    for(int k = 0; k< temp.size; k++){
                        prod.digits[k] += temp.digits[k];
                    }    
                }
                prod.reCreateMult(prod.digits);   
                prod.reSize();
                return prod;
            }
            if(compareTo(h) == -1){
                HugeInteger prod = new HugeInteger(2*h.size,true);
                int s1 = size - 1;
                for(int i = 0; i < size; i++){
                    HugeInteger temp = new HugeInteger(2*h.size,false);
                    int last = temp.size - 1;
                    int s2 = h.size - 1;
                    for(int j = 0; j < h.size; j++){
                        
                        temp.digits[last - i] += digits[s1]*h.digits[s2];
                        s2--;
                        last--;
                    }
                    s1--;
                    temp.reCreateMult(temp.digits);
                    for(int k = 0; k< temp.size; k++){
                        prod.digits[k] += temp.digits[k];
                    }    
                }
                prod.reCreateMult(prod.digits);   
                prod.reSize();
                return prod;
            }
        }
        return Empty;
    }
    
    public int compareTo(HugeInteger h){
        if(!negative && h.negative)
            return 1;
        else if(negative && !h.negative)
            return -1;
        if(!negative && !h.negative){
            if(size > h.size)
                return 1;
            else if(size < h.size)
                return -1;
            if(size == h.size){
                int i1;
                int i2;
                for(int i = 0; i < size; i++){
                    i1 = digits[i];
                    i2 = h.digits[i];
                    if(i1 > i2)
                        return 1;
                    else if(i1 < i2)
                        return -1;
                }
            }
            return 0;
        }
        if(negative && h.negative){
            if(size < h.size)
                return 1;
            else if(size > h.size)
                return -1;
            if(size == h.size){
                int i1;
                int i2;
                for(int i = 0; i < size; i++){
                    i1 = digits[i];
                    i2 = h.digits[i];
                    if(i1 < i2) 
                        return 1;
                    else if(i1 > i2)
                        return -1;
                }
            }
            return 0;
        } 
        return 0;
}
    
   public String toString(){
        String longString = "";
        if(size == 0){
            longString = "No digits exist.";
        } 
        else{
            //check bool if negative
            if(negative){
                longString = longString + "-";
                for(int i = 0; i < size; i++){
                    longString = longString + digits[i];
                }
            }
            //if positive
            else{
                for(int i = 0; i < size; i++){
                    longString = longString + digits[i];
                }
            }
        }
        return longString;
    }
   
   public int[] reCreateAdd(int[] arr){
       int mod;
       int c;
       for(int i = arr.length-1; i >= 1; i--){
           mod = arr[i]%10;
           c = arr[i]/10;
           arr[i] = mod;
           arr[i-1] += c;      
       }
       
       int j = 0;
       while(arr[j] == 0)
           j++;
       int[] temp = new int[arr.length - j];
       int k = 0;
       for(int i = j; i < arr.length; i++){
           temp[k] = arr[i];
           k++;
       }     
       return temp;
   }
   
   public int[] reCreateSub(int[] arr){
       for(int i = 0; i < arr.length; i++){
           if(arr[i] < 0){
               if(arr[i-1] == 0){
                   int n = i-1;
                   while(arr[n-1] <=0){
                       arr[n] += 10;
                       arr[n-1]--;
                       n--;
                   }
                   arr[n-1]--;
                   arr[n] += 10;
               }
               arr[i-1]--;
               arr[i] += 10;
           }
       }
           
       int j = 0;
       while(arr[j] == 0)
           j++;
       int[] temp = new int[arr.length - j];
       int k = 0;
       for(int i2 = j; i2 < arr.length; i2++){
           temp[k] = arr[i2];
           k++;
       }     
       return temp;           
   }
   
   public void reCreateMult(int[] arr){
       int mod;
       int c;
       for(int i = arr.length-1; i >= 1; i--){
           mod = arr[i]%10;
           c = arr[i]/10;
           arr[i] = mod;
           arr[i-1] += c;        
       }
   }
   
   public void reSize(){
       int j = 0;
       while(digits[j] == 0)
           j++;
       int[] temp = new int[digits.length - j];
       int k = 0;
       for(int i = j; i < digits.length; i++){
           temp[k] = digits[i];
           k++;
       }
       digits = new int[temp.length];
       for(int i = 0; i < temp.length; i++){
           digits[i] += temp[i];
       }
       size += -j;
   }
    
}
