#include <stdio.h>
#include "util.h"
#include <math.h>
int main() {
            /* algorithm       
      a)  [0] Bit bit Bit [0] bit bit bits 
             
      b)  [0] bit bit bit [1] bit bit bits 
               
      c)  [1] bit bit bit [0] bit bit bit 
             
      d)  [1] bit bit bit [1] bit bit bit 
      algorithm = start wth 000, and change one bit, until can't change nomre...then use 111 and change one bit of it
             A                 A                
      a) [0] bit bit bit [0] bit bit bit [0] bit bit bit [0] bit bit bit algortuihm funciona ..so preciso concatenar
           
           2^4 , 2^3 * 2^3 * 2^3 * 2^3 = 65536
           
           testing 4 bytes....
           
           32bytes / 4 bytes = 8
           
           concatenating
                    B
    (a)    0 0 0    0 0 0   { 000 000 , 000 001, 000 010 
    (a+1)  0 0 1    0 0 1   o anterior (0 0 1) de B (0 1 0 ) é igual 1pos 
    (a+2)  0 1 0    0 1 0   { A(000) B, A+1 B, A+2 B , A+3 B, A+4 B, A+5 B,A+6 B, A+7 B}
           1 0 0    1 0 0   {B(000) A(000) , B+1 A, B+2 A , B+3 A , ...}
           1 1 1    1 1 1   { A B+1, 
           1 1 0    1 1 0
           1 0 1    1 0 1    B+1 esta em que posicçoes
           0 1 1    0 1 1   { B+1 A, B+1 A+1, B+1 A+2, B+1 A+3, B+1 A+4,B+1 A+5,B+1 A+6,B A+7
                            { B+2 A, B+2 A+1 , ...}
                            B+1 
                            { A , A+1 , A+2, A+3...} positon 0 of array is always B+1
                            B+2
                            { A , A+1, A+2, A+3....} positiion 0 of array is always B+2
                            B=0, A=0
                            
                            char temp[8][9];
                            char temp[0][8] = B;
                            for (int i= 1 ; i < 8; i++) {
                                temp[i][i-1] = { A , A+1, A+2, A+3...}
                            }
                            
                            
                            
                            
           
       32 bits => 2^4 = 16
       256 bits =  128 comb of 0 and 1 (prefixes)
       256 / 8 bits = 32bytes
       32bytes -> 1byte
       1 -> x
            

            1byte -> 2A
            32bytes-> X
            
            1 concat
            A A 
            1 concat
            B B
            (adds AA AND BB from before)
            2 concat
            A A A A 
            2 concat
            B B B B
            
            a) 2 concat    2 iterations (2^1)
            A A B B     
            2 concat
            B B A A 
            
            3concat     use before and add 4 numbers 
            b)
            AA BB AA 2^2
            AA BB BB
            
            BB AA AA
            BB AA BB
            
            2^3
            2^...
            2^32
            
            
            
            
            AA BB BB AA
            AA BB BB BB
            
            
            00 AA 
            
*/            
            char symA[] = "0 0\n0 1\n0 2\n0 3\n0 4\n0 5\n0 6\n0 7\n";
            char symB[] = "1 0\n1 1\n1 2\n1 3\n1 4\n1 5\n1 6\n1 7\n";
                          
                            
            /*2^32
            AA
            BB
            //                 
            printf("\n");
            //first iterations
            AA AA
            AA BB 
            
            BB BB 
            BB AA
            */
          //  for (int idx1=0;  idx1 < 2^32 ;  idx1++) {
           //     printf("%s %s \n",symA,symA);
           //     printf("%s %s \n",symB,symB);  
                
            //}
                
            for (int i= 0;i < pow(2,32) ; i++) {
                printf("\n%i",i);
            }
                 
        
}

