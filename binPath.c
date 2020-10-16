#include <stdio.h>
#include "util.h"
int main() {
            /* algorithm       algorithm
      a)  [0] Bit bit Bit [0] bit bit bits (64 2^6); (2nd igual ao 1)
             
      b)  [0] bit bit bit [1] bit bit bits
             
      c)  [1] bit bit bit [0] bit bit bit
             
      d)  [1] bit bit bit [1] bit bit bit (2nd igual ao primeiro)
      algorithm = start wth 000, and change one bit, until can't change nomre...then use 111 and change one bit of it
      
      a) [0] bit bit bit [0] bit bit bit [0] bit bit bit [0] bit bit bit algortuihm funciona ..so preciso concatenar
           
       32 bits => 2^4 = 16
       256 bits =  128 comb of 0 and 1 (prefixes)
       
       0 and 1..keep summing on cycle
            
*/
            
            char prefix[128];
            
            for (int idx1=0;  idx1 < 64 ;  idx1++) {
                prefix[idx1]=0;
                printBits(prefix[idx1]);
                 prefix[idx1]=1;
                 printBits(prefix[idx1]);
                     
                 }
                 
            
            
 
    char *ptr_1_ = 
     int alg[] = {0,1,2,3,4,5,6,7};
     int *alg2 = alg;
     int *ptr = alg;
     char prefix =0 ;
     printf("\n");
            for (int idx=0 ; idx < 4 ; idx++) {
                printf("%i ",prefix);
                
            }
            
      for (int idx=0 ; idx < 4 ; idx++) {
          three_bits[0]
      }
       
}

