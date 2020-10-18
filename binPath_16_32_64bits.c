#include <stdbool.h>
#include <stddef.h>
#include <stdio.h>
#include <unistd.h>
#include "util.h"
#include "crypto.h"

void print16();
void print32();
void print64();



/*
 * 256 bits / 8 bits = 32 bytes
 */
void print64(int firstLetterMAX , int numberOfLetters) {
    char positions[numberOfLetters];
    // First assign 0 to letters
    for (int idx = 0 ; idx < numberOfLetters ; idx++)
        positions[idx] = 0;

    // Calculate bits
     for (int idx = 0 ; idx < firstLetterMAX ; idx++) {
             // first letter
                for (int idx2 = 0 ; idx2 < 16 ; idx2++) {
                    // second letter
                    for (int idx3 = 0  ; idx3 < 16 ; idx3++) {
                        // third letter
                        for (int idx4 = 0  ; idx4 < 16 ; idx4++) {
                            // fourth letter
                            for (int idx5 = 0 ; idx5 < 16 ; idx5++) {
                                // fifth letter
                                for (int idx6= 0 ; idx6 < 16; idx6++) {
                                    // sixth letter
                                        printBits(positions[0]);
                                        printf(" ");
                                        printBits(positions[1]);
                                        printf(" ");
                                        printBits(positions[2]);
                                        printf(" ");
                                        printBits(positions[3]);
                                        printf(" ");
                                        printBits(positions[4]);
                                        printf(" ");
                                        printBits(positions[5]);
                                        printf("\n ");
                            
                                        positions[5]++;
                                }
                                    positions[4]++;
                                }
                                positions[3]++;
                            }
                            positions[2]++;
                        }
                        positions[1]++;
                    }
                positions[0]++;
            }
    
    }
    
    
    
// Print until firstletter = 16
void print16() {
    unsigned char firstLetter = 0;
            unsigned char secondLetter = 0;
            unsigned char thirdLetter = 0;
            unsigned char fourthLetter = 0;
            // prints until 00010000 on first letter
            int firstLetterMAX = 480;
            for (int idx = 0 ; idx < firstLetterMAX ; idx++) {
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
            unsigned char firstLetter = 0;
            unsigned char secondLetter = 0;
            unsigned char thirdLetter = 0;
            unsigned char fourthLetter = 0;

            // prints until 00010000 on first letter
            // 400 max number
            for (int idx = 0 ; idx < 16*16 ; idx++) {
                for (int idx2 = 0 ; idx2 < 16 ; idx2++) {
                    for (int idx3 = 0  ; idx3 < 16 ; idx3++) {
                        for (int idx4 = 0  ; idx4 < 16 ; idx4++) {
                          /*  printBits(firstLetter);
                            printf(" ");
                            printBits(secondLetter);
                            printf(" ");
                            printBits(thirdLetter);
                           printf(" ");
                           printBits(fourthLetter);
                           printf("\n");
                           */
                            printf("%i ",firstLetter);
                            printf("%i ",secondLetter);
                            printf("%i ",thirdLetter);
                            printf("%i\n",fourthLetter);
                            
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
                //print16();
                print32();
              //  print64(600,6);
}

