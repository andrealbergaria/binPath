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
void convertByteToAscii(unsigned char  , char);

// link with -lcrypt

/*
 * 
 * 
 * Why assigning one byte to letter doesnt works
 * 
 *  Byte1  Byte2  Byte3 Byte 4  (2^256  a lot of combinations...)
 *  256     256     256  256
 *
 * 4bits 4bits 4bits (2^4 16 possible combinations for letter) 
 */


void convertByteToAscii(unsigned char byte,char mask) {
    printf("\nBYTYE %c",byte);
    char bTemp = byte & mask;
    
    0x0f
    
    
    
    if (bTemp == 0b0000)
        printf("A");
    else if(bTemp == 0b0001 || bTemp == 0b00010000)
        printf("B");
    else if(bTemp == 0b0010 || bTemp == 0b00100000)
        printf("C");
    else if(bTemp == 0b0011 || bTemp == 0b01100000)
        printf("D");
    else if(bTemp ==0b00100 || bTemp == 0b00100000)
        printf("E");
    else if(bTemp == 0b0101 || bTemp == 0b01010000)
        printf("F");
    else if(bTemp == 0b0110 || bTemp == 0b01100000)
        printf("G");
    else if(bTemp == 0b0111 || bTemp == 0b01110000)
        printf("H");
    else if(bTemp == 0b1000 ||  bTemp == 0b1000000)
        printf("I");
    else if(bTemp == 0b1001 || bTemp == 0b10010000)
        printf("J");
    else if(bTemp == 0b1010 || bTemp == 0b10100000)
        printf("K");
    else if(bTemp == 0b1011 || bTemp == 0b10110000)
        printf("L");
    else if(bTemp == 0b1100 || bTemp == 0b11000000)
        printf("M");
    else if(bTemp == 0b1101 || bTemp == 0b11010000)
        printf("N");
    else if(bTemp == 0b1110 || bTemp == 0b11100000)
        printf("O");
    else if(bTemp == 0b1111 || bTemp == 0b11110000);
        printf("P");
    
    
    
}

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
   
   //printf("\n");
   
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
                 *  Trying to find seq of numbers not already taken
                 
                
                
                sequence of numbers not to be filled  a) 3,5,6,7
                12,10,9 => Numbers reverse from previous sequence a)
                
                3d = 0011
                inv(3) = 1100 = 12d
                
                 * End 4 bits
                 
                 */
                 
                 
             /*
              * 
              * where are bits inverted
              * 0001 1110
              *                  A    B   C    D   E    F   G  H
                char half[3] = { 000,001,010,100,111 ,110,101,011 }
                
                
                
                // Arep(2,3) = 2*2*2 = 2^3 = 8
                // 3 -> numero de posicoes
                // first 3 -> numero de digitos 
                // Arep(4,8) = 4^8 = 65535
                
                
                
                // ASCFII VALUE C => 67
                // ASCII VALUE 0 => 48
                // ASCII VALUE 1 => 49
                
              
                
                
                    
            
            /* 
            *   Using 4 bits per letter
            * 
            *   A A 
            *   A B ++
            *   A C ++
                A = 0000 0d    
                B = 0001 1d
                C = 0010 2d
                
                D = 0011 3d
                E = 0100 4d
                F = 0101 5d
                
                G = 0110 6d
                H = 0111 7d
                I = 1000 8d
                
                J = 1001 9d
                K = 1010 10d
                L = 1011 11d
                
                M = 1100 12
                N = 1101 13
                O =  1110 14
                P = 1111 15
                
                
              */
            char value = 0b11110000;
            char value2 = 0;
               // for (int i = 0 ; i < 16 ; i++) {
                    //printBits(value);
                    //printf("\n");
                    //printBits(value2);
          
                    convertByteToAscii(value,0xf0);
                //    printf("\n");
                 //   convertByteToAscii(value2,0xf0);
                 //   value++;
                //   value2 = value << 4;
                  
                    
              //  }
                
           /*  
                digits = 15
                pos = 2
                 
                 
                Ar(15,2) =  15 ^ 2 = 225
                2^8 = 256
                
                       

        
        (8,2) = 8*8 = 64
        
       */
        
                
                  
                
           }
