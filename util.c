#include "util.h"
#include <time.h>

void assignArray(unsigned char positionToColumn[numPositions][numOfRows]) {

        for (int pos=0 ; pos < 7 ; pos++) {
            positionToColumn[pos][0] = 0;
            for (int i=1 ; i <= numOfRows; i++) {

                positionToColumn[pos][i] += 8;
                positionToColumn[pos][i] += pos;

               // printf("\nPOsitio co colm %i",positionToColumn[pos][i]);
           // printf("\n\t\t\t %i ",i);
               // printf("\nPOS TO COLUM %i %i",pos,i);
               // printf("\nPosToColum[%i][%i] = %i ",pos,i,positionToColumn[pos][i]);
            }


      }


}
// Obtain all possible indexes on a  Array of '1'
// If (1,0,0,0) then array[0]
/*
 *  (0,0,0,0)
 * 	(0,0,0,1)   base   (index 4) place=4
 * 	(0,0,1,0)	base[3] = base[0] (copia 4 para index anterior , tipo array[curPlace] =array[place]
 * 	(0,1,0,0)   base[4] =
 *
 * 	(1,1,0,0)
 *
 * 	Permutations of '1' on 4 digits
 *
 */
void getAllCombs_256bits() {
    // eachs char varaible represent one byte of int
            unsigned char a[] = {'0','1','2','3','4','5','6','7','8'};
            unsigned char b[] = {'0','1','2','3','4','5','6','7','8'};
            unsigned char c[] = {'0','1','2','3','4','5','6','7','8'};
            unsigned char d[] = {'0','1','2','3','4','5','6','7','8'};
            unsigned char indx[numOfRows][4];


            int total_iterations= 0 ;
            for (int pos=1 ; pos < 9; pos++) {
                        total_iterations++;
                        
                        for (int i=1 ; i < 9 ; i++) {
                            total_iterations++;

                            for (int i2=1; i2 < 9; i2++) {
                                total_iterations++;
                                for (int i3=1 ; i3 < 9;i3++) {
                                    total_iterations++;
                                    for (int i4=1; i4 < 9 ; i4++) {
                                        total_iterations++;
                                        printf("\n(%c,%c,%c,%c)",a[i],b[i2],c[i3],d[i4]);
                                        if (a[i] == '1') {
                                        	printf(" Index of 1 : %i");

                                        }
                                        
                                    }
                                }
                                
                            }
                        }

                }
                printf("\nTotal iterations : %i",total_iterations);
}

// array has ->  posToColumn[8][8*32];




char check32Bytes() {
    
    getAllCombs_256bits();
        
   unsigned char positionToColumn[numPositions][numOfRows];
    assignArray(positionToColumn);
    
    for (int pos=0 ; pos < 7 ; pos++) {
                positionToColumn[pos][0] = 0;
                for (int i=1 ; i <= numOfRows; i++) {
                	if (positionToColumn[pos][i] == '1') {
                		printf("\nArray[%i][%i] == 1",pos,i);
                	}


                   printf("\nPosToColum[%i][%i] = %i ",pos,i,positionToColumn[pos][i]);
                }


          }

    // 256 bits , em bytes são 32
   // 32 bytes / 4 bytes (size of int) = 8
    //64 bits * 4  = 256 ..

     // int a[3][4] = {  
//   {0, 1, 2, 3} ,   /*  initializers for row indexed by 0 */
//   {4, 5, 6, 7} ,   /*  initializers for row indexed by 1 */
 //  {8, 9, 10, 11}   /*  initializers for row indexed by 2 */
// };


       
    // Function for getting chars
    // f(pos) = 8k+pos
     
                    
                        
      //32 bytes need need 8 ints

    // 8*32 = 256  (one byte, combinations)
   // 8* 8192  = 65536 (two bytes,combinations)
   // 8* 536870912  = 4294967296 (4bytes , combs)


          // FROM https://stackoverflow.com/questions/34357968/how-to-set-first-three-bytes-of-integer-in-c
          /*int a = 4294967233;
                char* p=&a;
  
                p[0] = whatever you wanted there
                p[1] = whatever you wanted there

          


      double res;  %f
        int *currentByte = &res;
*/

             

            /*unsigned int  a = (array_base[1] & 0xff000000) >>24;
             unsigned int b = (array_base[1] & 0x00ff0000) >>16;
             unsigned int c = (array_base[1] & 0x0000ff00) >>8;
             unsigned int d = (array_base[1] & 0x000000ff) ;
             
             printf(" %u %u %u %u ",a,b,c,d);
             */
      
        //    unsigned int array_base[8] = {0x00010203,0x04050607,0x08090A0B,0xC0D0E0F};
        //    unsigned int mask_add_8 =    0x08080808;
        //    printf("\n");
        //    char *ptr = (char *) &array_base[0];
            
            // INT COMBS : 4294967296
            
            
             // 8 bytes -> 
            
            //trying with 256
            //int test = 536870912;
          //  unsigned int pos = 1;
            // 4294967296/8 = 536870912;
            // 
            // Number of combinations 
            
            int numberOfCombinations = 0;
            
            
            //clock_t start = clock();
            
            //unsigned long // 8 bytes  +  18,446,744,073,709,551,615] 
            
               
           /*
            printf("\nNumber of combinations : %i\n", numberOfCombinations );
            array_base[0] += mask_add_8;
            array_base[1] += mask_add_8;
            array_base[2] += mask_add_8;
            array_base[3] += mask_add_8;
            numberOfCombinations+=4;
            if (numberOfCombinations % 10000 == 0)
                printf("\nChecked %i",numberOfCombinations);
            
            }
            clock_t end = clock();
            clock_t total_t = (double)(end - start) / CLOCKS_PER_SEC;
            printf("\nTotal secs : %f\n",total_t);
             
    //     }
         */
            // INT COMBS : 4294967296


// end of function      
    
}      
     
   



void printUsingFunction() {
    
    
    // look at function .. f(pos) = 8*i + pos
    // int combinations 4294967296
    // 
     unsigned int t=0;
     for (int pos = 1; pos < 9;pos++) {
        //printf("\nPos %i = ",pos);
            // 8*32 = 256  (one byte, combinations)
            // 8* 8192  = 65536 (two bytes,combinations)
            // 8* 536870912  = 4294967296 (4bytes , combs)
        for (int it= 0; it <= 8192; it++) {
            //printf(",%u",t);
            t = 8*it+pos;
            
            if (t % 256 == 0) 
                printf("\n%u",t);
           
          /*  if (t % 2 == 0)
                printf(" even ");
            else
                printf(" odd ");
            */
            
         }
        t=0;
     }
    
        
}



void printAllCombinations(int numberOfBits,int startByte) {
    printf("\nUsing %i bits\n",numberOfBits);
    //unsigned int startByte = pow(2,onlyListNumberWithBits-1);
    printf("\nStarted printing at %i",startByte);
    int s = pow(2,numberOfBits);
    printf("\nNumber of elems printed %i",s);
    printf("\n{ ");
    for (int i = 0; i< s ; i++) {
        printBits(startByte);
        printf(" , ");
        startByte++;
    }
    printf(" } \n");
}

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
    printf(" (%i)\t",number);
   

   
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
   
   printf("\t%i",number);
   
}


void printIntBits(unsigned int number) {
   unsigned int mask = 0x80000000;
   int it;
   
   for (it=0 ;it < 32; it++) {
       if (it % 8 == 0)
           printf(" ");
       if (number & mask)
           putchar('1');
       else
           putchar('0');
      
       mask >>= 1;
   }
   
    printf("\t%u\n",number);
   
}


void convertByteToAscii(unsigned char byte,char mask) {
    
    
  
    
    
    unsigned char bTemp = byte & mask;
    
    if (bTemp == 0 )
        printf("A");
    else if(bTemp == 0b0001 || bTemp == 0b00010000)
        printf("B");
    else if(bTemp == 0b0010 || bTemp == 0b00100000)
        printf("C");
    else if(bTemp == 0b0011 || bTemp == 0b00110000)
        printf("D");
    else if(bTemp == 0b0100 || bTemp == 0b01000000)
        printf("E");
    else if(bTemp == 0b0101 || bTemp == 0b01010000)
        printf("F");
    else if(bTemp == 0b0110 || bTemp == 0b01100000)
        printf("G");
    else if(bTemp == 0b0111 || bTemp == 0b01110000)
        printf("H");
    else if(bTemp == 0b1000 || bTemp == 0b10000000)
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
    else if(bTemp == 0b1111 || bTemp == 0b11110000)
        printf("P");
    

    
}

