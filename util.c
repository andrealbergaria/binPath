#include "util.h"
#include <time.h>




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

// if postiion is 3, then get all combs from 3 and assign everywhere

//we can mix like "('1','2','1','2');

// { 1 , 3,  1 , 3}



//char positions[] = { *ptr1 , *ptr2 , Ptr3 ,*ptr4


// return the numbers on the specified position
void assignArrayToPosition(int *array,int sizeOfArr,int pos) {
    
    
    for (int it= 0; it < sizeOfArr; it++) 
        array[it] = 8*it+pos;
    
}

void TestIteration() {
    
    // Populate array (populate 1 byte)
    u_char arr[] =  {1,2,3,4,5,6,7,8};
    u_char arrTemp[] = {1,2,3,4,5,6,7,8};
    
        //{ 1 , 2 , 3 , 4 ,5, 6, ,7,8}
       // 1byte               2byte           3byte
       // {1,2,3,4,5,6,7,8} {1,2,3,4,5,6,7,8} {1,2,3,4,5,6,7,8}            
        
        for (int pos=0; pos < 8; pos++) {
            
            for (int i = 0 ; i < 32; i++) {
                arr[0] += 8;
                arr[1] += 8;
                arr[2] += 8;
                arr[3] += 8;
                arr[4] += 8;
                arr[5] += 8;
                arr[6] += 8;
                arr[7] += 8;
           
        }
        memcpy(arr,arrTemp,8);
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

void trying8Elems() {
    unsigned char a[] = {'1','2','3','4','5','6','7','8'};
    unsigned char b[] = {'1','2','3','4','5','6','7','8'};
    unsigned char c[] = {'1','2','3','4','5','6','7','8'};
    unsigned char d[] = {'1','2','3','4','5','6','7','8'};
    unsigned char e[] = {'1','2','3','4','5','6','7','8'};
    unsigned char f[] = {'1','2','3','4','5','6','7','8'};
    unsigned char g[] = {'1','2','3','4','5','6','7','8'};
    unsigned char h[] = {'1','2','3','4','5','6','7','8'};
    
    
    int numOfBytes=0;
    int total_iterations= 0 ;
    
    for (int i1=0 ; i1 < 8; i1++) {
        total_iterations++;
        
        for (int i2=0 ; i2 < 8 ; i2++) {
            total_iterations++;
            
            for (int i3=0 ; i3 < 8 ; i3++) {
                total_iterations++;
                
                for (int i4=0 ; i4 < 8; i4++) {
                    total_iterations++;
                    
                    for (int i5=0 ; i5 < 8 ; i5++) {
                        total_iterations++;
                        numOfBytes++;
                        
                        for (int i6=0 ; i6 < 8 ; i6++) {
                            total_iterations++;
                            for (int i7=0 ; i7 < 8; i7++) {
                                total_iterations++;
                                for (int i8=0 ; i8 < 8; i8++) {
                                    total_iterations++;
                                    printf("\n { '%c','%c','%c' , '%c', '%c' ,'%c' , '%c','%c' }    it (%i)",a[i1],b[i2],c[i3],d[i4],e[i5],f[i6],g[i7],h[i8],total_iterations);        
                                }
                                printf("\n---byte Mark");
                            }
                            
                        }
                     
                    }
                }
            }
        }
    }
    printf("\nTotal iterations : %i",total_iterations);
    printf("\nNum of Bytes scanned : %i",numOfBytes);
}


void printTemplate(u_char toTest) {
            unsigned char a[] = {'1','2','3','4','5','6','7','8'};
            unsigned char b[] = {'1','2','3','4','5','6','7','8'};
            unsigned char c[] = {'1','2','3','4','5','6','7','8'};
            unsigned char d[] = {'1','2','3','4','5','6','7','8'};
            // going for 4 bytes
            // Portanto os templates sao todosd os posisveis dum numero
            //o numero pnao pode estar contido noutro sitio (indicado pleos zeros)
            
            
            
      /*      template(where is located 1 for example? perhaps use 3bit algorithm?

            
               //n -> Número de elementos do conjunto.
    //p -> Quantidade de elementos por agrupamento
    //Arranjos = pow(n,p);
  //  n=8, p=4 = 4096
            
            number = 1 ;{1,1,1,1}
            number = 2 {1,1,1,1}} 
            for isntance        { 8,6,2,1}
                                                    
                                                    
            // Todas as possiveis combinaçoes de 1 cobertas...as outras opdem ser {2-> 8)
            it2 => [1,1,1,0
                    1,1,1,0}
            // Todas as possiveis combinaçoes de 2 cobertas...as outras opdem ser {2-> 8)
            
            [ 1,1,1,1 ]
            [ 1,1,1,0 ]  || equal to below
            [ 1,1,1,0 ] 
            [ 1,1,1,0 ]
            [ 1,1,1,0 ]
            [ 1,1,1,0 ]
            [ 1,1,1,0 ]
            [ 1,1,0,0 ]
            [ 1,1,0,0 ]
            [ 1,1,0,0 ]
            [ 1,1,0,0
        */    
            
            printf("\nTemplate of %c",toTest);
                int total_iterations= 0 ;
                        
                        for (int i=0 ; i < 8 ; i++) {
                            total_iterations++;

                            for (int i2=0; i2 < 8; i2++) {
                                total_iterations++;
                                for (int i3=0 ; i3 < 8;i3++) {
                                    total_iterations++;
                                    for (int i4=0; i4 < 8 ; i4++) {
                                        total_iterations++;
                                         printf("\n { '%c','%c','%c','%c' }",a[i],b[i2],c[i3],d[i4]);
                                        if (a[i] == toTest || b[i2] == toTest || c[i3] == toTest || d[i4] == toTest ) {
                                            // show only those that have '0'
                                          if (a[i] == toTest || b[i2] == toTest || c[i3] == toTest || d[i4] == toTest ) {
                                            // show only those that have '0'
                                            
                                            for (int i =0 ; i < 4; i++) {
                                                if (a[i] ==toTest)
                                                    printf("{ 1,");
                                                else
                                                    printf("{ 0,");
                                                if (b[i2] == toTest)
                                                    printf("1,");
                                                else
                                                    printf("{ 0,");
                                                
                                                if (c[i3] == toTest)
                                                    printf("1,");
                                                else
                                                    printf("{ 0,");
                                                
                                                if (d[i4] == toTest)
                                                    printf("1, ");
                                                else
                                                    printf("{ 0,");
                                                
                                            }
                                                
                                            
                                            
                                        }
                                        
                                        
                                    }
                                }
                                
                            }
                }
                printf("\nTotal iterations : %i",total_iterations);
    
    
}




void getAllCombinations() {
    //n -> Número de elementos do conjunto.
    //p -> Quantidade de elementos por agrupamento
    //Arranjos = pow(n,p);
  //  n=8, p=4 = 4096
    
            unsigned char a[] = {'1','2','3','4','5','6','7','8'};
            unsigned char b[] = {'1','2','3','4','5','6','7','8'};
            unsigned char c[] = {'1','2','3','4','5','6','7','8'};
            unsigned char d[] = {'1','2','3','4','5','6','7','8'};
            
                int total_iterations= 0 ;
                        
                        for (int i=0 ; i < 8 ; i++) {
                            total_iterations++;

                            for (int i2=0; i2 < 8; i2++) {
                                total_iterations++;
                                for (int i3=0 ; i3 < 8;i3++) {
                                    total_iterations++;
                                    for (int i4=0; i4 < 8 ; i4++) {
                                        total_iterations++;
                                        //(1,1,1,1)
                                        //show all 
                                         printf("\n { '%c','%c','%c','%c' }",a[i],b[i2],c[i3],d[i4]);
                                        
                                            
                                        }
                                        
                                        
                                        
                                    }
                                }
                                
                            }
                }
                printf("\nTotal iterations : %i",total_iterations);

}


void launchProg() {
   // TestIteration();
   // printAllCombinations();
   // getAllCombs_256bits();
   // printTemplate('2');
    //getAllCombs_3_elems();
    trying8Elems();

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

