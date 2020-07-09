
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



void printBin(unsigned int n) {
    
    int it = 0;
    while (it < 32) {
        
    if(n&1) 
        printf("1");
    else 
        printf("0");
    n = n >> 1;
    it++;
    }
}    

int main() {
                 
                 
                 unsigned char firstHalf[4];  
                 unsigned char secondHalf[4]; 
                 
                                     
                 firstHalf[0] =  0;
                 firstHalf[1] = 0x1;
                 firstHalf[2] = 0x2;
                 firstHalf[3] = 0x4;
                 
                 secondHalf[0] = 1;
                 secondHalf[1] = 0xFE;
                 secondHalf[2] = 0xFD;
                 secondHalf[3] = 0xFC;
                 
                 
                 // cycle iterator
                 int iterator;
                
                  
                  // remains here because its a possibly solution
                  // unsigned char zero[3] = {firstHalf[0],firstHalf[0],firstHalf[0]}
                    
                                            
                                       
                  
                    //one possibility is too assign four pointers to a firstHal, and then dereference them when needed (like for instance , where 0 0 (hence derefence on the second 0)
                                            
               // another possibily it to use the operator ++ or bit shift, so
                                            //{ 00000000,00000001}
                                            // { 00000000,0000001}  ++ or <<
                                            
                                            
                 // 1st solution : assign to ,for example 0, 0= a;0 = b, 0=c , where a,b,c are bytes
                 // Then, use the 00000001. In this case, the zero must substitute the bytes.
                 
                 // 2nd solultion : etither add or bit shift, the entire stream of bytes
                 // In this case , i have byte[] = {00000000,00000001} , and then bit shift one possition (or add a bit)
                 // After , do the same for byte[] = {11111111,111111}. Hence we get all bytes.
                 
                 // 3rd solution, assign the number 0 or 1 a set...like for example 0=[1,2,3];
                 // in the case of 11111 works ok, but if 0000, tends to a bit of changes
                 
                 //4rd solution 
                 //Each shift represents a changing position
                 // So 
                 
                for (iterator = 1 ; iterator < 2; iterator++ ) {
                       zero[iterator-1] = 0;
                       zero[iterator] = 
                 
                 }
                 
                 // O algoritmo para 3 bytes é
                 //assign 00000000 = [1,2,3]
                 // assign 00000001 = {1,3,2]
                 // assign 00000010 = {2,1,3] mudanca relativa a [1,2,3] ou seja 00000000
                 // assign 00000100 = [3,2,1]
                 // if it was binary code, then we would make a shift, in thise case we change pos
                 
                 8 shifts, 8 positions, 
                 8 shifts , 8 positions (comecando no 11111111)
                 1 shifts = troca o ordem (posicaoo) entre 000000001 = 1  
                                                           000000010 = 2

                2nd shift = 00000010    =2 
                            00000100    =4
                            
                            // um shift aumenta a posicao por 1
                            shift = posicao+1;
                // trying three bytes
                [1,1,1]  
                // What changes in between [], is the position
                [3,1,1] -> 00000001 , pos(0),pos(1),pos(2)
                [1,3,1] -> 00000010
                [1,1,3] -> 00000100
                
                [2,1,1] -> 00001000 , pos(0),pos(1),pos(2)
                [1,2,1] -> 00010000
                [1,1,2] -> 00100000
                
                [2,2,2] -> 01000000
              
                [1,2,2] -> pos(0),pos(1),pos(2)
                [2,1,2]
                [2,2,1]
                
                [3,3,3]
                
                [1,3,3]
                [3,1,3]
                [3,3,1]
                
                [2,3,3]
                [3,2,3] -> pos(0),pos(1),pos(2)
                [3,3,2]
                
                
                
                
                
                // 2nd byte
                [1,1]
                [1,2]
                [1,3]
                [2,1]
                [3,1]
                [2,2]
                [2,1]
                [3,1]
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 [1,1,1]        00000000 
                 [3,1,1]        00000001 pos(0)
                 [1,3,1]        00000010 pos(1)
                 [1,1,3]        00000100 pos(2);
                 
                 [2,1,1]        00001000 pos(3);
                 [1,2,1]        00010000 pos(4);
                 [1,1,2]        00100000 pos(5);
                                01000000 pos(6);
                                10000000 pos(7)
                                         
                                         
                                         
                                         
                                         cada bit shift , transforma 
                                        (00000000 -> 00000001) pos_do_bit1(0)
                                           0     -> 1
                                          00000000 -> 00000010 pos_do_bit1(1)
                                            0     -> 2
                                            
                                            1 2 4 8
                 [1,2,2]
                 [1,2,3]
                 [1,3,3]
                 
                 [1,3,2]
                 [
                 
                for (iterator = 0 ; iterator < 2; iterator++) {
                    
                }
                      
                      
                      
                      
                      
                        
                  }
                  
                  
                  
                 
                 // 3rd bytes
                 
                 
                 // 3rd bytes
                 char threeBytes_firstHalf[4];
                 char threeBytes_secondHalf[4];
                 
                 for (iterator=0 ; iterator < 3; iterator++) {
                     threeBytes_firstHalf[iterator] = firstHalf(iterator);
                     threeBytes_secondHalf[iterator] = secondHalf(iterator);
                 }
                 
                 
                
               // thing is, use the algorithm on a binary string like 0b1010101111100 (always bit shift 1)
                
}
