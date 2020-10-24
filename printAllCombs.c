#include "util.h"

int main(int argc,char *argv[]) {
    
    if (argc != 3) {
        printf(" ARG[1] -> number_of_bits_to_print ");
        printf(" ARG[2] -> start_byte ");
        return -1;
    }
    int startByte = atoi(argv[2]);
    int numberOfBits = atoi(argv[1]);
    printf("\nUsing %i bits\n",numberOfBits);
    printf("\nStarted printing at %i",startByte);
    int s = pow(2,numberOfBits);
    printf("\nNumber of elems printed %i",s);
    printf("\n{ ");
    for (int i = 0; i< s ; i++) {
        printBits(startByte);
        printf(" , ");
        startByte++;
    }
    printf(" } \n");
}
