
#include <stdio.h>

#define maxBytes 2
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


void printBits(unsigned char );
void printShortBits(unsigned short s);
void printLetters(char ,char);
//char nextPermutation(char * ,int);

/*
 * 
 * 
 * Next lexicographical permutation algorithm (C)
 * by Project Nayuki, 2017. Public domain.
 * https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */

/*char nextPermutation(char *array,int sizeOfArray) {
    // Find longest non-increasing suffix
    int i = sizeOfArray - 1;
    while (i > 0 && array[i - 1] >= array[i])
        i--;
    // Now i is the head index of the suffix
    
    // Are we at the last permutation already?
    if (i <= 0)
        return 0;
    
    // Let array[i - 1] be the pivot
    // Find rightmost element that exceeds the pivot
    int j = sizeOfArray - 1;
    while (array[j] <= array[i - 1])
        j--;
    // Now the value array[j] will become the new pivot
    // Assertion: j >= i
    
    // Swap the pivot with j
    int temp = array[i - 1];
    array[i - 1] = array[j];
    array[j] = temp;
    
    // Reverse the suffix
    j = sizeOfArray - 1;
    while (i < j) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
    }
    
    // Successfully computed the next permutation
    return 1;
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

      
/*                A = 01 1d
                B = 10 2d 
                C = 11 3d
                D = 00 0d
 */               
                

void printLetters(char value,char mask) {
    char t = value & mask;
    if ( t == 01)
    printf("A");
    else if(t== 10)
        printf("B");
    else if(t==11)
        printf("C");
    else
        printf("D");
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
             //   char half[4] =  { 'A','B','C','D'};
                

                                   
                
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
                
               /* do {  // Must start at lowest permutation
                    printf("\n%s\n",half);
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
                
            */    
                int idx = 0;
                char currentValue;
                int mask = 11;
                
                for (idx = 0 ; idx < 256 ; idx++) {
                    currentValue = 0 + idx;
                    printLetters(currentValue,00000011);
                    
                    printf("\n");
                }
                
                      /*
                 bitsToTest[0] = 'A'
                 bitsToTest[1] = 'A';   // A  A  A
                 bitsToTest[2] = 'A'; // 000 000 000
                 bitsToTest[3] = 
                                            // B A   A
                 bitsToTest[0] = 'B'; // 001 000 000
                                          //  C   A   A
                 bitsToTest[0] = 'C'; // 010 000 000
                 
                                          //  C   C   A
                 bitsToTest[1] = 'C'; // 010 001 000
                                          //  C   C   C
                 bitsToTest[2] = 'C'; // 001 001 001
                 
                 bitsToTest[0] = 'B'; // B C C 
                 
                 
                                          // C    B    B
                 bitsToTest[0] = half[2]; // 010 001 001
                                          // C    C   B
                 bitsToTest[1] = half[2]; // 010 010 001
                                          // C    C   C
                 bitsToTest[2] = half[2]; // 010 010 010
                 
                 */
                 unsigned char positionArray[8] = {1,2,4,8,16,32,64,128};

              
                    // 8 bits ... have (1 bit | 3 bits | 1 bit | 3 bits)
                        
 
                           
                            
                         
                       
                       
                    

}
