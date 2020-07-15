
#include <stdio.h>


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



void printBin(unsigned int n) {
    
    int it = 0;
    while (it < 32) {
        
    if(n&1) 
        printf("1");
    else 
        printf("0");
    n = n >> 1;
    it++;
    }
}    

int main() {
                 // file contains ABC = 24 bytes
                // encrpyted file has = 256 bytes
                // encrypted = 256 chars = 
                                    4 bytes => 1 int
                                    256     =>  X
                                    256/4, X = 64 ints
                                    
                /* Tbhe algorithm is like this
                first consider 00000
                then keep shifting one bit to the left
                then consider instead of 00000  , 111111
                keep shifting
                all bits accounted
                */
                unsigned int baseZeros = 0;
                unsigned int baseOnes = 0;
                //[a,b,c,d]
                 // cycle iterator
                 int it=0;
                 
                 unsigned char  *currentByte = &baseZeros
                 unsigned char  *invertedCurrentBytes = &baseOnes;
                 
                 unsigned char auxByte = *currentByte;
                                            
                 unsigned char shift = 1;
                 
                 int it2=2;
                 // cycles through all bytes from variable
                 for ( ; it2 < 
                 
                 for (; it < 4; it++) {
                        shift = shift << 1;
                 }
                 
