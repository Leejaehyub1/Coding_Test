package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2464{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      long A = Long.parseLong(br.readLine());
      long temp = A;
      int x = 0;
      String binary = "";
      
      while(A>0) {
         binary = A%2 + binary;
         x += A%2;
         A /= 2;
      }
      binary = "0" + binary;
        
      char[] small = binary.toCharArray();
      char[] big = binary.toCharArray();
      
      
      int count = 0;
      for(int i=small.length-1; i>0; i--) {
         if(small[i] == '1') count++;
         
         if(small[i] == '0' && small[i-1] == '1') {
            small[i-1] = '0';
            small[i] = '1';
            
            for(int j= i + 1; j<small.length; j++) {
               if(count > 0) 
                  small[j] = '1';
               else
                  small[j] = '0';
               count--;
            }
            break;
         }
      }
           
      long smNum = func(small);
      
      count = 0;
      
      for(int i=big.length-1; i>0; i--) {
         if(big[i] == '0') count++;
         
         if(big[i] == '1' && big[i-1] == '0') {
            big[i-1] = '1';
            big[i] = '0';
            
            for(int j= i + 1; j<big.length; j++) {
               if(count > 0) 
                  big[j] = '0';
               else
                  big[j] = '1';
               count--;
            }
            break;
         }
      }
      
      long biNum = func(big);
      if(smNum == temp) smNum = 0;
      
      System.out.println(smNum + " " + biNum);
      br.close();
   }

   private static long func(char[] binary) {
      long num = 0;
      
      for(char c : binary) {
         num *= 2;
         if(c=='1')
            num += 1;
      }
      
      return num;
   }
}   