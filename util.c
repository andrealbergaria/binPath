#include "util.h"
#include <time.h>




// check how three positions work (using getAllCombs_256bits()
void TestPositions() {
    unsigned char a[] = {'0','1','2','3','4','5','6','7','8'};
    unsigned char b[] = {'0','1','2','3','4','5','6','7','8'};
    unsigned char c[] = {'0','1','2','3','4','5','6','7','8'};
    
            
}
/*
 *
 * table.bin
 *   
                                 Pos 1 = ,0,1,9,17,25,33,41,49,57,65,73,81,89,97,105
                                 
                                 Pos 2 = ,0,2,10,18,26,34,42,50,58,66,74,82,90,98,106 (all evens)
                                 
                                 Pos 3 = ,0,3,11,19,27,35,43,51,59,67,75,83,91,99,107,115,123,
                                 
                                 Pos 4 = ,0,4,12,20,28,36,44,52,60,68,76,84,92,100,108,116
                                   
                                 Pos 5 = ,0,5,13,21,29,37,45,53,61,69,77,85,93,101,109,117
                                 
                                 Pos 6 = ,0,6,14,22,30,38,46,54,62,70,78,86,94,102,110,118
                                
                                 Pos 7 = ,0,7,15,23,31,39,47,55,63,71,79,87,95,103,111,119,
                                 
                                 Pos 8 = ,0,8,16,24,32,40,48,56,64,72,80,88,96,104,112,120,128,136
*/

//POS 1 POS 2 POS 3       POS 1 POS 2 POS 3


//0,1,9,17,25,33        0,1,9,17,25,33

void TestIteration() {
    
    // Populate array (populate 1 byte)
    u_char arr[] =  {1,2,3,4,5,6,7,8};

    
    for (int idx=0; idx < 4; idx++) {
        for (int i = 1 ; i < 32; i++) {
            arr[0] += 8;
            arr[1] += 8;
            arr[2] += 8;
            arr[3] += 8;
            arr[4] += 8;
            arr[5] += 8;
            arr[6] += 8;
            arr[7] += 8;
            printf("\n[%i] %i %i %i %i %i %i %i ",idx,arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]);
        }
    }
}
 
 
    

    
// table.bin
void printPositions() {
    
    int pos1 = 1;
    int pos2 = 2;
    int pos3 = 3;
    int pos4 = 4;
    int pos5 = 5;
    int pos6 = 6;
    int pos7 = 7;
    int pos8 = 8;
    printf("\nPosition 1: ");
    for (int i=0; i < 31; i++) {
        pos1+=8;
        printf(" %i,",pos1);
    }
    printf("\nPosition 2: ");
    for (int i=0 ; i < 31;i++) {
           pos2+=8;
           printf(" %i,",pos2);
     
    }
    printf("\nPosition 3: ");
    for (int i=0 ; i < 31;i++) {
           pos3+=8;
           printf(" %i,",pos3);
    }
    
    printf("\nPosition 4: ");
    for (int i=0 ; i < 31;i++) {
           pos4+=8;
           printf(" %i,",pos4);
     
    }
    printf("\nPosition 5: ");
    for (int i=0 ; i < 31;i++) {
           pos5+=8;
           printf(" %i,",pos5);
    }
    
    printf("\nPosition 6: ");
    for (int i=0 ; i < 31;i++) {
           pos6+=8;
           printf(" %i,",pos6);
    }
    printf("\nPosition 7: ");
    for (int i=0 ; i < 31;i++) {
           pos7+=8;
           printf(" %i,",pos7);
    }
    printf("\nPosition 8: ");
    for (int i=0 ; i < 31;i++) {
           pos8+=8;
           printf(" %i,",pos8);
    }
}


void getAllCombs_256bits() {
    // eachs char varaible represent one byte of int
            unsigned char a[] = {'0','1','2','3','4','5','6','7','8'};
            unsigned char b[] = {'0','1','2','3','4','5','6','7','8'};
            unsigned char c[] = {'0','1','2','3','4','5','6','7','8'};
            unsigned char d[] = {'0','1','2','3','4','5','6','7','8'};
            unsigned char indx[numOfRows][4];
            unsigned int it = 0;

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
                                        //(1,1,1,1)
                                        printf("\n { '%c','%c','%c','%c' }",a[i],b[i2],c[i3],d[i4]);
                                          if (a[i] == '1') {
                                              it++;
                                          }
                                        
                                    }
                                }
                                
                            }
                        }

                }
                printf("\nTotal iterations : %i",total_iterations);
                printf("\nOneElement (first 1) iterations %i",it);
                
}

// array has ->  posToColumn[8][8*32];

void launchProg() {
    TestIteration();
}


char check32Bytes() {
    
   // getAllCombs_256bits();
	//testingArray();
        /*
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
          */

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
                                 Pos 1 = ,0,1,9,17,25,33,41,49,57,65,73,81,89,97,105
                                 
                                 Pos 2 = ,0,2,10,18,26,34,42,50,58,66,74,82,90,98,106 (all evens)
                                 
                                 Pos 3 = ,0,3,11,19,27,35,43,51,59,67,75,83,91,99,107,115,123,
                                 
                                 Pos 4 = ,0,4,12,20,28,36,44,52,60,68,76,84,92,100,108,116
                                   
                                 Pos 5 = ,0,5,13,21,29,37,45,53,61,69,77,85,93,101,109,117
                                 
                                 Pos 6 = ,0,6,14,22,30,38,46,54,62,70,78,86,94,102,110,118
                                
                                 Pos 7 = ,0,7,15,23,31,39,47,55,63,71,79,87,95,103,111,119,
                                 
                                 Pos 8 = ,0,8,16,24,32,40,48,56,64,72,80,88,96,104,112,120,128,136
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

