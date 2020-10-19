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
           
           2A's * 4 = 8 A'S
           
           2^4 , 2^3 * 2^3 * 2^3 * 2^3 = 65536
           
           testing 4 bytes....
           
           32bytes / 4 bytes = 8
                           
                            preciso 24 three bits
                            
                          
                            
                            A    B
                            000 000
                            000 001
                            000 010 
                          
                            A=B
                            
                            Para 3 bits
                            A
                            A+1
                            A+2
                            A+3
                            A+4
                            A+5
                            A+6
                            A+7
                            
                            Para 6 bits
                            A   "A A+1 A+2 A+3 A+4 A+5 A+6 A+7"
                            A+1 "A A+1 A+2 A+3 A+4 A+5 A+6 A+7"
                            A+2 "A A+1 A+2 A+3 A+4 A+5 A+6 A+7"
                            A+3 "A A+1...."
                            A+4 "A A+1 ..."
                            A+5 " A A+1..."
                            A+6 "A A+1;
                            
                            ou para mais coerencie supondo que A e B represtam 3bits
                            A "B B+1 B+2 B+3 B+4 B+5 B+6 B+7"
                            A= B entao basta subtituir
                            
                            8^3 => 512 (A*A*A) (being A=3bits)
                            9bits=> 512 ones and zeros
                            
                            Para 9 bits
                            A   "A A+1 A+2 A+3 A+4 A+5 A+6 A+7" "A A+1 A+2 A+3 A+4 A+5 A+6 A+7"
                            A+1 "A A+1 A+2 A+3 A+4 A+5 A+6 A+7"
                            A+2 "A A+1 A+2 A+3 A+4 A+5 A+6 A+7"
                            A+3 "A A+1...."
                            A+4 "A A+1 ..."
                            A+5 " A A+1..."
                            A+6 "A A+1;
                            
                            char str[] = {0b000,0b001,0b010,0b100,0b101,0b110,0b011,0b111,'\0'};
                            char *src = str;
                            char *dest = (char* ) malloc(10000);
                            
                            // prottpye 
                            // prtotype (char *dest, const char *src);
                            // char *strncat(char *dest, const char *src, size_t n);

                            dest[10000] = '\0';
                            
                            strncat(dest,src,9);
                            //The strcat function returns a pointer to s1 (dest) (where the resulting concatenated string resides).
                            24 bits / 3 bits = 8 cycles
                            
                            for (int idx= 0; idx < 8; idx++) {
                                dest = strncat(dest,dest,9);
                                printf("\n%s",dest);
                                
                            }
                            
                                            
                            
                         
                            
       32 bits => 2^4 = 16
       256 bits =  128 comb of 0 and 1 (prefixes)
       256 / 8 bits = 32bytes
       32bytes -> 1byte
       1 -> x */
       
            
       char src[] = {0b000,0b001,0b010,0b100,0b101,0b110,0b011,0b111,'\0'};
                            char *dest = (char* ) malloc(10000);
                            
                            // prottpye 
                            // prtotype (char *dest, const char *src);
                            // char *strncat(char *dest, const char *src, size_t n);

                            dest[10000] = '\0';
                            
                            strncat(dest,src,9);
                            //The strcat function returns a pointer to s1 (dest) (where the resulting concatenated string resides).
                           // 24 bits / 3 bits = 8 cycles
                            
                            for (int idx= 0; idx < 8; idx++) {
                                dest = strncat(dest,dest,9);
                                printf("\n%s",dest);
                                
                            }
                 
        
}

