
// Java program to compute  
// sum of digits in number. 
import java.io.*; 
  
class GFG { 
      
    /* Function to get sum of digits */
    static int getSum(int n) 
    {     
        int sum = 0; 
          
        while (n != 0) 
        { 
            sum = sum + n % 10; 
            n = n/10; 
        } 
      
    return sum; 
    } 
  
    // Driver program 
    public static void main(String[] args) 
    { 
        int n = 687; 
  
        System.out.println(getSum(n)); 
    } 
}
/**
 * This method is used to sort a given array using radix sort algorithm
 *
 * @param input
 * @return sorted array
 * 
 * @author Firas Bou Karroum <firas.boukarroum@gmail.com>
 */
public class NumberDigits {

    public static void main(String[] args) {

        int count = 0, num = 3452;

        while(num != 0)
        {
            // num = num/10
            num /= 10;
            ++count;
        }

        System.out.println("Number of digits: " + count);
    }
}