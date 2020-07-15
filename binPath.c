
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
                
                 // cycle iterator
                 int it=0;
                 
                 
                 
                 unsigned char  *currentByte = &baseZeros
                 unsigned char  *invertedCurrentBytes = &baseOnes;
                 
                 int itBytes=1; // iterates through bytes not counting the first
                 // cycles through all bytes from variable (in this case ints=4 bytes) 
                 
                 
                 for ( ; itShift < 8 ; itShift++) {
                        *currentByte <<= 1;
                        
                        for ( ; itBytes < 4 ; itBytes++) {
                            *currentByte+itBytes = *currentByte <<= 1;
                        }

                 }
                 
                 
                 curreByte[0] =  cvuren<<=?1
                 curreBytes[1] = curr << 1
                 
                // they have the same numbesr, so i need to copy from byte 1 to the others bytes
                     
                *currentByte+1  = *currentByte;
                *currentByte+2 = *currentByte;
                *currentByte+3 = *currentByte;
                *currentByte+4 = *currentByte;
                
                *currentByte <<= 1;
                
                set zero
                *curretnByte+1 = *currentByte;
                
                 
                 for (; it < 8; it++) {
                            *currentByte+it2 = *currentByte;
                            *currentByte 
                            
                            // how to shift ? 
                          
                            
                 }
                        *currentByte =0; 
                        currentByte++; // currentByte points to the byte, that is going to be used
                        *currentByte=1; // in this case , we always start with 00000001 (as en example)
                 }
                 
