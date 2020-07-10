
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
                    
                                            
                                       
                  
                  
                                            
               // another possibily it to use the operator ++ or bit shift, so
                                            //{ 00000000,00000001}
                                            // { 00000000,0000001}  ++ or <<
                                            
                                            
                 // 1st solution : assign to ,for example 0, 0= a;0 = b, 0=c , where a,b,c are bytes
                 // Then, use the 00000001. In this case, the zero must substitute the bytes.
                 
                 // 2nd solultion : etither add or bit shift, the entire stream of bytes
                 // In this case , i have byte[] = {00000000,00000001} , and then bit shift one possition (or add a bit)
                 // After , do the same for byte[] = {11111111,111111}. Hence we get all bytes.
                 
                 // 3rd solution, assign the number 0 or 1 a set...like for example 0=[1,2,3];
                 // in the case of 11111 works ok, but if 0000, tends to a bit of changes, suggest inverse all bits,
                 // but in this case,  (from 11111 to 00000), how can one invert a set?
                 
                 //4rd solution 
                 //Each shift represents a changing position
                 // So 
                  
                    
                 
                 // 5th solution
                 //  Assign binary digits (0 or 1) to all variables (like a=0 , b =1 , and a=1 and c=0), and 
                 
                 // perhaps instead of 1 shift do 8 buits shift or 16
                 
                 
                   // 6st solution one possibility is too assign four pointers to a firstHal, and then dereference them when needed (like for instance , where 0 0 (hence derefence on the second 0)
                 
                 
                 //7 solution
                 // each bit indicates if the character is present on the number
                 // so for instance (abc = 111
                 //a=1
                 //b=1
                 //c=1
                 // for b=0 , 101
                 
                 //8 solution
                 // for each bit , there is a change in the set. position or substituing
                 
                 // [0,1,2]
                 // [0,0,1] => [0,1,2]
                 // [0,0,1] => [0,1,1]
                 // [0,0,1] => [0,1,0]
                 
                 /*   [1,0,0] => [1,1,2]
                    [1,0,0] => [2,1,2]
                    [1,0,0] => [0,1,2]
                    
                 
                    [0,1,0] => [0,0,2]
                    [0,1,0] =>[0,1,2]
                    [0,1,0] => [0,2,2]
                    [0,0,1] => [0,0,1]
                    [0,0,1] => [0,0,2]
                    [0,0,1] => [0,0,0] */
                 
                    
                   // 9th solution Assign a=01 b=10 e c=11  each variable is equal to the before plus 1 
                            zero
                            one
                            a=1 a++    a++
                             
                            11111111
                            aaaaaaaa 
                    
                    
                        acc    011111 
                        cac    110111 
                        cca    111101 
                        
                        bcc     101111
                        cbc     110111
                        ccb     111110
                        
                        cbb     111010
                        bcb     101110
                        bbc     101011
                        
                        abb     011010
                        bab     100110
                        bba     101001
                        
                        baa     100101
                        aba     011001
                        aab     010110
                        
                        caa     110101
                        aca     011101
                        aac     010111
                        
                        
                        aaa 01 01 01 
                        aab 01 01 10        ++
                        aac 01 01 11        ++
                        
                        bba 10 10 01
                        bbb 10 10 10
                        bbc 10 10 11
                        
                        ccc 11 11 11     --
                        ccb 11 11 10      --
                        cca 11 11 01
                        
                        aba 01 10 01 ++
                        abb 01 10 10
                        abc 01 10 11
                        
                        
                        
                        
                        
                        
                        acc 01 
                        11 11 (+1, means a+1,pos 0)
                        cac 01 10 11 // use rotate right?
                        cca 11 11 01  
                        
                        
                        
                        //cac 11 01 11 
                        bac 10 01 11 (-1 means b)
                        aac 01 01 11 (-1 means a)
                        
                        
                 
                        (baa == caa) // change in one pos (not from base)
                        (aba == abb)
                        (aab == bab)
                       
                        bab = aba (inverse) = bba (shift) = baa (shift) = caa (shift) = acc(inverse) = aca (shift)
                        = cac (reverse) = cab (shift) = aab (shfit) = acb (shift) = ccb (shift) = cca(shift)
                        = bca(shift) = bcc(shift)
                        
                      
                        
                        
                                
                                shift (da base bbb)  shift  shift
                    1)    (abb ==     bab         == bba == 
                        
                                shift (da base aaa)
                   2)     (baa == aba == aab)
                        
                                shift (da base ccc)
                   3)     (acc = cac == cca )
                        
                                shift(base aaa)
                   4)     caa = aca = aac 
                        
                        
                                shift(base bbb)
                   5)   cbb => bcb => bbc
                        
                                shift(base ccc)
                   6)     bcc => cbc => ccb
                        
                        
                        using two bases, we can invert the result(for example  reverte the results in 1) to 2)"
                        
                    
                    // base(aaa)
              2)    baa 
                    aba
                    aab
                    
                    abb // inverse a 2 , base bbb
                    bab  
                    bba
                    
                    
                    // base (ccc)
              3)    acc
                    cac
                    cca
                    
                    // nao precisa de base (inverse of 3) base aaa
                    caa
                    aca
                    aac
                    
                    
                    //base ccc
                4)  bcc
                    cbc
                    ccb
                    
                    cbb // base bbb inverse of 4)
                    bcb
                    bbc

  

            
3 bits de byte temporario = 
    
    00
        00         alternou byte cria o binario
            00
            
    
    
    
    
    
    
    
    a=111111
    
    bit_1 = b
    bit_0 = c 
    
    a=cccccc
    a=cccccb
    
      
    a=100100
    a=bccbcc
    
    1 bit = 1 byte?
    
    1 byte= shift binary?
    
    
    
    
    10  => a=1 , b=0
    
    
    reverse (so for calculating the reserv , just assing b=0 and a=1)
    
    01 => b=0 , a=1
    
    
    
    
    
    
    [ ] [ ] [ ]
     a   b   b
    [ ] [ ] [ ]
     b   a   b
     
     
     00000
     00001
     
     a = ? , 0 ?
     a = 4, 0b100
     
     [ ]    [ ] [ ]
     0b100   b   b
    [ ]     [ ] [ ]
     b   0b100   b
     
     
     0000
     0001 1-8 pos
     shift 1 , pos(1)
     
     incremento o ultimo bit
     reverse
    
    
    [ ]  [ ]   [ ]
     b   b      0b100
     
     [ ] [ ] [ ]            
     10   0    0
    shift pos(1)  para pos(2)

     1    2   3 
     [ ] [ ] [ ]
      0   10  0
    
    [ ] [ ] [ ]
    11   0   0
    
    
    

use 1 bit b, shift it 3 times, like abb , bab,bba
                                    invert
                                    baa,aba,aab
                                    
use 1 bit b, shift it 3 times , cbb,bcb,bbc
                                invert
                                bcc,cbc,ccb


                                
abb -
bab -
bba -

baa -
aba -
aab -

cbb -
bcb -
bbc -

bcc -
cbc -
ccb -

bba -
bbb
bab -
aab -
abb -
aba -
aab


                  
                 
                 
                  
                 for 0='b' and 1='a' ==> 3 ops
                 for 0='b' and 1='c' ==> 3 pos
                 
                 for 0='c' and 1='a' ==> 3 pos 
                 for 0='c' and 1='b' ==> 3 pos 
                     
                 
                 
                 
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
