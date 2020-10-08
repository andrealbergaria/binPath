
#include <stdio.h>

#define maxBytes 2
//  // The algorithm works by first getting a base of 0000, and change one bit at a time (0001,0010,etc) compared to the base;
// Then it uess a base of 1111 and change one bit at a time (1110,1101,etc...)
// this can be used in arrays
// if you have three bytes {0,0,0} (this 0 can be anything),like {"str","str2","str3"}
// then start by {str, str ,str}
// and keep changing {str,str,str2}
// {str,str2,str} , etcetcetc
// 0 = str
 //  0 = str2
  // 0 =str3

//1=str
//1=str2
// 1=str3

// another view of it, is that 0= 0 and 1=[1,2,3] for example...in this case the 111111 cases needs to invert the zero and the set ([1,2,3]


void printBits(unsigned char );
void printShortBits(unsigned short s);


//from irc
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
   
   printf("\n");
   
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
   
   printf("\n");
   
}



int main() {
                

                /*
                 * 
                 * 
                 * Algorithm , only works with number of bits <= 3
                 * 
                 *  001
                 *  010
                 *  100
                 *  111
                 *  on this phase keep changing bits (like for example 101 or 011 until all acouunted for
                 * 
                 * 
                
                
                */

                /* assign letters to sequence of bits
                 * 
                 * a = 0001 0001 0001
                 * b = 0001 0010 0001
                 */
                 
                 
             /*
              * 
              * where are bits inverted
              * 0001 1110
              *                  A    B   C    D   E    F   G  H
                char half[3] = { 000,001,010,100,111 ,110,101,011 }
                a // {*half1,*half1,*half1 }
                b // {*h1,*h2,*h1 } 
                c // {*h1,*h1,*h2} 
                d // {*h2,*h1,*h2} 
                e // {*h2,*h2,*h1} 
                 ... and so one
                 a[0] = *half1
                 */
                char half[8] =  { 'A','B','C','D','E','F','G','H'};
                char bitsToTest[3];
                char half[8];
                
                 bitsToTest[0] = half[0];
                 bitsToTest[1] = half[0];   // A  A  A
                 bitsToTest[2] = half[0]; // 000 000 000
                                            // B A   A
                 bitsToTest[0] = half[1]; // 001 000 000 
                                          //  B   B   A
                 bitsToTest[1] = half[1]; // 001 001 000
                 bitsToTest[2] = half[1]; // 001 001 001
                 
                 
                 
                 bitsToTest[0] = half[2]; // 010 001 001
                 bitsToTest[1] = half[2]; // 010 010 001
                 bitsToTest[2] = half[2]; // 010 010 010
                 
                 
                 unsigned char positionArray[8] = {1,2,4,8,16,32,64,128};

                int index = 0;
                for (index = 0 ; index < 2^3 ;  index++) {
                    bitsToTest[0] = half[index];
                    bitsToTest[1] = half[index];
                    bitsToTest[2] = half[index];
                }
                   
                    // 8 bits ... have (1 bit | 3 bits | 1 bit | 3 bits)
                        
 
                           
                            
                         
                       
                       
                    

}
