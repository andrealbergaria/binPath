#include <stdio.h>


 // The algorithm works by first getting a base of 0000, and change one bit at a time (0001,0010,etc);
// Then it uess a base of 1111 and change one bit at a time (1110,1101,etc...)

int main() {
                 bytes[0] = { 0b00000000 } ;
                 bytes[1] = { 0b10000000 };
                 
				 unsigned char bytes[] = new char[20];
				 

				 int iterator;

				 for (iterator=2 ; iterator < (sizeof(bytes)-1) ; iterator++) {
					bytes[iterator] = bytes[iterator-1] >> 1;
					
				}
				 unsigned  char otherBytes[] = new char[20];
                 otherBytes[0] = { 0b11111111 };
                 

				 for (iterator=1 ; iterator < (sizeof(otherBytes)-1); iterator++) {
						otherBytes[iterator] = otherBytes[iterator-1] >> 1;
					}
}
