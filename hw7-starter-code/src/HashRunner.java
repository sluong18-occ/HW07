/**
 * This program experiments with the String hashing function
 * and distributes 5757 5-letter words into 5749 buckets.
 * Stats are collected and displayed.
 * 
 * @author your name here
 * @version date here
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashRunner
{
   public static final int SIZE = 5749;
   public static void main(String[] args)
   {
      
      int[] x = new int[SIZE];
      
      try
      {
         File words = new File("sgb-words.txt");
         Scanner scan = new Scanner(words);
         int noWords = 0;
         while (scan.hasNext())
         {
            String word = scan.next();
            noWords = noWords + 1;
            int h = word.hashCode(); 
            if (h < 0) { h = -h; }
            h = h % SIZE;
            x[h] = x[h] + 1;
         }
         scan.close();
         
         int empties = 0;
         int nonEmpties = 0;
         int maxLength = 0;
         int totalChainLengths = 0;
         for (int i = 0; i < SIZE; i++)
         {
            if (x[i] == 0) 
            {
               empties = empties + 1;
            }
            else
            {
               nonEmpties = nonEmpties + 1;
               totalChainLengths = totalChainLengths + x[i];
            }
            if (x[i] > maxLength) { maxLength = x[i]; }
         }
         System.out.println("The number of empty buckets is " + empties);
         System.out.println("The longest chain in a bucket is " 
            + maxLength);
         System.out.println("The average length of a chain is " 
            + totalChainLengths /(double) nonEmpties);
            
      }
      catch (FileNotFoundException e)
      {
          System.out.println("File not found.");
      }
   }
}
