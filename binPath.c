
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


void printBits(unsigned char *);

void printBits2(unsigned char *n,int size) {

    int it = 0;
    while (it < size) {

    char mask = 0x10000000;
    if(*n&mask)
        printf("1");
    else
        printf("0");
    *n = *n >> 7;
    it++;
    }
    printf("\n");
}
//from irc
void printBits(unsigned char *n) {
    // from irc for (int mask = 128; i > 0; i>>=1) printf("%c", *currentByte & mask ? '1' : '0')
   unsigned char mask = 0b10000000;
   int it;
   
   for (it=0 ;it < 8; it++) {
       if (*n & mask)
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
                first consider 00000
                then keep shifting one bit to the left
                then consider instead of 00000  , 111111
                keep shifting
                all bits accounted
                */

                /*
                 *bytes that are procesed = 4
                 * *8 because each cell is 8
                 * so 4+8 = 12
                 * */



                 unsigned short calculatedSoFar = 0;


                 unsigned char positionArray[8] = {1,2,4,8,16,32,64,128};

                 // Trying to minimize cycles,like since the characteres have alll the same value,copy the values between variables
                 // so process 1 byte, zero all, process 2 byte, etc...

                unsigned char zeros = 0;
                unsigned char ones = ~zeros;

                // on the end, of processing a byte (00000 000010 00001000....), sets the number to zero
                //calculatedSoFar = ones & 1; // sets zeros on all the bytes in the numebrs

                unsigned int test = 0b10100001010101010100110011011101;

                int indexTotal  = 0; // index of bytes on the array used
                unsigned char ten = 0x10;
                printBits(&ten);
                        /*
                        process zero on all cells, calculatedSoFar=0
                        */
                
                        // start iterating with 1 (so one can shift ...

                    for (indexTotal = 0 ;indexTotal < 8; indexTotal++) {
                        calculatedSoFar = positionArray[indexTotal];
                       // printBits(&calculatedSoFar,8);
                        //calculatedSoFar >>=8;
                        //printBits(&calculatedSoFar,16);
                    }
                        
             /*       for (indexTotal = 0 ;  indexTotal < 8; indexTotal++) {
                        
                        printBinShort(calculatedSoFar);
                        for (int cellPosition =0  ;cellPosition < maxBytes; cellPosition++) {
                            calculatedSoFar <<= 8;
                            printBinShort(calculatedSoFar);
                        }

                    }

            */

}
