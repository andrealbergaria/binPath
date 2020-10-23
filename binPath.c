#include <stdio.h>
#include "util.h"
#include <string.h>
#include <stdlib.h>


void printFullArray() {
    
    char base[] = {0b000,0b001,0b010,0b100,0b110,0b111,0b101,0b001};
    char temp[8]= {0b000,0b001,0b010,0b100,0b110,0b111,0b101,0b001};
    unsigned int v[8][1];
    char *tempVar = (char *) malloc(500);
    tempVar = base;
    
    
    
    
    
   /* v[0][0] = base[0]; // 0
    v[0][1] = base[1]; // 2    
    v[0][2] = base[2]; // 4
    v[0][3] = base[3]  // 8
    
 
    var = [elems] | base[]
    
    var = ELeems | 000
    var = ELeems | 001
    var = ELeems | 002
    var = ELeems | 003
    
    var = 0 | 000 
    var = 0  | 001 
    var = 0 | 010
       v[it] = 0,1
    var = 1 | 00  // so precisa mudar 1 elemento da array
    */
   v[0][0] =  
    for (int it=0; it < 8 ; it++) {
        //temp[it] = temp[] base[] 
        
        v[it]++;
        v[it][it]   &base;
        /*temp[it][it]++;
        temp[it][it] = *tempVar;
        *tempVar++;*/
        }
    }
}

void print_6_bits() {
           
     char b[8][8];
     char c[8][8];
     char a[8][8];
     
     for (int set=0 ; set < 8 ; set++) {
        a[set][0] = set;
        b[set][0] = set;    // fill the last element array with the algorithm
        c[set][0] = set;
    //    printf("a[%i] -> ",set);
        
     //   printBits(a[set][0]);
     //  printf("\n");
     //   printf("b[%i] -> ",set);
        
      //  printBits(b[set][0]);
      //  printf("\n");
      //  printf("c[%i] -> ",set);
        
      //  printBits(c[set][0]);
       // printf("\n");
     }
     //printf("\nFilled array ...\n");
     
     printf("\n\nEntering cycles\n");
     
     for (int s= 0 ; s < 8; s++) {
            b[s][s]++;
            c[s][s] = b[s][s]++;
            
            printf("a[%i][0] -> ",s);
            printBits(a[s][0]);
            printf("\n");
            printf("b[%i][0] -> ",s);
            printBits(b[s][0]);
            printf("\n");
            printf("c[%i][0] -> ",s);
            printBits(c[s][0]);
            printf("\n");
            a[s][0]++;
            
            
            
     }
     
     
}


void printStrings() {
     
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
                        
                        
                            printf("\n\n\n");
                        
}

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
        
        
  a[0][0] 000 000         
  a[1][1] 000 001            
  a[2][2] 000 010         
  a[3][3] 000 100      X ->  last array doesnt change
                        it = 0 
  a[4][4] 000 111       a[1][1] = b[1][1] = c[1][1]
                        a[3][3] = b[4][3] = c[3][3] 
                        000 100   
  a[5][5] 000 110       a[5][5] =  b [5] [B]  = c[5][c5] 
  a[6][6] 000 101       000 110   001 110           010 110
  a[7][7] 000 011
                        a[5][5] = 000 110
  b[0][0] 001 000       b[5][5] = 001 110
  b[1][1] 001 001       //using set
  b[2][2] 001 010
  b[3][3] 001 100       b[5][5] = 
  b[4][4] 001 111
  b[5][5] 001 110
  b[6][6] 001 101
  b[7][7] 001 011
    
  c[0][0] 010 000  
  c[1][1] 010 001
  c[2][2] 010 010  
  c[3][3] 010 100
  c[4][4] 010 111
  c[5][5] 010 110
  c[6][6] 010 010
  c[7][7] 010 100
  
     
      a) [0] bit bit bit [0] bit bit bit [0] bit bit bit [0] bit bit bit
           
           2^4 , 2^3 * 2^3 * 2^3 * 2^3 = 65536
           
           2^3 ^4 = 
           8 ^4 = 4096 bits (4096 combinações)
           
           testing 4 bytes....
           
           32bytes / 4 bytes = 8
           
           1 byte = 8bits
           X       11bits
           11 / 8 = 
           
                           
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
       
       */                   

     print_6_bits();
        
}

