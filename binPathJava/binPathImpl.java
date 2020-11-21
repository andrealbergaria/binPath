package binPathJava;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class binPathImpl {

	public static byte[] pos_1 = { 1 , 9 , 17 , 25 , 33 , 41 , 49 , 57 , 65 , 73 , 81 , 89 , 97 , 105 , 113 , 121 ,  (byte) 129 ,  (byte) 137 ,  (byte) 145 ,  (byte) 153 ,  (byte) 161 ,  (byte) 169 ,  (byte) 177 ,  (byte) 185 ,  (byte) 193 ,  (byte) 201 ,  (byte) 209 ,  (byte) 217 ,  (byte) 225 ,  (byte) 233 ,  (byte) 241 ,  (byte) 249 }; 
	public static byte[] pos_2 = { 2 , 10 , 18 , 26 , 34 , 42 , 50 , 58 , 66 , 74 , 82 , 90 , 98 , 106 , 114 , 122 ,  (byte) 130 ,  (byte) 138 ,  (byte) 146 ,  (byte) 154 ,  (byte) 162 ,  (byte) 170 ,  (byte) 178 ,  (byte) 186 ,  (byte) 194 ,  (byte) 202 ,  (byte) 210 ,  (byte) 218 ,  (byte) 226 ,  (byte) 234 ,  (byte) 242 ,  (byte) 250 }; 
	public static byte[] pos_3 = { 3 , 11 , 19 , 27 , 35 , 43 , 51 , 59 , 67 , 75 , 83 , 91 , 99 , 107 , 115 , 123 ,  (byte) 131 ,  (byte) 139 ,  (byte) 147 ,  (byte) 155 ,  (byte) 163 ,  (byte) 171 ,  (byte) 179 ,  (byte) 187 ,  (byte) 195 ,  (byte) 203 ,  (byte) 211 ,  (byte) 219 ,  (byte) 227 ,  (byte) 235 ,  (byte) 243 ,  (byte) 251 };
	public static byte[] pos_4 = { 4 , 12 , 20 , 28 , 36 , 44 , 52 , 60 , 68 , 76 , 84 , 92 , 100 , 108 , 116 , 124 ,  (byte) 132 ,  (byte) 140 ,  (byte) 148 ,  (byte) 156 ,  (byte) 164 ,  (byte) 172 ,  (byte) 180 ,  (byte) 188 ,  (byte) 196 ,  (byte) 204 ,  (byte) 212 ,  (byte) 220 ,  (byte) 228 ,  (byte) 236 ,  (byte) 244 ,  (byte) 252 }; 
	public static byte[] pos_5 = { 5 , 13 , 21 , 29 , 37 , 45 , 53 , 61 , 69 , 77 , 85 , 93 , 101 , 109 , 117 , 125 ,  (byte) 133 ,  (byte) 141 ,  (byte) 149 ,  (byte) 157 ,  (byte) 165 ,  (byte) 173 ,  (byte) 181 ,  (byte) 189 ,  (byte) 197 ,  (byte) 205 ,  (byte) 213 ,  (byte) 221 ,  (byte) 229 ,  (byte) 237 ,  (byte) 245 ,  (byte) 253 }; 
	public static byte[] pos_6 = { 6 , 14 , 22 , 30 , 38 , 46 , 54 , 62 , 70 , 78 , 86 , 94 , 102 , 110 , 118 , 126 ,  (byte) 134 ,  (byte) 142 ,  (byte) 150 ,  (byte) 158 ,  (byte) 166 ,  (byte) 174 ,  (byte) 182 ,  (byte) 190 ,  (byte) 198 ,  (byte) 206 ,  (byte) 214 ,  (byte) 222 ,  (byte) 230 ,  (byte) 238 ,  (byte) 246 ,  (byte) 254 };   
	public static byte[] pos_7 = { 7 , 15 , 23 , 31 , 39 , 47 , 55 , 63 , 71 , 79 , 87 , 95 , 103 , 111 , 119 , 127 ,  (byte) 135 ,  (byte) 143 ,  (byte) 151 ,  (byte) 159 ,  (byte) 167 ,  (byte) 175 ,  (byte) 183 ,  (byte) 191 ,  (byte) 199 ,  (byte) 207 ,  (byte) 215 ,  (byte) 223 ,  (byte) 231 ,  (byte) 239 ,  (byte) 247 ,  (byte) 255 };  
	public static byte[] pos_8 = { 8 , 16 , 24 , 32 , 40 , 48 , 56 , 64 , 72 , 80 , 88 , 96 , 104 , 112 , 120 , (byte) 128 ,  (byte) 136 ,  (byte) 144 ,  (byte) 152 ,  (byte) 160 ,  (byte) 168 ,  (byte) 176 ,  (byte) 184 ,  (byte) 192 ,  (byte) 200 ,  (byte) 208 ,  (byte) 216 ,  (byte) 224 ,  (byte) 232 ,  (byte) 240 ,  (byte) 248 ,  (byte) 256 };
	


	
	public static void printPositions() {
	    
	    int pos = 1;
	    int temp = pos;
	    for (int i = 1 ; i < 9 ; i++) {
	    pos = temp;
	    System.out.print("\n public static byte[] pos_"+pos+" = { "+pos+" , ");
	    for (int i2=0; i2 < 31; i2++) {
	        pos+=8;
	        if (pos > 128 )
	        	System.out.print(" (byte) ");
	        else if (pos < -127)
	        	System.out.print(" (byte) ");
	        System.out.print(pos+" , ");

	    }
	    System.out.print(" } ");
	    temp++;
	    }
	    
	}

	
	private void printUsingFunction() {
	    
	    
	    // look at function .. f(pos) = 8*i + pos
	   
		int t=0;
	     for (int pos = 1; pos < 9;pos++) {
	    	 System.out.println("\nPos "+pos+"\n");

	        for (int it= 0; it <= 32; it++) {
	            //printf(",%u",t);
	            t = 8*it+pos;
	            if (t % 256 == 0) 
	                System.out.println(t + ", ");
	         }
	        t=0;
	     }
	    
	        
	}
	
	
	    /**
         * 
         * 
         * FROM Maghoumi
         * https://stackoverflow.com/questions/5263187/print-an-integer-in-binary-format-in-java
         * System.out.println(intToString(5463, 4));
         * Converts an integer to a 32-bit binary string
         * @param number
         *      The number to convert
         * @param groupSize
         *      The number of bits in a group
         * @return
         *      The 32-bit long bit string
         */
        public static String intToString(int number, int groupSize) {
            StringBuilder result = new StringBuilder();

            for(int i = 31; i >= 0 ; i--) {
                int mask = 1 << i;
                result.append((number & mask) != 0 ? "1" : "0");

                if (i % groupSize == 0)
                    result.append(" ");
            }
            result.replace(result.length() - 1, result.length(), "");

            return result.toString();
        }  
        // x |= 0b1; // set LSB bit
        // x |= 0b10; // set 2nd bit from LSB
        
      //o toggle a bit use:
      //x ^= (1 << y) | (1 << z); // toggle yth and zth bit
        
        private static void printMissingElems() {
        	

        	//o) = m) + 1111
        	//n) = o) + m)
        	//o= n+m
        	
        	int[] a = {1,2,3,4,5,6,7,8};
        	ArrayList al = new ArrayList();
        	
        	System.out.println();
        	for (int itM=0; i < m.length; i++) {
        		int m = m[itM];
        		al.add(new Integer(m));
        		
        		System.out.print("0000 "+m[itM]+"("+m+")");
        		
        		int n = m[itM]+0b1111;
        		
        		al.add(new Integer(n));
        		System.out.println(x+" 0000 ("+n+")");
        		
        		int o = n+m 
        		al.add(new Integer(o));
        		System.outl.println(m[itM] + " "+m[itM]+ " ("+o+")");        
        		}
        		System.out.println();
        		for (int i=0 ; i < 24; i++) {
        			if (!al.contains(new Integer(i))
        					System.out.print(" "+i+" , ");
        }
        
}
        
        
        
	private static void prefix() {
		// 256 bits / / 8bits =>  
		int[] key  = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
		int[] invertedKey = new int[16];
		int[] another = new int[16];
		
		//	x ^= 0b1;
		// MSB -> 256 index 0;
		
	set 2    set 1	
	m)	0000 0111	7		
		0000 0011	3
		0000 0101   5
		0000 0001	1		 
		0000 0110	6			
		0000 0010	2			
		0000 0100	4
		0000 1000  8
		
		0001
							what about 2set ? 
		112   7				119-112 = 7d 
	n)	0111 0111 119 		n) is equivalent to m , se we subtract the number from the 1set of binaries to the number (119d-0111b,51d-011)
		0011 0011 51
		0101 0101 85
		0001 0001 17
		0110 0110 102
		0010 0010 34 
		0100 0100 68 
		0000 1000 8						
		
o)		0111 0000 112					set 1 = tem de ser igual a (1,2,3,4,5,6,7,8)  ou tudo a zeros?
										set 2=   (1,2,3,45,5,6,7,8) ou zeros ?
		0011 0000 48
		
		0101 0000 80
		0001 0000 16					1 = (1,2,3,4,5,6,7) 	?						0  = zeros??
		0110 0000 96					
		0010 0000 32					(1,1) (0,1) (1,0) (0 , 0) => Todas as ordens possiveis
		0100 0000 64				
		1000 0000 128						n) both 4 bits are occupied ( 1 , 1)
		
		
												0,17,34,51,68,85,102,119
		o) = m) + 1111
		n) = o) + m)
									minus -     0  1  2  3  4  5  6  7  m)  ( 0, 1)
	o) = m) + 1111
     n) = o) + m)
     o= n+m
											    0,16,32,48,64,80,96,112 o) (1,0)
		
								divide_by_16 
								
												0,1,2,3,4,5,6,7					
				 
				
				k= h)#1 / g)#1 = 16  
				k= h)#2 / g)#2 =  16
				k= h)#3 / g)#3  =  16
				
					f(g) = h)#1 / k , com k= 16
							
					i#1-g#1 = h#1
				
					f(g) = (i#1-g#1) / k
								

				(0,1) (1,0) trying i)
				a constante é 16 neste caso (para outros bits serao o mesmo)
				
				
				
								
g)  0000 1000	8d							
	0000 1001   9d
	0000 1010   10d
	0000 1011   11d
	0000 1100	12d
	0000 1101   13d
	0000 1110   14
	0000 1111   15
	0000 1111  16
	
	
	
h)							128 = 8*16   ( 8d * )
	1000 0000  8k = 128 , k=  128 / 8 => 16d = 8d
	1001 0000  144 = 9K = k= 144/9 => 16					
	1010 0000	160 = 10k = 16	 										
	1011 0000
	1100 0000
	1101 0000
	1110 0000
	1111 0000
	
	 
	
i)
	1000 1000  		i#1 = g#1+h#1 
	1001 1001  		i#2 = g#2+h#2   
	1010 1010  		 	
	1011 1011
	1100 1100
	1101 1101
	1110 1110
	1111 1111
	
												
					
												
												
												
					(1,1,1)(1,1,0)(1,0,1)(0,1,1)(0,0,1)(0,1,0)(0,1,0)(000)		
													
						0 = zeros?	1= (1,2,3,4,5,6,7) ?			
												
								
						
								(0,1,0) (0,1,1
										
										(1,0,0) (1,0,1) (1,0,0,0) (1,0,0,1) ( 1,0,0,0,0) (1,0,0,0,1)
										Ha subconjuntos que estao repetidos..nao necessario mulitplicat
										
						
		
		 
		bits iniciais 4 , maximum => 2 positions
		bits iniciais 8 , maximum => (2^3) 3 posicoes 		
		bits iniciais 16 , maximum => (2^4) 4 positions
		bit  iniciais 32 , maximum -> 5 positions 
		bits iniciais 256 , maximum => 8 positions 
		bits iniciais 512 -> maximum => 9 positions (need 32 positions)
		bytes iniciais 4294967296 -> 32 positions?
				
				ou seja vai diminuindo pela posicioes.....(menos 2vezes)
		
   4    3   2   1 				
b)	1	1	1	1 
	0	1   1	1 
	1	0	1	1  
	0	0	1	1  
	1	1	0	1    
	0	1	0	1		4 coluna = 3 coluna de a)   
	1	0	0	1		3 coluna = 2 coluna de a)
	0	0	0   1 		2 coluna = 1 coluna de a)
	1	1	1	0		 
	0	1   1   0    
	1	0	1	0
	0	0	1	0
	1	1	0	0		
	0	1	0	0
	1	0	0	0		 
	0	0	0	0
		
	4 bits -> 2 * threeBits
	5 bits -> 4 * threeBits
	6 bits -> 8 * threeBits
		

		// x |= (1 << y); // set the yth bit from the LSB
		
	
	
	
	}
	
	/* For Permutation , 32 times 8 positions , and permute -> time 370528=> 
	 * 370,528 sec
	 *  6.175466667 minutes
	 * 

	 * 
	 * For Permutation1 , 32 times 8 positions, 
	 * Time elapsed 70902

*/
	
	
	private static void checkBytes_permutation1() {
		Byte[]  key = new Byte[8];
		
		long startTime= System.currentTimeMillis();
		for (int it= 0; it < 32; it++) {
        	key[0] = pos_1[it];  
        	key[1] = pos_2[it];
        	key[2] = pos_3[it];
        	key[3] = pos_4[it];
        	key[4] = pos_5[it];
        	key[5] = pos_6[it];
        	key[6] = pos_7[it];
        	key[7] = pos_8[it];
		
        Permutation1<Byte> perm = new Permutation1<Byte>(key);
        int count = 0;
        while(perm.hasNext()){
            System.out.println(Arrays.toString(perm.next()));
        }
		}
        long endTime = System.currentTimeMillis();
        long len = endTime-startTime;
        System.out.println("\nTime elapsed "+len+"\n");
        
	}
	// Para cada posicao, existe 32 numeros
	//  Falta permutar as posicose para ficar com todos os elems
	private static void checkBytes_permutation() {
		
		Byte[]  key = new Byte[8];
		
		long startTime = System.currentTimeMillis();
				
			for (int it= 0; it < 32; it++) {
            	key[0] = pos_1[it];  
            	key[1] = pos_2[it];
            	key[2] = pos_3[it];
            	key[3] = pos_4[it];
            	key[4] = pos_5[it];
            	key[5] = pos_6[it];
            	key[6] = pos_7[it];
            	key[7] = pos_8[it];

            	
            	
            	// from permutation
            	Permutation.permute(8, key, ',');
            	
              
           }
            	
         long endTime = System.currentTimeMillis();   	
         long resTime = endTime - startTime;
         
         System.out.println("\nTime resultant : "+resTime+"\n");
		
		
		
	
	}
	
	
	public static void main(String[] args) {
		
		Byte[]  key = new Byte[8];

		
		long startTime = System.currentTimeMillis();
		long endTime,resTime;
		
		List<Byte[]> lArr = new ArrayList<Byte[] >();
		 
			//for (int it= 0; it < 32; it++) {
		for (int it=0 ; it < 1 ; it++) {
            	key[0] = pos_1[it];  
            	key[1] = pos_2[it];
            	key[2] = pos_3[it];
            	key[3] = pos_4[it];
            	key[4] = pos_5[it];
            	key[5] = pos_6[it];
            	key[6] = pos_7[it];
            	key[7] = pos_8[it];
            	lArr = Permutation.permute(8, key, ',');
            	int i=0;
            	
            	
            	Iterator<Byte[]> ite = (Iterator<Byte[]>) lArr.iterator();
            	
            		while (ite.hasNext()) {
            			i++;
            			Byte[] byteArr = (Byte[])ite.next();
            			
            			for (Byte print : byteArr)
            					System.out.print(" , "+String.valueOf(print));
            			System.out.println();
         
            		}
         }
			
			
	   endTime = System.currentTimeMillis();   	
	   resTime = endTime - startTime;
		         
		System.out.println("\nTime resultant : "+resTime+"\n");
				
		Byte[] elements = new Byte[4];
		
		
		
    	// from permutation
    /*	lArr = Permutation.permute(elements.length,elements, ',');
    	Iterator<Byte[]> it = lArr.iterator();
    	while (it.hasNext()) {
    		elements = it.next();
    		for (int i=0 ; i < 4; i++) {
    			System.out.print(intToString(elements[i],8));
    			
    		}
    	
    	}
    	*/
	}
		
		

	
}

