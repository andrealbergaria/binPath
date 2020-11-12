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
void getAllCombs_32bits();
char check32Bytes();
void launchProg();
void TestPositions();
void get256Bytes(int *array,int sizeOfArr,int pos);
void getAllCombs_2_elems();
void printTemplate(u_char c);

bool next_permutation(int array[], size_t length);
void permute(char *a, int l, int r);
