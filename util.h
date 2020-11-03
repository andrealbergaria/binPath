#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

#define numPositions 8
#define numOfRows 8*32 // 256


void printAllCombinations(int numOfBits, int startByte);
void printIntBits(unsigned int number);
void convertByteToAscii(unsigned char byte,char mask);
void printBits(unsigned char number);
void printShortBits(unsigned short number); 
void printStrings();
void printFullArray();
void printUsingFunction();
void getAllCombs_32bits();
char check32Bytes();
void assignArray(unsigned char positionToColumn[numPositions][numOfRows]);
