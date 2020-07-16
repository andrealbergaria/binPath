
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
                
                /*
                 *bytes that are procesed = 4
                 * *8 because each cell is 8
                 * so 4+8 = 12
                 * */
                unsigned char totalArray[4];  // represent how many bytes we want to process (in this case a int)
                
                 
                 // Trying to minimize cycles,like since the characteres have alll the same value,copy the values between variables
                 
                 
                 unsigned char occupiedCell[8]; // each cell represents a byte
                                                // 00000000
                                                // 00000001 (all cells)
                                                // 00000010
                 
                 occupiedCell[0] = 1; // the equivalent to 000001
                 occupiedCell[1] = 0b10;
                 occupiedCell[2] = 0b100;
                 occupiedCell[3] = 0b1000;
                 occupiedCell[4] = 0b10000;
                 occupiedCell[5] = 0b100000;
                 occupiedCell[6] = 0b1000000;
                 occupiedCell[7] = 0b10000000;
                 
                unsigned char *line = &occupiedCell;
                
                int index  = 0; // index of total array
                
                for ( ; index < 4 ; index++) {
                    totalArray[index] = 
                }
                                  
