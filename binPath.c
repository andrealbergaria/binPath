#include "util.h"


void printFullArray() {
    // int a[3][4] = {  
//   {0, 1, 2, 3} ,   /*  initializers for row indexed by 0 */
//   {4, 5, 6, 7} ,   /*  initializers for row indexed by 1 */
 //  {8, 9, 10, 11}   /*  initializers for row indexed by 2 */
// };

/*
    unsigned char base[8][8];
 //   unsigned char firstArray[8]; // just here for clearing 
 //   unsigned char secondArray[8];                
    */   
    /*
     * 
     * 
     * Positions          1             2               3           4           5       6           7           8
       bitStrings 1)   00000001      00000010       00000011   00000100     00000101 00000110  00000111     00001000
       2)                8+1            8+2             8+3          8+4         8+5     8+6    8+7         8+8
     *                 00001001      00001010       00001011   00001100     00001101 00001101  0000111      00010000
       3)               
     
    
     One 2), use 8 in 1), as a mask to 2)
     
     
     
                                pos 1 = 0,8,16 ,24,32 (todos multiplos de 2)
                                 
                                 pos 2 = 2,9,17,25,33   (nenhum multiplo de 2)
                                 
                                 pos 3 = 3,10,18,26,34 (todos multiplos de 2, sem contar com 3)
                                 
                                 pos 4 = 4,11,19,27,35  (so 4 multiplo de 2)
                                   
                                 pos 5 = 5,12,20,28,36  (multiplos de 2 sem 5)
                                 
                                 pos 6 = 6,13,21,29,37 (so 6 multiplo de 2)
                                
                                 pos 7 = 7,14,22,30,38  (todos multiplos de 2, meno 7)


                         
                    
                    (pos1 = 00000000 00001000 00010000 00011000 0001000 100000)
                    (add =  00000001 00000001 00000001 00000001 0000001 000001)
                     add (137977929793 to pos1 or use or mask on 1)
                              
                */
                   // int pos1 = 00000000 00001000 00010000 00011000;
                      //      OR 00000001 00000001 00000001 00000001     
                            
                            
                    int pos1_without_spaces = 0b00000000000010000001000000011000;
                         //   OR 00000001 00000001 00000001 00000001 
                            
                    // FROM https://stackoverflow.com/questions/7787423/c-get-nth-byte-of-integer
                    //int x = (number >> (8*n)) & 0xff;
                    // where n is 0 for the first byte, 1 for the second byte, etc.

                     // Access nth byte same site      int x = ((unsigned char *)(&number))[n];
                     
                  int mask =   0b00000001     /
                               00000001    /
                               00000001     /
                               00000001;
                  
                  int pos2 = pos1 | mask;
                  printf("\n");
                  printIntBits(pos2);
                  printf("\n");
               /    
                                        
                /*                        multiple of 2 
                               2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112
                             
                           
                           shifting left 4 bits, equals multiplying by 16 (16 = 2^4)
                           00001000 8
                           10000000 128
                           
                           8*16 = 128
                           
                         left 3 bits multiplying by 8 (2^3 = 8)
                         00001000 8
                         01000000 64
                         
                    // FALSO       com bits seguidos, nao é multiplo de 2
                    //             com bits nao seguidos mulitple de 2
                           
            //      add 1 bit leading 3 bits = > 4bits . How many bits 0 and 1's         
    // Add bit in msb
                  */         
              
}   
    
    
    // copy base to int and then do OR with first set and then increment first set
    
   /*
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


   


int main() {
    //algorithm = start wth 000, and change one bit, until can't change nomre...then use 111 and change one bit of it
            /* algorithm       
      a)  [0] Bit bit Bit [0] bit bit bits 
             
      b)  [0] bit bit bit [1] bit bit bits 
               
      c)  [1] bit bit bit [0] bit bit bit 
             
      d)  [1] bit bit bit [1] bit bit bit 
      
      
     
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
 //  printStrings();
}

