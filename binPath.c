#include <stdbool.h>
#include <stddef.h>
#include <stdio.h>

//  // The algorithm works by first getting a base of 0000, and change one bit at a time (0001,0010,etc) compared to the base;
// Then it uess a base of 1111 and change one bit at a time (1110,1101,etc...)
// this can be used in arrays
// if you have three bytes {0,0,0} (this 0 can be anything),like {"str","str2","str3"}
// then start by {str, str ,str}
// and keep changing {str,str,str2}
// {str,str2,str} , etcetcetc
// 0 = str
 //  0 = str2
  // 0 =str3

//1=str
//1=str2
// 1=str3

// another view of it, is that 0= 0 and 1=[1,2,3] for example...in this case the 111111 cases needs to invert the zero and the set ([1,2,3]


void printBits(unsigned char);
void printShortBits(unsigned short s);
void printBinary(char * ,int size);
bool next_permutation(char * ,size_t);

/* 
 * Next lexicographical permutation algorithm (C)
 * by Project Nayuki, 2017. Public domain.
 * https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */


/*
 * https://www.nayuki.io/res/next-lexicographical-permutation-algorithm/nextperm.c
 * 
 * Computes the next lexicographical permutation of the specified array of integers in place,
 * returning a Boolean to indicate whether a next permutation existed.
 * (Returns false when the argument is already the last possible permutation.)
 */
bool next_permutation(char *array, size_t length) {
	// Find non-increasing suffix
	if (length == 0)
		return false;
	size_t i = length - 1;
	while (i > 0 && array[i - 1] >= array[i])
		i--;
	if (i == 0)
		return false;
	
	// Find successor to pivot
	size_t j = length - 1;
	while (array[j] <= array[i - 1])
		j--;
	int temp = array[i - 1];
	array[i - 1] = array[j];
	array[j] = temp;
	
	// Reverse suffix
	j = length - 1;
	while (i < j) {
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		i++;
		j--;
	}
	return true;
}


/* This code can be mechanically translated to a programming language of your choice, with minimal understanding of the algorithm. (Note that in Java, arrays are indexed from 0.)
Example usages

Print all the permutations of (0, 1, 1, 1, 4):

int[] array = {0, 1, 1, 1, 4};
do {  // Must start at lowest permutation
    System.out.println(Arrays.toString(array));
} while (nextPermutation(array));

  */
/*
 * CLOSE FROM
 * 
 */



//from irc
void printBits(unsigned char number) {
   unsigned char mask = 0x80;
   int it;
   
   for (it=0 ;it < 8; it++) {
       if (number & mask)
           putchar('1');
       else
           putchar('0');
      
       mask >>= 1;
   }
   
   printf("\n");
   
}


void printShortBits(unsigned short number) {
   unsigned short mask = 0x8000;
   int it;
   
   for (it=0 ;it < 16; it++) {
       if (number & mask)
           putchar('1');
       else
           putchar('0');
      
       mask >>= 1;
   }
   
   printf("\n");
   
}

          

void printBinary(char *array,int sizeOfArray) {
    
    for (int idx = 0; idx < sizeOfArray; idx++) {
        if (array[idx] == 'A')
            printf("00");
        else if(array[idx] == 'B')
            printf("01");
        else if(array[idx] == 'C')
            printf("10");
        else 
            printf("11");
     
    }
}

int main() {
           
     

                /*
                 * 
                 * 
                 * Algorithm , only works with number of bits <= 3
                 *  000
                 *  001
                 *  010
                 *  100
                 *  111
                 *  110
                 *  101
                 *  011
                 *  on this phase keep changing bits (like for example 101 or 011 until all acouunted for
                 * 
                 * 
                /*
                 * For 4 bits , needs
                 * 3,5,6,7
                 * 
                 * C , CA , CC , 
                 * 
                 * For 5 bits, bits needed 
                 * 3,5,6,7,9,10,11,12,13,14,15
                   
                   
                   
                For 6 bits needs
                    
                 3,5,6,7,9,10,11,12,13,14,15,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31

                    
                A = 01 1d
                B = 10 2d 
                C = 11 3d
                D = 00 0d
                
                
                /*
                 * 
                 * For 4 bits
                 
               /* a)
                0000
                0001 // 1
                0010 // 2
                0100 // 4       => number = 2^x
                1000 // 8

                /*
                 * 
                 *  Trying to find seq of numbers not already taken
                 
                
                
                sequence of numbers not to be filled  a) 3,5,6,7
                12,10,9 => Numbers reverse from previous sequence a)
                
                3d = 0011
                inv(3) = 1100 = 12d
                
                 * End 4 bits
                 * 
                 */
                /* assign letters to sequence of bits
                 * 
                 * a = 0001 0001 0001
                 * b = 0001 0010 0001
                 */
                 
                 
             /*
              * 
              * where are bits inverted
              * 0001 1110
              *                  A    B   C    D   E    F   G  H
                char half[3] = { 000,001,010,100,111 ,110,101,011 }
                a // {*half1,*half1,*half1 }
                b // {*h1,*h2,*h1 } 
                c // {*h1,*h1,*h2} 
                d // {*h2,*h1,*h2} 
                e // {*h2,*h2,*h1} 
                 ... and so one
                 a[0] = *half1
                 */
             //   char half[4] =  { 'A','B','C','D'}; = 256 times (for 4 positions)
                

                
                
                // Arranjos com repetição => 3*3*3 => 27 combinações
                // Arep(2,3) = 2*2*2 = 2^3 = 8
                // 3 -> numero de posicoes
                // first 3 -> numero de digitos 
                // Arep(4,8) = 4^8 = 65535
                
                
                
               // char bitsToTest[8];
                // ASCFII VALUE C => 67
                // ASCII VALUE 0 => 48
                // ASCII VALUE 1 => 49
                
              
                
                /*
                 * 
                 * Option, use permutation instead of arrays assignment (arrays assingnments are faster)
               */ 
             /*  do {  // Must start at lowest permutation
                    printf("\n%s\n",cur);
                } while (nextPermutation(half,4));
                
              */  
               /* 
                * End Of option
                */
               
           /* 
                A = 00 0d    
                B = 01 1d
                C = 10 2d 
                D = 11 3d
                
                
                AAAA = 00 00 00 00
                AAAB = 00 00 00 01 (+1)
                AAAC = 00 00 00 10 (+2)
                AAAD = 00 00 00 11 (+3)
                
                
                
                (+4) = 00 00 00 00 
                              1 00  ADD
                       00 00 01 00  
                       A  A  B   A
                (+5) = 00 00 00 11
                              1 01 ADD
                       00 00 10 00 
                       A  A  C  A
                       
                       
                 Max value of summing on cycle    =  256
                2^8 = 256 numbers
                
                
                ascci value of c -> 67
                
                AR(4,3) = 4^3 = 64
                {a,b,c,d}
                
                2^6 = 64
                
               
                
            */    
             /*    bitsToTest[2] = 'A';

                 /* bitsToTest[1] = 'A'
                 bitsToTest[1] = 'B'
                 bitsToTest[1] = 'C'
                 bitsToTest[1] = 'D'
               
                 bitsToTest[0] = 'A'
                 bitsToTest[0] = 'B'
                 bitsToTest[0] = 'C'
                 bitsToTest[0] = 'D'
                 */  
                 char bitsToTest[3];
                  for (int timesFirst = 0; timesFirst < 3;timesFirst++) {
                      
                    bitsToTest[2] = 65+timesFirst;
                    
                    for (int idx = 0; idx < 3; idx++) {
                        bitsToTest[0] = 65+idx;
                        bitsToTest[1] = 65+idx;
                        bitsToTest[3] = '\0';
                        printf("\n%s ",bitsToTest);
                 }
                 
                  }

                 unsigned char positionArray[8] = {1,2,4,8,16,32,64,128};

              
                    // 8 bits ... have (1 bit | 3 bits | 1 bit | 3 bits)
                        
 
                           
                            
                         
                       
                       
                    

}
