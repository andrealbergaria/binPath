#include "util.h"

int main() {
    char buffer = 0;
    char temp;
    
    for (int idx = 0 ; idx < 256; idx++) {
        buffer=idx;
        printBits(buffer);
        printf(" ");
        temp = buffer & 0b11;
        printf("{ ");
        printf("%i ",temp);
        temp = buffer & 0b1100;
        printf(", ");
        printf("%i ",temp);
        temp = buffer & 0b110000;
        printf("%i",temp);
        printf("} \n");
        buffer++;
        
    }
}
