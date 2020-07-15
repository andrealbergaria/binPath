
#include <stdio.h>

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
        char t= 0b110100;
                //  000001   (xor)
                //  ------
                //  110100
        char xored = num^1;
        printBin(xored);
}
