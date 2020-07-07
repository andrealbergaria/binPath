
#include <stdio.h>
#include <stdlib.h>


//  // The algorithm works by first getting a base of 0000, and change one bit at a time (0001,0010,etc) compared to the base;
// Then it uess a base of 1111 and change one bit at a time (1110,1101,etc...)
// this can be used in arrays
// if you have three bytes {0,0,0} (this 0 can be anything),like {"str","str2","str3"}
// then start by {str, str ,str}
// and keep changing {str,str,str2}
// {str,str2,str} , etcetcetc 
// 



if you want to get all combinarions, just use 000 and then 001, and 010, and 100

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
                 
				 
                // 1st byte
                 for (iterator=1 ; iterator < 0; iterator--) {
                    firstHalf[iterator] = firstHalf[iterator-1] << 1;
				 }
				
				 for (iterator=1 ; iterator < 0 ; iterator--) {
                    
                    secondHalf[iterator] = secondHalf[iterator-1] << 1;
                 }
                 
                 // 2nd bytes
                  unsigned char *firstHalfA = firstHalf; 
                  unsigned char *firstHalfB = 0;
                  
                  unsigned char *secondHalfA = secondHalf;
                  unsigned char *secondHalfB = 0;
                  
                  unsigned char *thirdHalfA = 0;
                  unsigned char *thirdHalfB = firstHalf;
                  
                  unsigned char *fourthHalfA = 0;
                  unsigned char *fourthHalfB = secondHalf;
                  
                  
                  
                  
                  unsigned char zero[4] = {firstHalf[0],firstHalf[1],firstHalf[2],firstHalf[3]};
                  unsigned char one[4] = {secondHalf[0],secondHalf[1],secondHalf[2],secondHalf[3]};
                  
                  unsigned char temp_threeBytes[3] = { firstHalf[0],firstHalf[0],firstHalf[0]};;
                  unsigned char aux[3];
                                                 
                  
                  int pos=0;
                  for (iterator=1; iterator < 4; iterator++) {
                            temp_threeBytes =
                            temp_threeBytes[iterator] = temp_threeBytes[iterator-1];
                            
                            
                            
                  }
                      
                  
                  
                  
                 
                 // 3rd bytes
                 
                 
                 // 3rd bytes
                 char threeBytes_firstHalf[4];
                 char threeBytes_secondHalf[4];
                 
                 for (iterator=0 ; iterator < 3; iterator++) {
                     threeBytes_firstHalf[iterator] = firstHalf(iterator);
                     threeBytes_secondHalf[iterator] = secondHalf(iterator);
                 }
                 
                 
                
               // thing is, use the algorithm on a binary string like 0b1010101111100 (always bit shift 1)
                
}
