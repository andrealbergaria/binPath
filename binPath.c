
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
char nextPermutation(char * ,int);

/*
 * 
 * 
 * Next lexicographical permutation algorithm (C)
 * by Project Nayuki, 2017. Public domain.
 * https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */

char nextPermutation(char *array,int sizeOfArray) {
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
                 * 
                 * For 4 bits
                 */
                
                0000
                0001
                0010
                0100
                1000

                /*
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
                //char half[8] =  { 'A','B','C','D','E','F','G','H'};
                char half[] =  { 'A','B','C' };
                                   
                
                // Arranjos com repetição => 3*3*3 => 27 combinações
                // Arep(2,3) = 2*2*2 = 2^3 = 8
                // 3 -> numero de posicoes
                // first 3 -> numero de digitos 
                // Arep(3,3) = 3*3*3 = 27
                
                // Get integer from string, and then increment it
                char bitsToTest[3];
                // ASCFII VALUE C => 67
                // ASCII VALUE 0 => 48
                // ASCII VALUE 1 => 49
                // ASCCI VALUE OF BEFORE A  => 64 (used to get numbers from string)
              
                 //int[] array = {0, 1, 1, 1, 4};
                
                do {  // Must start at lowest permutation
                    printf("\n%s\n",half);
                } while (nextPermutation(half,3));

                
                
                
                /* bitsToTest[0] = half[0];
                 bitsToTest[1] = half[0];   // A  A  A
                 bitsToTest[2] = half[0]; // 000 000 000
                                            // B A   A
                 bitsToTest[0] = half[1]; // 001 000 000
                                          //  C   A   A
                 bitsToTest[0] = half[2]; // 010 000 000
                 
                                          //  C   C   A
                 bitsToTest[1] = half[3]; // 010 001 000
                                          //  C   C   C
                 bitsToTest[2] = half[3]; // 001 001 001
                 
                 bitsToTest[0] = half[2]; // B C C 
                 
                 
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
