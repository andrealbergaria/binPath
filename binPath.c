#include "util.h"


void printFullArray() {
    // int a[3][4] = {  
//   {0, 1, 2, 3} ,   /*  initializers for row indexed by 0 */
//   {4, 5, 6, 7} ,   /*  initializers for row indexed by 1 */
 //  {8, 9, 10, 11}   /*  initializers for row indexed by 2 */
// };

/*
    temp[8][8] = 
    temp[0][8] = { b1,b2,b3,b4,b5,b6,b7 
                                        
    temp[1][8] = {0b0000 0b1000 0b1001 0b01010 0b
    unsigned char base[8][8];
 //   unsigned char firstArray[8]; // just here for clearing 
 //   unsigned char secondArray[8];                
    */               16               16          16
                            32/2          48 / 3     64/4          16            16            16                     
             1      2              3            4          5             6            7              8                    
     
      { { 0b0000,   0b0001      0b0010,      0b0011,     0b0100,      0b0101,      0b0110,      0b0111
                      16        32            48          64           80          96          112
        { 000000,  0b00010000 , 0b00100000 , 0b00110000, 0b01000000,  0b01010000 , 0b01100000, 0b01110000 }, (shift 4 left)
      
        // checkando nao mulitplos de 2 3
                8            9          10           11             12          13             14        15          
           0b00001000, 0b00001001, 0b00001010,  0b00001011,   0b00001100,    0b00001101,  0b00001110,0b00001111} 
              16          17          18           19           20            21           22             23                        
           00010000,   00010001    00010010     00010011      00010100        00010101     00010110    00010111
                 // 1linha , todas as posicções
              24        25          26              27          28              29          30          31
            11000       11001      11010         11011          11100          11101       11110      11111      
              32        33          34          35              36              37          38          39
            100000      100001      100010      100011          100100          100101     100110      100111 
                 
                                 pos 1 = 0,8,16 ,24,32 (todos multiplos de 2)
                                 
                                 pos 2 = 2,9,17,25,33   (nenhum multiplo de 2)
                                 
                                 pos 3 = 3,10,18,26,34 (todos multiplos de 2, sem contar com 3)
                                 
                                 pos 4 = 4,11,19,27,35  (so 4 multiplo de 2)
                                   
                                 pos 5 = 5,12,20,28,36  (multiplos de 2 sem 5)
                                 
                                 pos 6 = 6,13,21,29,37 (so 6 multiplo de 2)
                                
                                 pos 7 = 7,14,22,30,38  (todos multiplos de 2, meno 7)
    };
                f(0) = 
                    char toBeAdded = pos1[0] 
                    resultant_first_byte = ++toBeAdded;

                     toBeAdded  = pos1 << 16;       
                    
                    (pos1 = 00000000 00001000 00010000 00011000 0001000 100000)
                    (add =  00000001 00000001 00000001 00000001 0000001 000001)
                           add (137977929793 to pos1 or use mask)
                
                      for      
                              
                              ADD 1 ...
                              
                              
                f(pos) =  f(pos-1) + 13
    
                                        96 / 6 = 16 (pos 6 of multiple of 2?)
                                        80/5 = 16 (pos 5)
                                   
                                        
                                        
                                        multiple of 2 
                               2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112
                               
                          can avoid those on array
                           32 = 16+16
                           48 = 16+16+16
                           
                           shifting left 4 bits, equals multiplying by 16 (16 = 2^4)
                           00001000 8
                           10000000 128
                           
                           8*16 = 128
                           
                         left 3 bits multiplying by 8 (2^3 = 8)
                         00001000 8
                         01000000 64
                         
                    // FALSO       com bits seguidos, nao é multiplo de 2
                    //             com bits nao seguidos mulitple de 2
                           
                  add 1 bit leading 3 bits = > 4bits . How many bits 0 and 1's         
    // Add bit in msb
                           
              
              // relation betwee 10000000 256
              //and              00000001 1
              // relation between 0b10010000 
              // and              0b00000010
              
    for (char i2 = 0 ; i2 < 8 ; i2++) {
      
       char t2 = i2 << 4;
       char res = t2 | (int)base[i2]; 
       printBits(res);
       printf("\n");
       printf("\n");
       
       
    }
        
}   
    
    
    // copy base to int and then do OR with first set and then increment first set
    
   /* 000 000 000
    000 000 001
    000 000 010
    000 000 100
    000 000 110
    000 000 101
    000 000 011
    000 000 111 
    
    total combinations = 2^9 = 512
    
    
    000 000 000
    001 001 001
    010 010 010
    100 100 100
    110 110 110
    011 011 011
    101 101 101
    111 111 111 
    
    
    000 000
    000 001
    000 010
    000 100
    000 111
    000 101
    000 110
    000 011
    
    pos1 pos2 pos3
    1     1    1 -> representa 3 numeros, um por cada bit
                                                ----4posicioes---
    1 at pos1 (represents 1 0 0 , 8 positions { 001,010,000,100, 011,101,110,111
    
    1 at pos2 (represents 1 0 , 4positions {01,10,00,11})
    
    8 positions has 4positions plus other
    
    2bit * 2bit * 2bit => 2bit * 2bit AND adding one and zeros on the leading bits
    
    2bit * 2bit * 2bit * 2bit => { 0001,0010,0100,0000,1000,1100,1110,1111,0011,0111,
  
}
*/


   
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



int main() {
    //algorithm = start wth 000, and change one bit, until can't change nomre...then use 111 and change one bit of it
            /* algorithm       
      a)  [0] Bit bit Bit [0] bit bit bits 
             
      b)  [0] bit bit bit [1] bit bit bits 
               
      c)  [1] bit bit bit [0] bit bit bit 
             
      d)  [1] bit bit bit [1] bit bit bit 
      
      000 000                   000 000
      001 000    (8)            0
      010 000    (8*2)
      100 000    (8*3)      multiple of 2
      111 000    (8*7)
      011 000 
      101 000
      110 000
      
      000 001  (1)
      001 001   (9)
      010 001   (17)
      011 001   (25)    
      100 001   (33) 
      101 001   (41)
      110 001   (49)
      111 001   (57)
      
      000 010   (2)
      001 010   (10)
      010 010   (18)        multiple of 2
      100 010   (34)
      011 010   (26)
      101 010   42
      110 010   50
      111 010   58
      
      
      000 100   4       
      001 100   12
      010 100   20
      100 100   36          if last set first line is multiple of 2, then combinations are multiple of 2
      110 100   52          multiple of 2, so second set is 000,001,100
      101 100   44
      011 100   28
      111 100   60
      
      000 011   3
      001 011   13
      010 101   21
      100 101
      110 101
      011 101
      101 101
      111 101
      
      
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

    //printFullArray();
    // number of bits 1st
    // startbyte    2nd
    //printAllCombinations(8,10);
   printStrings();
}

