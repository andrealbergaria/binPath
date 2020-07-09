#include <stdio.h>

// this defines the number of bytes processed each one time
#define numBytes 10

 // The algorithm works by first getting a base of 0000, and change one bit at a time (0001,0010,etc);
// Then it uess a base of 1111 and change one bit at a time (1110,1101,etc...)


// 
char carray[4];
int it=0
int pos=0;

pos= 0
array[pos] = 1;
pos=1
array[pos] = array[pos-1];
pos=2
array[pos] = 1;




pos[1] = 1;
pos[2] = 1;

for (
    carray[pos] = 0b100;
    pos++;
    
int main() {
                 
                 
                 
				 unsigned char bytes[20];
                 bytes[0] = { 0b00000000 } ;
                                     
                 
                 unsigned char index = {0b10000000 };
                 
                 
                 
                // do not use shift because its expensive, prefer using assignment operator (asssign bytes to the array of bytes, like
                 //bytesRearrange[0] = bytes[0]
                 // bytesRearrange[1]  = bytes[0];
                 // use bits as streams like (0b000 , 0b001 , 0b010 , keep changing
                 
                 // thing is, use the algorithm on a binary string like 0b1010101111100 (always bit shift 1)
                 
                 // multiple bytes
                int bytesInt[3];
                bytesInt[0] = 0;
				 
                int iterator;
                 
                 for (iterator=1 ; iterator < 3; iterator++) {
                     bytesInt[iterator] = bytesInt[iterator-1] >> 1;
                 }
                 
                 bytesInt[iterator] = bytesInt[iterator-1];
                 
                 
                 
                // single bytes
				 for (iterator=1 ; iterator < (sizeof(bytes)-1) ; iterator++) {
					bytes[iterator] = bytes[iterator-1] >> 1;
                    
				}
				 unsigned  char otherBytes[] = new char[20];
                 otherBytes[0] = { 0b11111111 };
                 

				 for (iterator=1 ; iterator < (sizeof(otherBytes)-1); iterator++) {
						otherBytes[iterator] = otherBytes[iterator-1] >> 1;
					}

                
                
                
					
					
}
