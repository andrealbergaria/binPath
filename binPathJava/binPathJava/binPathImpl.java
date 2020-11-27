package binPathJava;

import java.util.Arrays;
import java.util.Vector;

import binPathJava.Permutation;

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
	
	
        /* 
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
        
        
     /*   private static void printMissingElems() {
        	

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
        		
        		int o = n+m ;
        		al.add(new Integer(o));
        		System.outl.println(m[itM] + " "+m[itM]+ " ("+o+")");        
        		}
        		System.out.println();
        		for (int i=0 ; i < 24; i++) {
        			if (!al.contains(new Integer(i)))
        					System.out.print(" "+i+" , ");
        }
        
}
        */
        
        private static <T> Vector<Integer> getThreeBitsMarkerM(int num_three_bits) {
        	Vector<Integer> threeBitsMarker= new Vector<>();


        	int num = 0;
        	
 
        	// etapa = 66536
        	double etapa = Math.pow(2,num_three_bits)  / 65536;
        	
        	 num = 7;
        	threeBitsMarker.add(new Integer(num));
        	num+=8;
        	
        	//int it = 0;
        	int it2 =1;
        	int total=0;
        	
        	
        	for (double i=0 ; i < etapa; i++) {
        		threeBitsMarker.add(new Integer(num));
        		num+=8;
        		
        		it2++;
        		total++;
        		System.out.println(i);
        	}
        
        	System.err.println("\nTotal markers : "+total);
        	return threeBitsMarker;
        	
        }
        
        private static <T> void printArray(T[] arr) {
        	System.out.println();
        	 for (T element : arr) {
        	        System.out.print(element+" , ");
        	    }
        	
        	 System.out.println();
        }
        
        // FROM https://mkyong.com/java/java-how-to-convert-a-byte-to-a-binary-string/
        private static void printBits(byte b) {
        	String resultWithPadZero = String.format("%8s", Integer.toBinaryString(b))
                    .replace(" ", "0");
        	    System.out.println(resultWithPadZero+"  (d) "+(int) b);
        	   

        	   
        	}

        
        private static void printThreeBits(int num_three_bits) {
        	
        	Vector<Integer> threeBitsMarker= new Vector<>();
        	
        	threeBitsMarker = getThreeBitsMarkerM(num_three_bits);
        			
        	//[65536,131072,262144]
        		
        			
        	int sizeA = threeBitsMarker.size();
        	
        	Integer[] pos = new Integer[sizeA];
        	
        	threeBitsMarker.copyInto(pos);
        	
        			for (int sizeOfMarker =0 ;  sizeOfMarker <= 7 ; sizeOfMarker++) {
        				printArray(pos);
        				for (int i = 0 ; i < pos.length; i++) {
        					pos[i]++;
        					
        				}
        			}	
        		
        	
        	
        }
	private static void prefix() {
		
		
	//	int[] another = new int[16];
		
		
		// skip counting zeros, just assign arrays to 1..the others are 0
	/*	
		
		n) = m) + 1111 + m)		
			
			 0000 0111 + 0000 1111  + 0000 0111
		
	set 2    set 1	
	m)	0000 0111	7		
		0000 0011	3
		0000 0101   5
		0000 0001	1		 (1,2,3,4,5,6,7,8)
		0000 0110	6		+1111 +1111 +1111  	
		0000 0010	2			
		0000 0100	4
		0000 1000  8
		
		 
		112   7				119-112 = 7d 
	n)	0111 0111 119 		we subtract the number 
							from the 1set of binaries to
							the number (119d-0111b (7d) on 7 on m)
							and another example 51d-011 on 3 on  m) 
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
		1000 0000 128						
		
		
												0,17,34,51,68,85,102,119
		o) = m) + 1111
		n) = o) + m)
								minus -     0  1  2  3  4  5  6  7  m)  ( 0, 1)
	
	
    
    
											    0,16,32,48,64,80,96,112 o) (1,0)
		
								divide_by_16 
								
												0,1,2,3,4,5,6,7					
			
				shift esquerdo = dividir por 16
				k= h)#1 / g)#1 = 16  
				k= h)#2 / g)#2 =  16
				k= h)#3 / g)#3  =  16
				
					f(g) = h)#1 / k , com k= 16
							
					i#1-g#1 = h#1
				
					f(g) = (i#1-g#1) / k
								

				
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
	
												
					
		linha=8 bytes
		col = 2
												
												
					(1,1,1)(1,1,0)(1,0,1)(0,1,1)(0,0,1)(0,1,0)(0,1,0)(000)		
													
						0 = zeros?	1= (1,2,3,4,5,6,7) or 1 = (1,2,3)			
												

		bits iniciais 4 , maximum => 2 positions
		bits iniciais 8 , maximum => (2^3) 3 posicoes 		
		bits iniciais 16 , maximum => (2^4) 4 positions
		bit  iniciais 32 , maximum -> 5 positions 
		bits iniciais 256 , maximum => 8 positions 
		bits iniciais 512 -> maximum => 9 positions 
		bytes iniciais 4294967296 -> 32 positions?
				
				ou seja vai diminuindo pela posicioes.....(menos 2vezes)
		
   4    3   2   1 				
b)	1	1	1	1 
	0	1   1	1 
	1	0	1	1  
	0	0	1	1  
	1	1	0	1    
	0	1	0	1		4 coluna = 3 coluna de a)   
7	1	0	0	1		3 coluna = 2 coluna de a)
	0	0	0   1 		2 coluna = 1 coluna de a)
	1	1	1	0		 
	0	1   1   0    
	1	0	1	0
	0	0	1	0
	1	1	0	0		
	0	1	0	0
15	1	0	0	0		 
	0	0	0	0
		
	
	(4,3,2) ->  2threebits
	(1,2,3) -> nada
	 
	8 bits-> 32
	9 bits-> 64
	10 bits ->128
	11 bits -> 256
	12 bits -> 512
	13 bits -> 1024
	14 bits -> 2048
    15 bits -> 4096										
	16 bits -> (anterior ) * 2  
			-> 8192 * (1.....8192 of three bits)
					
					7 * 8192
					57344
					
		3bits ->8 combinações
		
		threeBits(7) = #8
		threeBits(15) = #8
	
	
	poupar 3 bits pois ao sempre igaugis em todas as posicoes
	
		threeBits = 16 elemets
	3 bits -> 1 * threeBits(7); => 8
	
	4 bits -> threeBits (7,15)  => 2*8 // 2*8
	
	5 bits -> threeBits (7,15,23,31) // 4*8
	
	6 bits -> threeBits (7,15,23,31,39,47,55,63) //8 * 8 

	
	//-- three marker bits
	
	5 bits- > (4bits,23,31)
	6 bits-> (5bits,39,47,55,63)
	7 bits-> (6bits,71,79,87,95,103,111,119,127)
	
	256 bits have 3 bits initials 
	
	/*Percorrer o mesmo ciclo e adicioainar 7
	
	15    = 0b1111
	23    = 0b10111 (15+7)
	31    = 0b11111 (23+7)
	
	byte1
	0b0 0 0		
	0b0 0 1			
	0b0 1 0		
	0b0 1 1		
	0b1 0 0		
	0b1 0 1		
	0b1 1 0		
	0b1 1 1		
				
					
	byte2
	0b0 0 0
	0b0 0 1
	0b0 1 0
	0b0 1 1
	0b1 0 0
	0b1 0 1
	0b1 1 0
	0b1 1 1 	 
	
	since they are equal to the first byte, one can assign without cycle
	
	3bits , All combinations = 2^3 = 8 bits
	4bits , All combinations = 2^4 = 16bits
	5bits , All combinations = 2^5 = 4 bytes
	6bits , All combinations = 2^6 = 8 bytes
	7bits , All combinations = 2^7 = 16bytes
	8bits , All combinations = 2^8 =  32bytes
	
		00 00 00 00 (0) assigning 8bits to number        
 		00 00 00 01 (1)        
 		00 00 00 10 (2) 
		11 11 11 10 (254)	
 		11 11 11 11 (255)	   
 		
 		309d = ? 
		11 11 11 10 -> 254
			X		->  309d ( 100110101 b )
			
			
			
			
	
		distancia entre pares-> 1
		pairs first bit  -> 8 de zeros , 8 pares de uns (numero de zeros e uns é sempre igual para todas as iterações)
		4 pairs distancia -> 2 (snd bit)
		2 paires -> distancia 4;

		fifth bit? aumentei o numero de bits, oo 4 bit foi alterado (passou a ser  2pair, cada par 8 , o first bit passou a ter 16pares)
		
		fifth bit -> 1 pair intervalo 0
		 
		
		/* 	First bit
		 * idx 1,3,5,7,9,11 = 0
		 * idx 2,4,6,8,10,12 = 1,  (separated by 2)
		 * 	+1
		 
		 *  second bit
		 * idx 1,2,5,6,9,10 = 0
		 * idx 3,4,7,8,11,12,15,16 = 1
		 * 
		 *    +2
		 *    Third bit
		 * idx 1,2,3,4,9,10,11,12 = 0
		 * idx 5,6,7,8 = 1
		 * 
		 *  +4
		 */
		
		/* Second bit = firstbit(0,1) *2
				 * => firstbit(0,1) *2  
				 *
		relationship betwen first bit and second bit 
		trying only with ones (use cycle to iterate index and assign ones
		zeros are already taken by java
		
		first bit
		2,4,6,8		10,12,15,16
		
		second bit
		3,4,7,8,	11,12,15,16
	
		third bit
		5,6,7,8,	13,14,15,16		
  	 
		 
		 
		  
		  
		*/
		int[] key = new int[16]; 
 
		for (int idx=1 ; idx <=16  ; idx++) {
			if (idx % 2 != 0) {
				key[] |= 0b1;
			}
		}
		for (int idx=1 ; idx <= 16;idx++) {
			if (idx )
		}
		
			// Set first bit to 1
			// set second bit to 1
			// set third bit to 1
		
			
		
			
		}			
		
	}
	

	
	
		
		
	
	
	
	
	private static void printMissingElements(Vector<int[]> arr) {
		System.out.println();
		
		Vector<Integer> bytesTaken = new Vector<>();
		
		for (int[] bArr : arr) {
			for (int bElem : bArr) {
				bytesTaken.add(bElem);
				System.out.println("bElem : "+bElem);
				
			}
		}
		
		//System.out.println(bytesTaken);
		System.out.println();
		for (int i =0 ; i < 256 ; i++) {
			
			if (bytesTaken.contains(i) == false)
				System.out.print(" , "+i);
			   if (i % 10  == 0)
				System.out.println();
				
		}
	
		
	}


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
       // int count = 0;
        while(perm.hasNext()){
            System.out.println(Arrays.toString(perm.next()));
        }
		}
        long endTime = System.currentTimeMillis();
        long len = endTime-startTime;
        System.out.println("\nTime elapsed "+len+"\n");
        
	}
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
		
		/*Byte[]  key = new Byte[8];

		
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
		//prefix();
		
	//	Vector<Integer> v =  getThreeBitsMarkerM(32);
		
       //printThreeBits(32);
		
		/*
		 * 
		 * g,h,i
		 * 
		 */
		
		
		
		int[] g = {0b00001000,0b00001001,0b00001010,0b00001011,0b00001100,0b00001101,0b00001110,0b00001111};
		int[] h = new int[8];
		int[] j = new int[8];
		
		for (int i =0 ; i< 8;i++) {
			h[i] = (g[i] << 4);
			j[i] = (h[i]+g[i]);
		}
		
		Vector<int[]> v  = new Vector<>();
		v.add(g);
		v.add(h);
		v.add(j);
		printMissingElements(v);

		// ones and ones after 3 bits
		
		// 4bits-> so three bits use 
		// 4 Bits  (2threebtes markers) 8 ones 8 zeros
		// 4 bits below
		
		
	base three bits- > 8 , add  10000 (8) to three bits
	base three bits -> 8 , add  11000 (16)  
	base_three_Bits -> 8,  add  11100 (24)
	
		   first 5 bits , needs to be added to bthree bits
	
			add number to three bits, constante? 
			
					
			00000 000
			00000 001
			00000 010
			00000 100
			00000 111
			00000 101
			00000 011
			00000 110
			
			a      b		
			00001 000
			00001 001 c)
			00001 010
			00001 100  
			00001 111
			00001 101  PErcorreu 8 bbytes
			00001 110
			00001 011
			
			
			so marker (001) appears on 5 msb in [8..16 bytes]
			so marker2 (010) appears on 5 msb in [16...24]
			so marker3 (011) appears on 5 msb in [24..32]

					
					4 bits iniciais = 4 bits finais
					
			1		001  b  1   111 a1	 	1 	011	 i 3
			2		010	 c	2	001 a2		2	    101	 j 5
			3		100	 d	4	101 a3     	3	110  k 6
			4		111	 e	7	110 a4		4	111	 l 7
			5		110	 f	6	011 a5		5	100	 m 4
			6		101	 g	5	010 a6		6	010	 n 2
			7		011	 h  3   100 a7 		7	001	 o 1
			
		
					
1		010 2 p		 				
2		111 7 q		 
3		001 1 r  	 
4		100 4 s     
5		110 6 t
6		101 5 w
7		011 3 x
						b=001
						
relação entre valor e posição
			Pos1 () => 001,111,011,010,101
			
			Pos2 =>   010,001,101,111
				
			pos1[0] = pos2[0] ?
			
			
			
			Se tiver desordnado (ou seja nao sequencialmente (3,4,1) (snaõ as posicoes sao iguais)
			
			Pos 1 = 2,5,3,6,7
			Pos 2 = 3,2,5,7,6							Quero permutar Pos1 
			
			For Pos1(2) ={3,2,5,7,6}	// Pos1(1idx) = everything from Pos2 
			For Pos1(5) = {3,2,5,7,6}  // Pos1(2idx) = Everything from Pos 2
			
			
			
			
			For pos1(2) = {2,3,5,6,7} 
			from unorder to order...
			For Pos2(2) = {2,5,3,6,7}
			
			
			indices are 1,2,3,4,5
			            2 3 1 5 4
			            
			            		having 2 -> 1 , having 3->1 , having 1 -> 3,
			            			P1(1idx) => 1-> 2, => P2(1idx) = 2 
			            			P1(2idx) => 2 -> 3 => P2(2idx) =1 
			          
			            1,2,3,4,5
			            
			            1,3,2,4,5		1->1 ; 2-> 3 ; 3-> 2 ; 4->4 ; 5->5 (se num iguais-> num iguais nao fazer nada)
			      		
			          					 
			           
			           1,3,4,2,5
			           
			           1,5,4,2,3
			           
			           
			           
			           
			            		
			            so we equal indices on Pos1 and get the value of Pos2 on that index
			
		sequence(5idx) 
			
			P1(1idx) => P2(2idx) --> 1idx->2idx
					
			P1(2idx) => P2(3idx) 2idx-> 3idx
			
			
			P1(3idx) => P2(1idx) 3idx -> 1idx
			
			troca de indexes.
			
			P1(4idx) => P2(5idx) 4idx -> 5idx
			
			P1(5idx) => P2(idx4) 5 -> 4
			
			
			
			}
			
			Pos1[0] (001)  => Pos2[0]   (001)
			
			se pos1[0] (111) => Pos2[4]  (111)
			
			
			
			
			Pos1(111) => Pos2(X)
			
			
			dont cycle every value (some are repeated (010,111,001))
			
						I can just assign one pos, the other are equal
					 b 		  o			r	
					Pos 1 -> Pos 7 -> Pos 3 (same bits)
						
					
					c  		  n 		p
					Pos 2 -> Pos6 -> Pos 1 
					010		 010 		010
					
					Pos 2 = { 010,101,111}
							 Pos2 Pos6 Pos 1
							
				    pos[0] = b ; pos[0] = o ; pos[0] =r;
					 Pos 1		=		Pos 7	= 	Pos 3
	
							 
					byte[] arr2 = new byte[8];
					byte[] arr3 = new byte[8];
					byte[] arr4 = new byte[8];
					byte[] arr5 = new byte[8];
					byte[] arr6 = new byte[8];
					byte[] arr7 = new byte[8];
					// iniciais, usados para atribuir valor
					
					
					for (int i= 0 ; i < 8; i++) {
						pos[i] =  0b000;
						arr7[i] = 0b001;
						arr2[i] = 0b010
						arr3[i] = 0b011;
						arr4[i] = 0b100;
						arr5[i] = 0b101;
						arr6[i] = 0b111;
						
						
						
						// Todas as possiveis lugares de 001 (i lugares)
 
						
					}
								
								
					
					
						
						
					
					P = {a,b,c,d};
					n=4
					p=2

					4A2 -> n^p
					
				Ou seja os numeros acontecem em posicoes diferentes
				com o mesmo valor (só possivel se houver permutação de elementos)
								
		b=o 
		
		d=m					P1 = {a,b,c,d,e,f,g,h}
		e=l					P2 = {i,j,k,l,n,n,o,p}
		f = k				nP1 = 8
		g = j				nP2 = 8
							p= 3
		h = i			
					Pos b = Pos o?
				Arrrajos = {b,c,a},{d,e,f}
			
							{o,n,p} {m,l,k
		ordem diferente mesmos numeros
					
		Arranjos 
		ou seja ao adiconar um zero anterior ao numero, = 8C8
		
			5 bits
			 00000 000 (0)				1
			 00000 001 (1)	*marker
			 00000 010 (2)	*marker 2 
			 00000 011 (3)	*marker 3
			 00000 100 (4)	
			 00000 101 (5)	
			 00000 110 (6)	
			 00000 111 (7)	  	8
			 00001 000 (8)	
			 00001 001 (9)	
			 00001 010 (10)	
			 00001 011 (11)	
			 00001 100 (12)	
			 00001 101 (13)	
			 00001 110 (14)	
			 00001 111 (15)	
			 00010 000 (16)				16
			 00010 001 (17)	
			 00010 010 (18)	
			 00010 011 (19)	
			 00010 100 (20)	
			 00010 101 (21)	
			 00010 110 (22)	
			 00010 111 (23)	  
			 00011 000 (24)			24
			 00011 001 (25)	
			 00011 010 (26)	
			 00011 011 (27)	
			 00011 100 (28)	
			 00011 101 (29)	
			 00011 110 (30)	
			 00011 111 (31)	   32 
			
			
			
			 } 

			
			
			
			