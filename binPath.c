#include <stdbool.h>
#include <stddef.h>
#include <stdio.h>
#include <unistd.h>
#include <crypt.h>
#include "util.h"


void print16();
void print32();




// Print until firstletter = 16
void print16() {
    unsigned char firstLetter = 0;
            unsigned char secondLetter = 0;
            unsigned char thirdLetter = 0;
            unsigned char fourthLetter = 0;
            // prints until 00010000 on first letter
            for (int idx = 0 ; idx < 16 ; idx++) {
                for (int idx2 = 0 ; idx2 < 16 ; idx2++) {
                    for (int idx3 = 0  ; idx3 < 16 ; idx3++) {
                        for (int idx4 = 0  ; idx4 < 16 ; idx4++) {
                            printBits(firstLetter);
                            printf(" ");
                            printBits(secondLetter);
                            printf(" ");
                            printBits(thirdLetter);
                           printf(" ");
                           printBits(fourthLetter);
                           printf("\n");
                           fourthLetter++;
                            
                        }
                        thirdLetter++;
                    }
                secondLetter++;
                }
                firstLetter++;
            }
}

void print32() {
            unsigned char firstLetter = 16;
            unsigned char secondLetter = 0;
            unsigned char thirdLetter = 0;
            unsigned char fourthLetter = 0;
            // prints until 00010000 on first letter
            for (int idx = 0 ; idx < 16 ; idx++) {
                for (int idx2 = 0 ; idx2 < 16 ; idx2++) {
                    for (int idx3 = 0  ; idx3 < 16 ; idx3++) {
                        for (int idx4 = 0  ; idx4 < 16 ; idx4++) {
                            printBits(firstLetter);
                            printf(" ");
                            printBits(secondLetter);
                            printf(" ");
                            printBits(thirdLetter);
                           printf(" ");
                           printBits(fourthLetter);
                           printf("\n");
                           fourthLetter++;
                            
                        }
                        thirdLetter++;
                    }
                secondLetter++;
                }
                firstLetter++;
            }
}


int main() {
              //  print16();
                print32();
}

