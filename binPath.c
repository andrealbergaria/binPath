#include <stdbool.h>
#include <stddef.h>
#include <stdio.h>
#include <unistd.h>
#include <crypt.h>
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
char *hashit(char *);
char *getSalt(char *salt);

// link with -lcrypt


char *getSalt(char *salt) {
    
    return 0;
}

char* 
hashit (char *numToHash)
{
  unsigned char ubytes[16];
  char salt[20];
  const char *const saltchars =
    "./0123456789ABCDEFGHIJKLMNOPQRST"
    "UVWXYZabcdefghijklmnopqrstuvwxyz";
  static char *hash;
  int i;

  /* Use them to fill in the salt string. */
  salt[0] = '$';
  salt[1] = '5'; /* SHA-256 */
  salt[2] = '$';
  for (i = 0; i < 16; i++)
    salt[3+i] = saltchars[ubytes[i] & 0x3f];
  salt[3+i] = '\0';

  /* Read in the user’s passphrase and hash it. */
  hash = crypt (numToHash, salt);
  if (!hash || hash[0] == '*')
    {
      perror ("crypt");
      return 1;
    }

  /* Print the results. */
  
  printf("\nHASH : %s",hash);
  return hash;
}

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

          

/* void printBinary(int num) {
    
    if (num == 2)
        printf("\nB");
    
    for (int idx = 0; idx < sizeOfArray; idx++) {
        if (array[idx] == 'A')
            printf("00000000");
        else if(array[idx] == 'B')
            printf("00000001");
        else if(array[idx] == 'C')
            printf("10");
        else 
            printf("11");
     
    }
}
*/
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
                
                
                /*'A'
                 * 
                 * For 4 bits
                 
               /* a)
                0000
                0001 // 1
                0010 // 2
                0100 // 4       => number = 2^x
                1000 // 8'A'

                /*
                 * 
                 *  Trying to find seq of numbers not already taken
                 
                
                
                sequence of numbers not to be filled  a) 3,5,6,7
                12,10,9 => Numbers reverse from previous sequence a)
                
                3d = 0011
                inv(3) = 1100 = 12d
                
                 * End 4 bits
                 * 'A'
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
                
                
                
                // ASCFII VALUE C => 67
                // ASCII VALUE 0 => 48
                // ASCII VALUE 1 => 49
                
              
                
                /*char letters[] = {'A','A','A', \
                                  'A','A','A', \
                                  'A','A','A', \
                                  'A','A','A', \
                                  'A','A','A', \
                                  'A'};
                                  */
                // salt 20 bytes
                
                    
            
            /* 
            *   Using 4 bits per letter
            * 
            *   A A 
            *   A B ++
            *   A C ++
                A = 0000 0000 0d    0000 0000 
                B = 0000 0001 1d
                C = 0000 0010 2d
                
                D = 0000 0100 4d
                E = 0000 1000 8d
                F = 0000 1001 9d
                
                G = 0000 1010 10d
                H = 0000 1011 11d
                I = 0000 1100 12d
                
                J = 0000 1101 13d
                K = 0000 1110 14d
                L = 0000 1111 15
                M = 
                
                a
                a++ => b
                
                255 sums
                
               ( ,8
                
                AA= 00 00 00 00
                AB = 00 00 00 01 (+1)
                AC = 00 00 00 10 (+2)
                AD = 00 00 00 11 (+3)
                
                digits = 15
                pos = 2
                 
                 O = 0000 0d
                 P = 0001 1d
                 Q = 0010 2d
                 R = 0100 3d
                 
                 int firstByte = A
                 int seconbyte++;dByte = A
                 
                 
                 firstByte; // 0000 0000
                 secondByte = secondByte ++
                 
                 
                 
                 
                 
                Ar(15,2) =  15 ^ 2 = 225
                each letter -> 15
                2^8 = 256
                
               char bitsToTest[] = { 'A','A' };
                              // 8bits 8 bits 
                  char salt[] = { 'A','A','\0' }; 
                  char firstLetter = 'A';
                  
                  bitsToTest[0] = 'A';
                  bitsToTest[1] = 'A';
                
                 if (num == 2)
                    printf("\nB");
    
                 
                 num 2 => 0000 0001  1st byte
                 num 3 => 0000 0010  2st byte
                 num 4 => 0000 0100  3st byte
                 
             */        
            // letters of bytes is the number they represent
            // print number as printg letters;
            
       /*     1 -> 0000
            A -> 0000
            
            A        A 
        00000000  00000000
           0         0 
        0000000   00000000 
        
            A     B 
        00000000 000000001
            0    0+1
        00000000 00000000
       */
        
                //unsigned char bytes[3] = { 0 , 0 , '\0' };
               /*
                *
                *
                *
                * 2 bytes scan
                * 
                * 
                */
                int casa_2=0;
                int casa_1=0;
                  for (int num1=0; num1 < 32 ;num1++) {
                        
                      
                      for (int i = 0; i < 32; i++) {
                          //printf("\n1st Bytes: %i",casa_1);
                         // printf("\n2st Byte : %i",casa_2);
                          
                          printShortBits(casa_1);
                          printShortBits(casa_2);
                          casa_2 = casa_2+1;
                          
                      }
                casa_1++;
                
                  }
                     
                 /*
                  *
                  * 4 bytes scan
                  *
                  *    
               /*   
                 casa_1 = 0;
                 casa_2 = 0;
                 int casa_3=0;
                 int casa_4 = 0;
                 
                 for (int n1 =0 ;  n1 < 
                     for
                         for 
                             for
               
                    printf("\n%s ",bitsToTest);
                    // First letter ++ 
                    bitsToTest[1]++;  // 
                    printLetters(bitsToTest);
                    
                    if (bitsToTest[1] == 'L')
                        bitsToTest[1] = 'A';
                    else 
                        bitsToTest[1]++;
                        
                    if (timesFirst % 16 == 0)
                       firstLetter++;
                   
                    }
                    
                    */
                    
                        
                  
                
                    
                unsigned char positionArray[8] = {1,2,4,8,16,32,64,128};

              
                    // 8 bits ... have (1 bit | 3 bits | 1 bit | 3 bits)
                        
    
                       
                    

}
