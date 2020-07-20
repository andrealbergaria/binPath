
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
                 // file contains ABC = 24 bytes
                // encrpyted file has = 256 bytes
                // encrypted = 256 chars =
                                    //4 bytes => 1 int
                                    //256     =>  X
                                    //256/4, X = 64 ints

                /* Tbhe algorithm is like this
                first consider 00001
                then keep shifting to the left, until all 1 are accounted for
                // Then use 111111
                // and keep changing one bit of the base, until all bits accounted
                */


                

                 unsigned char positionArray[8] = {1,2,4,8,16,32,64,128};

                unsigned short test = 0xFAFE;

                int indexTotal  = 0; // index of bytes on the array used
                // max size of bytes long double                
                
                        /*
                        process zero on all cells, calculatedSoFar=0
                        */
                        
                        
                         unsigned char ones = 0xFF;
                         
                         //printShortBits(zeros);
                      //   printShortBits(ones);
                         unsigned short shiftLeftBytes=1;
                         unsigned short ones_t = ~shiftLeftBytes;
                         
                         
                   /*     for (int indexTotal= 0 ; indexTotal < 8;indexTotal++) {
                            printBits(zeros);
                            for (int cellPosition =0  ;cellPosition < 1; cellPosition++) {
                                shiftLeftBytes = zeros << 8;
                                ones_t = ~shiftLeftBytes;
                                
                                printShortBits(shiftLeftBytes);
                                
                                if (ones_t == test || shiftLeftBytes == test) {
                                    printf("\nFOUND\n");
                                    printf("\nFOUND\n");
                                }
                            }
                           printShortBits(zeros); 
                           zeros <<= 1;
                           
                           
                           ones = ~zeros;
                    }
                        //number |= 1UL << n; (set n bit)
                      //  number ^= 1UL << n; // toggle n bit
                   
                     */
                   
                    // 8 bits ... have (1 bit | 3 bits | 1 bit | 3 bits)

                            unsigned char zeros=1;
                           
                            unsigned char mask = 0b1000000;
                            
                   // omiss zeros=0; trivial case
                   //unsigned char base_3bits[8] = {000,0b001,0b010,0b011,0b100,0b101,0b110,0b111};
                 //  for (int numOfBytes = 0 ; numOfBytes < 2; numOfBytes++) {
                           
                            //value = (value & ~mask) | (newvalue & mask);
                        
                      // zeros = zeros ^ (1 << 7) ; // 
                       
                            
           //                  3bits left  3 bits right =0
//    3bits right 3 bits left = 0
    
    
 /*   111 000
    000 111 
    
    111 111
    000 000
   */                         
                            zeros = (zeros & mask);
                            printBits(zeros);
                       unsigned char shift;
                       zeros <<= 7;
                       for (int base =0 ; base < 7; base++) {
                                
                            zeros += 1;
                            shift = zeros << 4;
                            printBits(shift);
                            
                       }
                       zeros = 0;
                       for (int base =0 ; base < 7; base++) {
                                
                            zeros += 1;
                            printBits(zeros);
                       }
                       
                      
                       //printBits(zeros);
                       
                       //zeros = zeros ^ (1 << 4);
                     /*  
                       for (int base =0 ; base < 7; base++) {
                            
                            zeros -= 1;
                            printBits(zeros);
                       }
                       */
                       
                      
                       
                   
                     
                     
                           
                         
                    

}
