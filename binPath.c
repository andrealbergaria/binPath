
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


                  //  solution one possibility is too assign four pointers to a firstHal, and then dereference them when needed (like for instance , where 0 0 (hence derefence on the second 0)
                 // char *f1 = secondHalf
                 
                 // char half[4] = { 0001,0010,0100,1000 }
                 
             /*    char *h1 = half[0]
                 char *h2 = half[1]
                 char *h3 = half[2]
                 char *h4 = half[3]
                 
                a // {*h1,*h1,*h1 }
                b // {*h1,*h2,*h1 } 
                c // {*h1,*h1,*h2} 
                d // {*h2,*h1,*h2} 
                e // {*h2,*h2,*h1} 
                 ... and so one
                 it = 0
                 a[0] = *h1
                 a[1] = *h1
                 a[2] = *h1
                 
                 a[1] = *h2; ( h1 h2 h1
                 a[1] = *h3  ( h1 h3 h1)
                 a[1] = *h4  (h1 h4 h1)
                 
                 a[1] = a[0]
                 
                 a[2] = *h2; ( h1 h2 h1
                 a[2] = *h3  ( h1 h3 h1)
                 a[2] = *h4  (h1 h4 h1)
                 
                 a[2]  = a[1] */
                 
                 

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
                    }
                        //number |= 1UL << n; (set n bit)
                      //  number ^= 1UL << n; // toggle n bit
                   
                     */
                   
                    // 8 bits ... have (1 bit | 3 bits | 1 bit | 3 bits)

                            unsigned char zeros;
                           
                            
                   // omiss zeros=0; trivial case
                   //unsigned char base_3bits[8] = {000,0b001,0b010,0b011,0b100,0b101,0b110,0b111};
                       
              /*          0 | 3 | 1 | 3 bits
                        0   3   0   3
                        1   3   0   3
                        1   3   1   3
                        bits
                        first) 0 1
                        second ) 0 0 
                        third ) ~first
                        fourth ) ~ second
                        */
                        
 /*   111 000 (first_config) 8 bits
   1 000 1 111    (second_config) 8 bits
    
     000 000 (third config) 8bits 
     111 111 (fourth_config 8bits
  
   */                         
 
                           
                            
                         unsigned char first_config = 1;
                         // 000 111
                         unsigned char second_config = 1;
                         
                         unsigned char third_config = 1;
                         
                         unsigned char fourth_config = 1;
                         
                         
                       
                       
                       for (int base =0 ; base < 7; base++) {
                           // set first and third bits
                           
                            zeros += 1;
                            first_config  = zeros << 4;
                           
                            
                            
                            
                            //printBits(first_config);
                            second_config = zeros;
                           
                            // 1111 0000  (first config)
                            // 0000 1111  (second_config)
                            // 0000 0000 (third_config)
                            // 1111 1111  (fourth_config)

                            /* 1101 0010
                             * 
                               0010 1101
                               
                               0010 0010
                               
                               1101 1101
                            */
                            third_config = second_config & first_config;
                            
                             fourth_config = first_config ^ second_config;
                           // printBits(first_config);
                           // printBits(second_config);
                            printBits(third_config);
                            printBits(fourth_config); 
                       }
                    

}
