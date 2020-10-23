#include <stdio.h>
#include "util.h"
#include <string.h>
#include <stdlib.h>
int main() {
    //algorithm = start wth 000, and change one bit, until can't change nomre...then use 111 and change one bit of it
            /* algorithm       
      a)  [0] Bit bit Bit [0] bit bit bits 
             
      b)  [0] bit bit bit [1] bit bit bits 
               
      c)  [1] bit bit bit [0] bit bit bit 
             
      d)  [1] bit bit bit [1] bit bit bit 
        usar ponteiros para ser maiis rapido adicionar a+1 a+2 b+1 b+2..
        char *a  = 0;
        a[0][0] = 0
        char a[1];
        char *ptr = &a[0];
        
        
  a[0][0] 000 000           a[0][0] = 000 
  a[1][0] 000 001
  a[2][0] 000 010         
  a[3][0] 000 100         
  a[4][0] 000 111
  a[5][0] 000 110
  a[6][0] 000 101
  a[7][0] 000 011
     
  b[0][0] 000 000
  b[1][0] 001 000  b[0][0]  = a[0][0];
  b[2][0] 001 001
  b[3][0] 001 010          b[2][0] = a[2][0] = 010,010,010
  b[4][0] 001 100          b[3][0] = a[3][0] = 100,100,100
  b[5][0] 001 111
  b[6][0] 001 110
  b[7][0] 001 101
  b[8][0] 001 011
    
  c[0] 010 000  
  c[1] 010 001
  c[2] 010 010  
  c[3] 010 100
  c[4] 010 111
  c[5] 010 110
  c[6] 010 010
  c[7] 010 100
  
  a[0][0] = b[0][0] = c[0][0]
  a[2][0] = b[2][0] = c[2][0];
  
  sencond emelemtn always 000,001,010,100,111,110,101,011
  
  a[1][0] = 000
  b[1][0] = 
  
     char a[8][8];
     char b[8][8];
     char c[8][8];
     a[0][0] = 0;
     
     for (int set=0 ; set < 8 ; set++) {
        a[set][0] = set;
        b[set][0] = set;    // fill the last element array with the algorithm
        c[set][0] = set;
     }
     for (int s= 0 ; s < 8; s++) {
            b[s][0] = a[s][0];
            c[s][0] = b[s][0];
            a[s][0]++;
     }
     
 
     
      a) [0] bit bit bit [0] bit bit bit [0] bit bit bit [0] bit bit bit
           
           2^4 , 2^3 * 2^3 * 2^3 * 2^3 = 65536
           
           2^3 ^4 = 
           8 ^4 = 4096 bits (4096 combinações)
           
           testing 4 bytes....
           
           32bytes / 4 bytes = 8
           
           1 byte = 8bits
           X       11bits
           11 / 8 = 
           
                            A    B   C   D
                            000 000 000 000
                            001 001 001 001
                            010 010 010 010
                            100 100 100 100
                            111 111 111 111
                            110 110 110 110
                            101 101 101 101
                            011 011 011 011
                          
                            trying algorithm with 3 letters
                            
                               000 000 000 000  => 000
                               000 000 000 001  => 001
                               000 000 000 010  => 010
                               000 000 000 100  => 100
                                                   111
                                                   110
                                                   101
                                                   011
                                                   
                            
                                                   
                                    
                            
                            
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
       
            
       char src[] = "[0] 0 1 2 3 4 5 6 7";
                            char *dest = (char* ) malloc(10000);
                            
                            // prottpye 
                            // prtotype (char *dest, const char *src);
                            // char *strncat(char *dest, const char *src, size_t n);

                            dest[10000] = '\0';
                            
                            strncat(dest,src,16);
                            
                            //The strcat function returns a pointer to s1 (dest) (where the resulting concatenated string resides).
                           // 24 bits / 3 bits = 8 cycles
                            
                            for (int idx= 0; idx < 8; idx++) {
                                strncat(dest,src,21);
                                printf(" %s ",dest);
                            }
                 
        
}

