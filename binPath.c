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
       256 / 8 bits = 32bytes
       1 byte -> 4 combs
       32 bytes -> X
       X= 128
       
            
*/
            
            char symA[] = "0 0\n0 1\n0 2\n0 3\n0 4\n0 5\n0 6\n0 7\n";
            char symB[] = "1 0\n1 1\n1 2\n1 3\n1 4\n1 5\n1 6\n1 7\n";
                          
                            
            
                            "
            char bits[] = {'\n','0','\n','1','\n','2','\n','3','\n','4','\n','5','\n','6','\n','7','\0'};
            printf("\n");
            for (int idx1=0;  idx1 < 32 ;  idx1++) {
                printf("%s %s %s %s %s %s %s %s\n",symA,symA,symA,symA,symA,symA,symA,symA);
                
                
            }
                
            
                 
        
}

