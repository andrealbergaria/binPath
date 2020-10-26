#include "util.h"

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

char check32Bytes() {
    // 256 bits , em bytes são 32
   // 32 bytes / 4 bytes (size of int) = 8
     // int a[3][4] = {  
//   {0, 1, 2, 3} ,   /*  initializers for row indexed by 0 */
//   {4, 5, 6, 7} ,   /*  initializers for row indexed by 1 */
 //  {8, 9, 10, 11}   /*  initializers for row indexed by 2 */
// };

//64 bits * X  = 256 .. X = 4
   
     
     /*
     * 64 bits
     * bytes  = 64 / 8 = 8 bytes
     * 
     * Positions          1             2               3           4           5       6           7           8
     * Values             0             1               2           3           4       5           6           7
       bitStrings 1)   00000000      00000001       00000010    000000100    00000101 00000110  00000111     00001000 (64bits)
       
       2) Values         8+1           8+2             8+3          8+4         8+5     8+6    8+7         8+8
     *                 00001001      00001010       00001011   00001100     00001101 00001101  0000111      00010000

       3) Values        8+8+1          8+8+2       8+8+3       8+8+4          8+8+5    8+8+6   8+8+7       8+8+8
                       000100001    000010010       00010011   00010100     00010101  00010110 00010111     00011000
     
       9) Values        8*8+1
                        
     f(pos) = 8k+pos
     
     how many to add ? 64
                        probably +1 beacuse of positions
                        and the other?? 8 ?
                        
                        
                        adicionar 8*8 a tabela anterior
                        
                        65 = 8*8+1 (pos 1)
                        
                        66 = 8*8+2 (pos 2)
                        
                        67 = 8*8+3 (pos 3)
                        
                        68 = 8*8 +4 (pos 4)
                        
                        69 = 8*8 +5 (pos 5)
                        
                        70 = 8*8 +6 (pos 6)
                        
                        71 = 8*8 +7 (ops 7)
                        
                        72 = 8*8 +8 (pos 8)
                        
                        anterior mais 1
                        
                        73 = 8*8 + 9
                        
                        8+1         8+2
                        00001001 00001010 
                        
                        8*8+8    8*8+9
                        1001000 
                        
                { 1,8*8}  =
     
                2*2*2 *2*2*2 *2*2
                  8     8     4
     
                      Falta o prefixo de 1          
                        
                       
                    
                    
                    
                    
     64*8 =>  512bits => 64 bytes 1000000
                                      
        11111111 - 1000000  = 191  10111111
        
            
    
    
    
     position(1,2,3,4) = 
     first_ int = 0000000 00000001 00000010 000000100
     position(5,6,7,8) =
     second_int = 000000101
                  */  
     //int one = {0,1,2,3}
     //int two = {4,5,6,7}
     //int three = {8+0,8+1,8+2,8+3}
     
     // FROM https://stackoverflow.com/questions/7787423/c-get-nth-byte-of-integer
    //               int x = ((unsigned char *)(&number))[n];
     
/*         
  */   
     
     
     //need 8 ints
     
    //     4 bytes   4 bytes  4bytes  4bytes 4bytes 4bytes 4bytes 4bytes       
                
   // {1,2,3,4}  {5,6,7,8} {9,10,11,12} {13,14,15,16} {17,18,19,20}   {21,22,23,24} {25,26,27,28} {29,30,3132}
    //       1       2          3             4            5              6               7           8
    
    
       //all posistions = {numero of pos, 8+numero of possition,8+8+numerto
          // position 1 => 1,8+1,8+8+1,8+8+8+1
          //   position 2 => 2,2+8,2+8+8
          
   //      position is 1 for the moment
         printf("\n");
         for (int pos = 1 ; pos < 9; pos++) {
             printf("Pos %i\t",pos);
         }
         printf("\n");
            for (int down=0; down < 32; down++) {
                    int a  = pos+down*8;
                   // printIntBits(a);
                    printf("%i\t",a);
                    
            }
            
            
        // } 
         
     //   8*8 = 64 1000000
     //   11111111 - 01000000 = 10111111 191
        
        
      //  191 = 
        
// end of function      
    
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





void printAllCombinations(int numberOfBits,int startByte) {
    printf("\nUsing %i bits\n",numberOfBits);
    //unsigned int startByte = pow(2,onlyListNumberWithBits-1);
    printf("\nStarted printing at %i",startByte);
    int s = pow(2,numberOfBits);
    printf("\nNumber of elems printed %i",s);
    printf("\n{ ");
    for (int i = 0; i< s ; i++) {
        printBits(startByte);
        printf(" , ");
        startByte++;
    }
    printf(" } \n");
}

void printBits(unsigned char number) {
   unsigned char mask = 0x80;
   int it;
   
   for (it=0 ;it < 8; it++) {
       if (number & mask)
           putchar('1');
       else
           putchar('0');
      
       mask >>= 1;
   }
   

   
}

void printShortBits(unsigned short number) {
   unsigned short mask = 0x8000;
   int it;
   
   for (it=0 ;it < 16; it++) {
       if (number & mask)
           putchar('1');
       else
           putchar('0');
      
       mask >>= 1;
   }
   
   //printf("\n");
   
}


void printIntBits(unsigned int number) {
   unsigned int mask = 0x80000000;
   int it;
   
   for (it=0 ;it < 32; it++) {
       if (it % 8 == 0)
           printf(" ");
       if (number & mask)
           putchar('1');
       else
           putchar('0');
      
       mask >>= 1;
   }
   

   
}


void convertByteToAscii(unsigned char byte,char mask) {
    
    
  
    
    
    unsigned char bTemp = byte & mask;
    
    if (bTemp == 0 )
        printf("A");
    else if(bTemp == 0b0001 || bTemp == 0b00010000)
        printf("B");
    else if(bTemp == 0b0010 || bTemp == 0b00100000)
        printf("C");
    else if(bTemp == 0b0011 || bTemp == 0b00110000)
        printf("D");
    else if(bTemp == 0b0100 || bTemp == 0b01000000)
        printf("E");
    else if(bTemp == 0b0101 || bTemp == 0b01010000)
        printf("F");
    else if(bTemp == 0b0110 || bTemp == 0b01100000)
        printf("G");
    else if(bTemp == 0b0111 || bTemp == 0b01110000)
        printf("H");
    else if(bTemp == 0b1000 || bTemp == 0b10000000)
        printf("I");
    else if(bTemp == 0b1001 || bTemp == 0b10010000)
        printf("J");
    else if(bTemp == 0b1010 || bTemp == 0b10100000)
        printf("K");
    else if(bTemp == 0b1011 || bTemp == 0b10110000)
        printf("L");
    else if(bTemp == 0b1100 || bTemp == 0b11000000)
        printf("M");
    else if(bTemp == 0b1101 || bTemp == 0b11010000)
        printf("N");
    else if(bTemp == 0b1110 || bTemp == 0b11100000)
        printf("O");
    else if(bTemp == 0b1111 || bTemp == 0b11110000)
        printf("P");
    

    
}
