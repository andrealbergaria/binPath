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
    //printUntil256();
    // 256 bits , em bytes são 32
   // 32 bytes / 4 bytes (size of int) = 8
     // int a[3][4] = {  
//   {0, 1, 2, 3} ,   /*  initializers for row indexed by 0 */
//   {4, 5, 6, 7} ,   /*  initializers for row indexed by 1 */
 //  {8, 9, 10, 11}   /*  initializers for row indexed by 2 */
// };

//64 bits * 4  = 256 ..
       
    // Function for getting chars
    // f(pos) = 8k+pos
     
                    
                        
      //32 bytes need need 8 ints
     
          // FROM https://stackoverflow.com/questions/34357968/how-to-set-first-three-bytes-of-integer-in-c
          /*int a = 4294967233;
                char* p=&a;
  
                p[0] = whatever you wanted there
                p[1] = whatever you wanted there
          */
          
         // double res, %f 
        unsigned int array_base[8] = {0x00010203,0x04050607,0x08090A0B,0xC0D0E0F};
        unsigned int mask_add_8 =    0x08080808;
        int *ptr = array_base;
        int *ptr2 = &array_base[1];
        
       
      double res;
        int *currentByte = &res;

        //currentByte[0] = something
             

           /* unsigned int  a = (array_base[1] & 0xff000000) >>24;
             unsigned int b = (array_base[1] & 0x00ff0000) >>16;
             unsigned int c = (array_base[1] & 0x0000ff00) >>8;
             unsigned int d = (array_base[1] & 0x000000ff) ;
             
             printf(" %u %u %u %u ",a,b,c,d);
             
             // 8*32 = 256  (one byte, combinations)
            // 8* 8192  = 65536 (two bytes,combinations)
            // 8* 536870912  = 4294967296 (4bytes , combs)
             
            printf("\n");*/
        
         for (int nums = 0; nums <32 ; nums++) {
             
             printf(" Array 0 ");
             printIntBits(array_base[0]);
            // printf(" Array 1 ");
            // printIntBits(array_base[1]);
             
             array_base[0] += mask_add_8;
            // array_base[1] += mask_add_8;
            
            }
                          
             
    //     }
         
            // INT COMBS : 4294967296

         
         
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


void printUntil256() {
    
    
    // look at function .. f(pos) = 8*i + pos
    // int combinations 4294967296
    // 
     unsigned int t=0;
     for (int pos = 1; pos < 9;pos++) {
        //printf("\nPos %i = ",pos);
            // 8*32 = 256  (one byte, combinations)
            // 8* 8192  = 65536 (two bytes,combinations)
            // 8* 536870912  = 4294967296 (4bytes , combs)
        for (int it= 0; it <= 8192; it++) {
            //printf(",%u",t);
            t = 8*it+pos;
            
            if (t % 256 == 0) 
                printf("\n%u",t);
           
          /*  if (t % 2 == 0)
                printf(" even ");
            else
                printf(" odd ");
            */
            
         }
        t=0;
     }
    
        
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
    printf("\t%i",number);
   

   
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
   
   printf("\t%i",number);
   
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
   
    printf("\t%u\n",number);
   
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

