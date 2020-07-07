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
                 
                 
                 unsigned char firstHalf[4];  // 4 bytes 0000
                 unsigned char secondHalf[4]; // 4 bytes 1111
                 unsigned char twoBytes_firstHalf[4];
                 unsigned char twoBytes_secondtHalf[4];
                 
                 unsigned char twoBytes1_firstHalf[4];
                 unsigned char twoBytes1_secondtHalf[4];
                 
                                     
                 
                 // cycle iterator
                 int iterator;
                
                 // both must be 0 to use the algorithm (start with 00000 flip one at a tiem, set 1111, flip one at a time
                 // getting rid of 00000 and 111111 bytes (they can be assigned convenetly
                 //firstHalf[0]  = 0;
                 firstHalf[0] = 0x1;
                 secondHalf[1] = 0x1;
                 
				twoBytes_secondtHalf[
                 
                // 2nd bytes
                 for (iterator=1 ; iterator < 0; iterator--) {
                    twoBytes_secondHalf[iterator] = 0;
					firstHalf[iterator] = firstHalf[iterator-1] << 1;
                    twoBytes_firstHalf[iterator] = firstHalf[iterator];
				 }
				 
				
				 for (iterator=1 ; iterator < 0 ; iterator--) {
                    twoBytes_firstHalf[iterator] = 0;
                    secondHalf[iterator] = secondHalf[iterator-1] << 1;
                    twoBytes_secondHalf = secondHalf[iterator];
                 }

                 // 3rd bytes
                 char threeBytes_firstHalf[4];
                 char threeBytes_secondHalf[4];
                 
                 for (iterator=0 ; iterator < 3; iterator++) {
                     threeBytes_firstHalf[iterator] = firstHalf(iterator);
                     threeBytes_secondHalf[iterator] = secondHalf(iterator);
                 }
                 
                 
                
               // thing is, use the algorithm on a binary string like 0b1010101111100 (always bit shift 1)
                
}
