1) a = 00 10 11 (11d)
   b = 01 11 01 (29d)


a ^ b  = 00 10 11 (11d)
         01 11 01 =(29d)
        ---------
         01 01 10 (2+4+16 = 22d)

a + b  = 00 10 11 (11d)
         01 11 01 (29d)
        ---------   
         10 10 00 (40d)

b + a = 01 11 01 (b)
        00 10 11 (a)
        --------
        10 10 00 (40d)

b -a = 01 11 01 (29d)
       00 10 11 (11d)
       
a -b = 00 10 11
       01 11 01


       --testing
       
       1) a = 00 10 11 (11d)
          b = 01 11 01 (29d)
          Complement2(b) = 10 00 10 =  rev(b)
       
        complement(10 00 11) = rev(10 00 11)
        
        10 11 01 + complement = 1 01 00 00 (80d)
        
       
        101100
    XOR 111111
        010011
       
     To reverse a number , use XOR with only bits in 1
     
     rev(b) = (00 10 10 XOR 11 11 11) XOR 1
                
           010011 
 XOR 1bit  000001
           010010
           
XOR 2bits  010011
           000011
           010000
              
     XOR inverts the bits set
     
     XOR 1,3,7,
     
     seq 4 bits needed 3,5,6,7
    seq 4 bits covered 1,2,4,8
     
     // Trying all masks on first number 3
    0011 3d
    0110 mask is 0110 (6d)
    0101 5d

    
    
    3   5  6
    
    
    3 XOR 6 = 5d
    
    0101 5d
    0011 mask is 0011 (3d)
    0110 6d
    
    5 XOR 3 = 6d
    
    0110 6d
    0001 1d mask is 0001 (1d)
    0111 7d
     
    6 XOR 1 = 7d
     
     5 bits
     preciso de 
        3,5,6,7,9,10,11,12,13,14,15
     
          
        inv(value) - 1 = value
        inv(value) = value + 1;
        
        /*
         * 
         *  
         */
        value = 1100;
        inv(value) = 0011
        
        0011 
        0001 SUB
        0010 2d
        //       
        //CORRECT 3 -1 = 2 
        0011 - 1 = 0010
        // Trying add
        0011 = 1100+1
        0011 = 1101
        
        
        
        2complement(2) = 1101 
      
        
        (a - b) = a + (-b)
        
        (a - b) = a + (2's complement of b)
        
                    11 01 01        (53)
                           1       ADD
                   ---------
two complement =   11 01 10        (54)                    

    leading first bit , if 1 = negative
                        if 0 = positive
                        
    
        2 Complement
        for negative, inverse bits and add one (or xor with 0b1)
        for positive , just invert
            
