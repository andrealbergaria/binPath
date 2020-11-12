#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <stddef.h>


#define numPositions 8
#define numOfRows 32 // 8*32 => 256


void printAllCombinations(int numOfBits, int startByte);
void printBits(unsigned char number);
void printShortBits(unsigned short number); 
void printIntBits(unsigned int number);

void convertByteToAscii(unsigned char byte,char mask);

void printStrings();
void printFullArray();
void printUsingFunction();
void getAllCombinations();
char check32Bytes();
void launchProg();
void TestPositions();
void printTemplate(u_char c);
void assignArrayToPosition(int *array,int sizeOfArr,int pos);
void trying6Elems();


bool next_permutation(int array[], size_t length);
void permute(char *a, int l, int r);
