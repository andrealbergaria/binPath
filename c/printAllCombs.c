#include "util.h"

int main(int argc,char *argv[]) {
    
    if (argc != 4) {
        printf(" ARG[1] -> number_of_bits_to_print\n");
        printf(" ARG[2] -> start_byte\n");
        printf(" ARG[3] -> wheter print bytes in new line or not (new | listed)\n");
        return -1;
    }
    int startByte = atoi(argv[2]);
    int numberOfBits = atoi(argv[1]);
    
    
    printf("\nUsing %i bits\n",numberOfBits);
    printf("\nStarted printing at %i",startByte);
    
    int s = pow(2,numberOfBits);
    
    printf("\nNumber of elems printed %i\n",s);
    
    if (strcmp(argv[3],"listed")==0)
        printf("\n{ ");
    
    for (int i = 0; i< s ; i++) {
        printBits(startByte);
        if (strcmp(argv[3],"listed")==0) {
            printf(" , ");
            startByte++;
        }
        else if(numberOfBits > 8) {
            printf("    ");
            startByte++;
            printBits(startByte);
            printf("\n");
        }
        else {
            printf("\n");
            startByte++;
        }
        
    }
    printf(" } \n");
}
