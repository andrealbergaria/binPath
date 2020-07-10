
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
                 // in the case of 11111 works ok, but if 0000, tends to a bit of changes, suggest inverse all bits,
                 // but in this case,  (from 11111 to 00000), how can one invert a set?
                 
                 //4rd solution 
                 //Each shift represents a changing position
                 // So 
                 
                 
                 // 5th solution
                 //  Assign binary digits (0 or 1) to all variables (like a=0 , b =1 , and a=1 and c=0), and 
                 
                 
                0 0 0 0 0 1     1       [a,b,c] , pos(0) = [a,b,c]
                                                  pos++ // after shifitng,
                                                  pos(1) 
                                                  

       
       aaa
       bbb
       ccc
            1)                                      
                                                 1) baa  (b=1 ou a=0 )
                                                 2) aba
                                                3)  aab
                                                  
                                                 4) abb (revert of 1)) = a=1 , b=0)
                                                 5) bab
                                                 6) bba
                                                  
                                                  0) baa
                                                  1) reverse pos(1) a ==> b  , aba
                                                  2) reverse pos(2) a ==> b,   aab
                                                  
                                                  (c=0 ou a=1)
                                                7
aaa                                                
baa (aaa shift pos)
abb (invert)

aba (aaa shift pos
bab (invert)


aab (aaa shift pos)
bba (invert)


for a = 1 , b= 0
    ou
    a=0 b= 1
    
    aa
    ab
    ba
    bb
    
    11 => a=1 b=1
    00 => a=0 ,b =0
    
    posso meter o mesmo byte em diferentes posicoes
    11
        11
            11
    byte temp = 0b10
    
    10 
        10
            10
    
    11             quero obter o byte inteiro
        10
           10
    shift 8
    10
        11 
            10
    shift(8)


byte[] = {a,b,c}

 a=0b101
 b=0b001
c=0b110
                        (baa == caa) // change in one pos
                       (aba == aca)
                        (aab == aac)
                        
                        
                        (bab == aab)
                        (abb == aab == aac
                        
                                
                                
                                shift (da base bbb)  shift  shift
                        (abb ==     bab         == bba == 
                        
                                shift (da base aaa)
                        (baa == aba == aab)
                        
                                shift (da base ccc)
                        (acc = cac == cca )
                        
                                shift(base aaa)
                        caa = aca = aac 
                    
                        
                    
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
abb !
bab !
bba !

baa !
aba !
aab !

acc !
cac !
cca !

bcc !
cbc !
ccb !


        

        shift 1, then shift 8)
        
        b 
            a
    a
        a
            shift(16)    (shift a+b)

           
            
            
        inverse of anterior (baa, aba,aab) 
        aab
        aba
        aab
    
    c
        a
            a
   a
        c           => inverse of first
            a
    a
        a
            c

            inverse of anterior (caa,aca,aac)
                                aac, cac,cca)
            
   10
        10 (da base)
            11 (mudou de pos[1] para pos[2], sendo um shift de 8 bits)

  

            
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
    
    a = cccb
    a = ccbc
    
    1 bit = 1 byte?
    
    1 byte= shift binary?
    
    
    
    
    10  => a=1 , b=0
    
    
    reverse (so for calculating the reserv , just assing b=0 and a=1)
    
    01 => b=0 , a=1
    
    
    
    
    
    
    shift a to the right (000,001)
    pos A = 0
    pos A = 1
    
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
     
     1    2   3             00000
                            00001
                            00010
                            00100
                            01000
                            10000
                            
                            [ ] [ ] [ ] [ ] [ ] [ ]
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


                                for a= 1,b=0
                                   1bb
                                    b1b
                                    bb1
                                
                                for a=0 , b=1 (revert)
                                    
                                
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



aab (change bit 1)

8) cca 
                                                9)cac 
                                                  

                                                inversos(2) é igual original(1) mudado
                                                
original(1) = baa                                                
inverse (1) = abb

original(2) = aba
inverse(2) = bab                                13)  cbb
                                                14)  ccb
original(3) = aab                               15)  cbc
inverse(3) =  bba






original(4) = caa
inverse(4) = acc

original(5) = aca
inverse(5) = cac            inveser tb é igual a tipo inv4 = acc , inv4=

original(6)= cac
inverse(6) = aca


                                                  
                                                16)  bcc
                                                17)  bbc
                                                18)  bcb
                                                  
                                                  
aaa


baa
aba
aab

caa
aca
aac

                                           
                                           
                                                  
                                                  
                  0 0 0 0 1 0   2
                  0 0 0 1 0 0   4
                  
                 //5 solution
                 // each bit indicates if the character is present on the number
                 // so for instance (abc = 111
                 //a=1
                 //b=1
                 //c=1
                 // for b=0 , 101
                 
                    
                    aaa
                    pos(0) revert at pos((0)
                    baa
                    caa
                    pos(1) revert at pos(1)
                    aba
                    aca
                    pos(2) revert at pos(2)
                    aab
                    aac
                    
                    
                    bbb
                    pos(0) (revert at pos(0)
                    cbb
                    abb
                    pos(1) (revert at pos(1)
                    bcb
                    bab
                    pos(2) (revert at pos(2)
                    bbc
                    bba
                    
                    ccc
                    pos(0) revert at pos(0)
                    bcc
                    acc
                    pos(1)  revert at pos(1)
                    cac
                    cbc
                    pos(2) revert at pos(2)
                    cca
                    ccb
                    
                    
                    
                    
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
