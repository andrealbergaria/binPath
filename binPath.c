/* I decided to end this project in c , and coded it in java, because there was no why to handle multiple bytes (that is there is no datatype in c that has like 3 bytes for example*/

#include <stdio.h>
#include <stdlib.h>
// this defines the number of bytes processed each one time


 // The algorithm works by first getting a base of 0000, and change one bit at a time (0001,0010,etc);
// Then it uess a base of 1111 and change one bit at a time (1110,1101,etc...)
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
                 
                 
                 unsigned char bytes[4];
                 unsigned int bytesInt[3];
                 unsigned  char otherBytes[4];
                 
                                     
                 
                 // cycle iterator
                 int iterator;
                
                 // both must be 0 to use the algorithm (start with 00000 flip one at a tiem, set 1111, flip one at a time
                 bytes[0] = 0;
                 bytes[1] = 0b1;
                 otherBytes[0] = 1;
                 otherBytes[1] = 0xF0;
                 
				
                 
                 // 1fst byte
                 for (iterator=1 ; iterator < (sizeof(bytes)-1) ; iterator++) {
					bytes[iterator] = bytes[iterator-1] >> 1;
					otherBytes[iterator] = otherBytes[iterator-1] >> 1;
				 }

                 
                 
                 
                 // 4 bytes
                 bytesInt[0] = 0;
                 bytesInt[1] = 0x80000000;
                 for (iterator=2; iterator < 3; iterator++) {
                     bytesInt[iterator] = bytesInt[iterator-1] >> 1; 
                 }
                 
               
               // thing is, use the algorithm on a binary string like 0b1010101111100 (always bit shift 1)
                
}
