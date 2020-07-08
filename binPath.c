
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
                 
                 
                 unsigned char firstHalf[4];  
                 unsigned char secondHalf[4]; 
                 
                                     
                 firstHalf[0] =  0;
                 firstHalf[1] = 0x1;
                 firstHalf[2] = 0x2;
                 firstHalf[3] = 0x4;
                 
                 secondHalf[0] = 1;
                 secondHalf[1] = 0xFE;
                 secondHalf[2] = 0xFD;
                 secondHalf[3] = 0xFC;
                 
                 
                 // cycle iterator
                 int iterator;
                
                 // both must be 0 to use the algorithm (start with 00000 flip one at a tiem, set 1111, flip one at a time
                 // getting rid of 00000 and 111111 bytes (they can be assigned convenetly
                 //firstHalf[0]  = 0;
                 
                 // 2nd bytes
                  unsigned char *firstHalfA = firstHalf; 
                  unsigned char *firstHalfB = 0;
                  
                  unsigned char *secondHalfA = secondHalf;
                  unsigned char *secondHalfB = 0;
                  
                  unsigned char *thirdHalfA = 0;
                  unsigned char *thirdHalfB = firstHalf;
                  
                  unsigned char *fourthHalfA = 0;
                  unsigned char *fourthHalfB = secondHalf;
                  
                  
                  
                 // igualar variavel a 
                  // [half1 ,half0,half0
                  // half0,halff1, half0
                  // half0,half0,half1
                  
                  
                  // remains here because its a possibly solution
                  //unsigned char zero[4] = {firstHalf[0],firstHalf[1],firstHalf[2],firstHalf[3]};
                  //unsigned char one[4] = {secondHalf[0],secondHalf[1],secondHalf[2],secondHalf[3]};
                    //one possibility is too assign four pointers to a firstHal, and then dereference them when needed (like for instance , where 0 0 (hence derefence on the second 0)
                  
                 unsigned char ar[4];
                 ar[0] = firstHalf[0];
                 ar[1] = firstHalf[1];
                 ar[2] = firstHalf[2];
                 ar[3] = firstHalf[3];
                 
                 unsigned char *ptr = &ar[0];
                 
                 
                 
                for (iterator = 0 ; iterator < 2; iterator++) {
                    
                }
                      
                      
                      
                      
                      
                        
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
