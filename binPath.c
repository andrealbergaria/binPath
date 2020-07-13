
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
                    
                                            
                                       
                  // use xhg (asm) to a=b b=a
                  
                 // solultion : etither add or bit shift, the entire stream of bytes
                 // In this case , i have byte[] = {00000000,00000001} , and then bit shift one possition (or add a bit)
                 // After , do the same for byte[] = {11111111,111111}. Hence we get all bytes.
                 
                 
                 /*
                 
               a)          01 10 11 xor (a,b) = > (111100 which is a xor  of c) d))
               b) rev =    10 01 00
                
                c)  shift 1 (from a )
                        00 01 10            6d
                d) shift 1 (from b)
                        00 10 01            9d

                e) xor
                       00 11 11             15d => c) + d)
                        
                        
                   a = rev(b)     
                        
                 
                         
                
                        
                //how can one invert a set?
                 
                 
                   //  solution one possibility is too assign four pointers to a firstHal, and then dereference them when needed (like for instance , where 0 0 (hence derefence on the second 0)
                 // char *f1 = secondHalf
                 
                 // char half[4] = { 0001,0010,0100,1000 }
                 
                 char *h1 = half[0]
                 char *h2 = half[1]
                 char *h3 = half[2]
                 char *h4 = half[3]
                 
                a // {*h1,*h1,*h1 }
                b // {*h1,*h2,*h1 } 
                c // {*h1,*h1,*h2} 
                d // {*h2,*h1,*h2} 
                e // {*h2,*h2,*h1} 
                 ... and so one
                 it = 0
                 a[0] = *h1
                 a[1] = *h1
                 a[2] = *h1
                 
                 a[1] = *h2; ( h1 h2 h1
                 a[1] = *h3  ( h1 h3 h1)
                 a[1] = *h4  (h1 h4 h1)
                 
                 a[1] = a[0]
                 
                 a[2] = *h2; ( h1 h2 h1
                 a[2] = *h3  ( h1 h3 h1)
                 a[2] = *h4  (h1 h4 h1)
                 
                 a[2]  = a[1]
                 
                 
                
                
                
                 //7 solution
                 // each bit indicates if the character is present on the number
                 // so for instance (abc = 111
                 //a=1
                 //b=1
                 //c=1
                 // for b=0 , 101
                 
                 // solution ( i think already tried)
                 // for each bit , there is a change in the set. position or substituing
                 
                    
                   // solution Assign a=01 b=10 e c=11  each variable is equal to the before plus 1 
                      
                        acc    011111 1 
                        cac    110111 2
                        cca    111101 3
                        
                        bcc     101111 4
                        cbc     110111 5
                        ccb     111110 6
                        
                        cbb     111010 7
                        bcb     101110 8
                        bbc     101011 9
                        
                        abb     011010 10
                        bab     100110 11
                        bba     101001 12
                        
                        baa     100101 13
                        aba     011001 14
                        aab     010110 15
                        
                        caa     110101 16
                        aca     011101 17
                        aac     010111 18
                        
 
                 
          
                // inversions
                inverseOf(a) = b (b=a also works)  add value 1 to a , or substact value 1 to b
                inverseOf(c) = z (z=c works)
                
                
                One
                o = 11 = c;
                Zero
                z =0 
                
                z = 0
                a = z + 1 = 01;
                b = z + 2 = 10  (b= a+1) 
                c = z + 3 = 11  (c= b+1)
                o = c = z+c = 11
                
                c=o ???? its why were using only 2 binary digits, for a total of 4 elements, so o can't appear
                
                inverse
                z = 1
                a = 10
                b = 01
                c = z
                o = 00 = c = z
               
                [a,b,c]
                
        // In the case , a,b,c use the truth table
                a=z+1 ==> 01
                b=a+1 ==> 10
                c=b+1 ==> 11
                d=c+1 ==> 100
               
                
        // finished inverse trying
                            
                        
                        10 01 01 
                        //one bit to change the abb (shift,reverse,
                        11 01 01 (
                            
                            
                      xor 10 01 01      (baa  => 1+4+32
                          11 01 01      (caa)  => 32+16+4+1 (+16)
                          ---------
                          01 00 00          +16 (01 00 00) (flip de quantos ? 000000 >> 2
                            // xor use to add
                            
                     xor 11 01 01           (caa)
                         10 01  01          (baa)
                         01 00  00   // +16 
                                    //xor use to subtract
                        
                    xor bba = 10 10 01
                        bbc  = 10 10 11
                        -----------------
                        
                        000010 // +2  (flip de quantos ? 000000 >> 6
                        
                        10 10 10 bbb
                        10 10 11 bbc
                        
                        000001 +1 (xor)
                        
                                  (bbb)
                        10 10 01 (bba)
                        
                        00 00 10 +2 (xor)
                        
                       // several adds, will result in the binary number
                        
                       /*  11 11 11 ccc  
                         11 11 10 ccb
                         --------
                         00 00 01 (zza) +1
                         
                         11 11 11 ccc
                         11 11 01 cca
                         --------
                        00 00 10 +2 (zzb)
                        
                        11 11 11 ccc
                        11 11 11 ccc
                        --------
                        00 00 00  +(zzz) +0
                        */
                        
                         11 11 11 ccc  
                         11 11 10 ccb
                         --------
                         00 00 01 (zza) +1
                         
                        
                        
                        10 10 10 bbb
                        10 10 11 bbc
                        --------
                        00 00 01 (zza) +1
                        
                        
                        a->b  +3 (aaa,aab) last pos
                        c->a +2 (ccc,cca) last pos
                        c->z +1 (ccc,ccz) last pos
                        
                        xor must be equal to +1 (1st round)
                        
                      a  00 00 
                      b  00 01  a^b = 00 00 xor 00 01 = 0001 = b^a
                        
                      ab=ba
                      
                     
                      
                                    
                     a 00 00 
                     b 00 01 add a+1 (ab=ba)
                     -------
                           1
                           
                    
                    2nd round    +2
                     
                     a  00 00
                     c  00 10  add a+2  a^c = 0010 = c^a
                     
                      
                   3rd round
                    
                    b 00 01
                    c 00 10   add a+3   b^c = 0011 = c^b
                    
                //its all equal from on now
             
             
             from the above, 
             z=00
             a=01
             b=10
             c=11
             
             // to get the bytes from the variables, for instance to make a= ? to use 2 bytes, 
             a) 2bytes-> 1 byte (shift left 2 bits)
             
             
             3bytes-> a) 2bytes -> 1byte
             
             3) bytes shift left 2 bits + shift left 2 bits (4 bits)
             
             
             // todos os shifts bits qualquer que sejam o numero de bytes, vao originar os elementos (a,b,c)
             
             // para numBytes = 3 , shift left 4 bits
             // para numBytes = 4 , shift left 6 bits
             
             For (number = 00 00 01 => z b then shift 4 bits turns on, bz optimization!!!)
             
             
             // for zeros (z) use the shift 2 bits
             // for xhanging positions of varaibles rather than zeros, one uses the xgh operator (like in asm)
                
                // the objective it sum the last statement with +1
             
             
                // the changing in the third position is number+1
                
                
                01 00 00 => +1   => 01 00 01
                a  z   z            a  z  a
                
                00 00 10 => +1 => 00 00 11
                z  z  b           z  z  c 
                
                01 01 00 => +1 => 01 01 01
                a  a  z             a   a  a
                
                11 11 00 => +1 =>  11 11 01
                c  c  z             c c a           
                
                
             
               01 01 00 => +1 => 01 01 01
               a  a  z           a  a  a
               
               
               
               10 00 00 => -1 => acc
                b  z  z 
               01 00 00 => -1 => zcc
                a  z   z
                
                String t2 = "not calculated, assumed"
                
                
                
                -1,-2,-3,4 = change in the third position
                -5,-6,-7,-8 = change in the third position
                -9,-10,-11-12 = change in the third position
                -13,-14,-15,-16 = change in the third position
                -8,-9 = bbz -> bac = 
                -12,-13 = baz -> bzc = 
                -16,-17 = bzz -> acc
                -20,-21 = acz -> zbz = 
                
                
     here)           so from baz to bzc , there are 8 positions
                string t = counting from the original
                    baz +1 t = baa
                    baa +2 t = bab
                    bac +3 t = bbb
                    baz +4 t = bbz
                    baz +5 t = bba
                    bar +6 t = bbb
                    bar +7 t = bbc
                    bar +8 t = bcz
                    
                    so from acz to zbz = -20,-21
                    acz +1 t = aca
                    acz +2 t = acb
                    acz +3 t = acc
                    acz +4 t = bzz 
                    acz +5 t = bza
                    acz +6 t = bzb
                    acz +7 t = bzc
                    acz+8 t =  baz
                    acz+9 t =  baa
                    acz+10 t = bab
                    acz+11 t = bac (t2)
                    acz+12 t = bbz
                    acz+13 t = bba
                    acz+14 t = bbb (t2)
                    acz+15 t = bbc (t2)
                    acz+16 t = bcz
                    acz+17 t = bca
                    acz+18 t = bcb
                    acz+19 t = bcc (t2)
                    acz+20 t  =czz                  
               11 00 00 (czz) => -1 => bcc
                                 -2 => bcb
                                 -3 => bca
                                 -4 => bcz
                                 -5 => bbc (subtracts 2pos from previous and adds z to c from -1)
                                 -6 => bbb
                                 -7 => bba
                                 -8 >= bbz
                                 -9 => bac (subtracts 2nd pos and adds z to c)
                                 -10=> bab
                                 -11 => baa
                                 
                                 -12 => baz
                                 -13 => bzc (adds 8 positions , check here)
                                 
                                 -14 => bzb
                                 -15 => bza (t2)
                                 -16 => bzz (t2)
                                 -17 => acc 
                                 -18 => acb (t2)
                                 -19 => aca (t2)
                                 
                                 -20 => acz (t2)
                                 
                                    adds(last, and makes a carry from c-> b,
                                        z -1  = 
                                        ab
                                    )
                                 -21 => abc 
                                 
                                 20 em binario =  = 010100
                                 21 em binario = 010101
                                 11 00 00
                                 
                                 
                                 -22 => caz
                                 
                                 
                                 // base 00 00 01
                                 +1 => 00 00 10 (zzb)
                                 +2 => 00 00 11 (zzc)
                                 +3 => 00 01 00 (zaz)
                                 +4 => 00 01 01 (zaa)
                                 -1 => 00 00 00 (zzz)
                                 -2 => ???
                
                                // base 11 01 00
                                    +1 =>  caa
                                    +2 =>  cab
                                    +3 =>  cac
                                    +4 =>  cbz
                                    -1 =>  czc
                                    -2 =>  czb
                                    -3 =>  cza
                                    -4 =>  czz
                
                z = 0
                a = z + 1 = 01;
                b = z + 2 = 10 and b= a+1 
                c = z + 3 = 11 and c= b+1
                o = c = 1
                
                //b z (shift left 4 bits)
                
                
                
               xhg(a,b) = ba
               
               
               
                [z,a,b,c] 4*4*4 = 64
                
                 {[1,2,3] = perumtations with repetations= 27
                
                
                    xor = equivalent to adding +2 to a number
                            
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

  

            
    
    

use 1 bit b, shift it 3 times, like abb , bab,bba
                                    invert
                                    baa,aba,aab
                                    
use 1 bit b, shift it 3 times , cbb,bcb,bbc
                                invert
                                bcc,cbc,ccb

use 1 bit b, shift it 3 times , acc,cac,cca
                                caa,aca,aac
                                

                 for 0='b' and 1='a' ==> 3 ops
                 for 0='b' and 1='c' ==> 3 pos
                 
                 for 0='c' and 1='a' ==> 3 pos 
                 for 0='c' and 1='b' ==> 3 pos 
                     
                 
                for (iterator = 1 ; iterator < 2; iterator++ ) {
                       zero[iterator-1] = 0;
                       zero[iterator] = 
                 
                 }
                 

                 
                 /* para cada shift right [01,10,11]
                  *                         a  b  c
                                          [00,01,10]
                                            z a b
                                          [00,00,01]
                                            z z a
                                          [00,00,00]
                                            z  z z
                para cada shift left [01,10,11]
                                       a  b c
                                     [10,11,00]
                                      b  c z
                                     [11,00,00]
                                     c z z
                                     [00,00,00
                                    z z z
                {[1,2,3] = perumtations with repetations= 27
               
               [1,2,3] is used (pos(0) = 1  , pos(1)= 2 , pos(2) = 3 (because on each position , one increments the before)
                                    
                 
                  assign 00000000 = [1,2,3]
                  assign 00000001 = {1,2,3]  (var=1 1 change to set)
                  assign 00000010 = {1,2,3]  (var=2 (correspond to 2 changes to set)
                  assign 00000100 = [1,2,3] (var=3 (correspond to 3 changes in set)
                  total permutations = 2+4+8+16+32+64+128+256 = 509 
                  
                  
                  
                  if it was binary code, then we would make a shift, in thise case we change pos
                      
                1)    100
                2)    010
                3)    001 pos(0) =pos(1),pos(2)=pos(1)  (2shifts, 0 -> 1 , 1->2, um shift uma posicao++)
                      
                     
                      3bits=8 orders
                      
                      e se eu fizer o shift, com posicao fixa no bit anterior
                      
                      01 01   ( ==> correspond to 100 , on the last seq (1)) 
                      01 10   ( ==! correspond to 010 , on the last seq(2) shift efectuado (01 01
                      10 10                                                                  01 10                                                                      
                      10 01   ( ==> correspond to 001, om the last seq(3) , shift efectuado (10 01
                                                                                            10 (01)
                                                                                                            
                    
                    num da posicao = numero binario (nao resulta)
                      000 = position(0)
                      001 = position(1)
                      010 = position(2)
                      100 = position(8)
                      
                      
                      
                     // equal one bit digit to a position, and other digit to a position  (1=1 0=2)
                     // 1=01 0=10
                     // so the bit 1 is equal to 1 position
                     // so the bit 0 is equal to 2 position
                     
                    so if the elements are two, then we case use the algorithm
                    
                    if the elements are three?
                        if the elements are three
                        => 000 (3bits) , 1st bit = 0 ... 2nd bit = 0 ...3rd bit = 0
                                                   1               1            1
                                        
                                        1st bit 
                                        1
                                        0
                                        
                                        if elements are 2 (like [a,b]), then 1st bit must be multiplied by 2
                                        1st bit must be 2nd bit uses 1st bit,
                                        
                                        2nd bit is 1bit , 1 bit
                                        
                                        0 0 A = (2nd bit = xor first bit ^ 0) 
                                        0 1 B = (2nd bit = xor first bit ^ 1 )
                                        1 0 C = (2nd bit = xor first bit ^ 1)
                                        1 1 D=  (2nd bit = xor first bit ^0 )
                                        
                                        B=C, A=D
                                        
                                        3 bits
                                        

                    bit 0 = pos(1)
                    bit 1 = pos(2)
                    bit 2 = pos(3)
                    
                    
                    
                    
                        
                    100 (1,2,2) 
                    010 (2,1,2)
                    001 (2,2,1)
                    
                    // bit 1 = 2, bit 0=1
                    100 (2,1,1)
                    010 (1,2,1)
                    001 (1,1,2)
                      
                   [2,3,4] 
                   1000  (1pos,2pos,2pos)
                   0100  (2pos,1pos,2pos)
                   0010  (2pos,2pos,1pos)
                    
                   
                   1000 (1000,0010,0010)
                   0100 (0010,1000,0010)
                   
                   
                   
                   so if i follow the algorithm (0000 00001 0010 0100 1000, 1111 1110 1101 1011,0111)
                   it woudl work
                   
                 
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
