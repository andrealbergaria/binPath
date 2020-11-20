package binPathJava;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class binPathImpl {

	public static int[] pos_1 = {  1,9, 17, 25, 33, 41, 49, 57, 65, 73, 81, 89, 97, 105, 113, 121, 129, 137, 145, 153, 161, 169, 177, 185, 193, 201, 209, 217, 225, 233, 241, 249 };
	public static int[] pos_2 = {  2,10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218, 226, 234, 242, 250 };
	public static int[] pos_3 = {  3,11, 19, 27, 35, 43, 51, 59, 67, 75, 83, 91, 99, 107, 115, 123, 131, 139, 147, 155, 163, 171, 179, 187, 195, 203, 211, 219, 227, 235, 243, 251 };
	public static int[] pos_4 = {  4,12, 20, 28, 36, 44, 52, 60, 68, 76, 84, 92, 100, 108, 116, 124, 132, 140, 148, 156, 164, 172, 180, 188, 196, 204, 212, 220, 228, 236, 244, 252};
	public static int[] pos_5 = {  5,13, 21, 29, 37, 45, 53, 61, 69, 77, 85, 93, 101, 109, 117, 125, 133, 141, 149, 157, 165, 173, 181, 189, 197, 205, 213, 221, 229, 237, 245, 253};
	public static int[] pos_6 = {  6,14, 22, 30, 38, 46, 54, 62, 70, 78, 86, 94, 102, 110, 118, 126, 134, 142, 150, 158, 166, 174, 182, 190, 198, 206, 214, 222, 230, 238, 246, 254};
	public static int[] pos_7 = {  7,15, 23, 31, 39, 47, 55, 63, 71, 79, 87, 95, 103, 111, 119, 127, 135, 143, 151, 159, 167, 175, 183, 191, 199, 207, 215, 223, 231, 239, 247, 255 };
	public static int[] pos_8 = {  8,16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 248,256 };


	
	
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
	public static void printBits(int number) {
		   int mask = 0x80;
		   int it;
		   
		   for (it=0 ;it < 8; it++) {
		       if ( (number & mask) == 1)
		           System.out.print('1');
		       else
		           System.out.print('0');
		      
		       mask >>= 1;
		   }
		   

		   
		}

	public static void printKey(int[] key) {
		System.out.print("\n [");
		for (int i=0;  i< key.length ; i++)
			System.out.print(" "+key[i]+",");
		System.out.println(" ]");
	}
	
	//https://www.javatpoint.com/factorial-program-in-java
        public static void factorial(int n) {  
         int fact=1;  
             
         for(int i=1;i<=n;i++){    
             fact=fact*i;    
         }    
         System.out.println("Factorial of "+n+" is: "+fact);    
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
        
	private static void prefix() {
		// 256 bits / / 8bits =>  
		int[] key  = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
		int[] invertedKey = new int[16];
		int[] another = new int[16];
		//o toggle a bit use:
		// x ^= (1 << y) | (1 << z); // toggle yth and zth bit
		//	x ^= 0b1;
		// MSB -> 256 index 0;
		// Para cada it, divide-se o
		 
		//reverse key
		
	
		// 2^8 => 256
		
		// If i have 256 (8 bits)
		// Nao chega ao byte....
		
		
	a)	0000 0111		
		0000 0011	
		0000 0101
		0000 0001	
		0000 0110	
		0000 0010	
		0000 0100	
		0000 0000  
		
		 
		bits iniciais 4 , maximum => 2 positions
		bits iniciais 8 , maximum => 3 posicoes 		
		bits iniciais 16 , maximum => 4 positions
		bit  iniciais 32 , maximum -> 5 positions 
		bits iniciais 256 , maximum => 8 positions 
		bits iniciais 512 -> maximum => 9 positions (need 32 positions)
		bytes iniciais 4294967296 -> 32 positions?
				
				ou seja vai diminuindo pela posicioes.....(menos 2vezes)
		
   4    3   2   1 (4,3,2 -> 3 bits repetindo-se por 2 vezes)				
	1	1	1	1 
	0	1   1	1 	(inicio 16 bits, 8 uns 8 zeros)
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
				
		
	
	
	111 X
	011 X  
	101 X
	001 X										
	110 X
	010 X  4 more initial zero + 4 one's (plus 8 elemens, 2^3)
			3 bits have 2^3 combinations  + 2^3 = 2 times 2^3
	100 X
	000 X	Adding 4 zeros and 4 ones, multiplies by 2
	111 
	011 
	101 
	001 
	110
	010
	100
	000
	
				
		Para bits iniciais tem de ser divisivel por 2)
		0	1	1  
		1	0	1
		0	0	1
		1	1	1
		0	1	 
		1	0	
		0	0	0
		1	1	0
		0	1	0
		1	0	0
		0	0	0
						 
			
		
		
		
		  
		
		
		for (int i=0 ; i < 16; i++) {
			if (i < 8) {
				key[i] |= 0b00000001;
			
				if (i < 2)
					key[i] |= 0b00000100;
				else
					key[i] |= 0b0;
				
				if ( i < 4) 
					key[i] |= 0b00000010;
				else
					key[i] |= 0;
				
			}
			else {
					key[i] |= 0;
					if (i < 12 )
						key[i] = 0b00000010;
					
					
			}
			// Set 2nd bit
			
			//printBits(key[i]);
			
			
			System.out.print("\n "+ intToString(key[i],8));
			
		}
		
		/*System.out.println("\n");
		printBits(key[0]);
		System.out.println("\n");
		printBits(key[1]);
		System.out.println("\n");
		printBits(key[2]);
		System.out.println("\n");
		printBits(key[3]);*/
		/* just do ones first
1)		 1 1
		 1 1
		 0 1
		 0 1
		 1 0
		 1 0
		 0 0
8)		 0 0
				
			*/	
		/*key[0] = (int)0b0 1 1 1 1 000;;
		key[1] = (int)0b0 1 1 1 0 000;//96,6
		key[2] = (int)0b0 1 1 0 1 000; // 5
		key[3] = (int)0b0 1 1 0 0 000; // 4
		key[4] = (int)0b0 1 1 1 1 000; //3
		key[5] = (int)0b0 1 1 1 0 000; 
		key[6] = (int)0b0 1 1 0 1 000;
		key[7] = (int)0b0 1 1 0 0 000; 
		key[8] = (int)0b0 1 0 1 1 000; //15
		key[9] = (int)0b0 1 0 1 0 000;
		key[10]= (int)0b0 1 0 0 1 000;
		key[11]= (int)0b0 1 0 0 0 000;
		key[12]= (int)0b0 1 0 1 1 000;
		key[13]= (int)0b0 1 0 1 0 000;
		key[14]= (int)0b0 1 0 0 1 000;
		key[15]= (int)0b0 1 0 0 0 000; //16 Zeros+8zeros
		16 zeros -> 3 bits
		8 bits -> 
		
		invertedKey[0] = 0b0 0 1
		invertedKey[1] = 0b0 0 1
		invertedKey[2] = 0b0 0 1 
		invertedKey[3] = 0b0 0 1
		invertedKey[4] = 0b0 0 1
		invertedKey[5] = 0b0 0
		invertedKey[6] = 0b0 0
		invertedKey[7] = 0b0 0
		invertedKey[8] = 0b1 0
		invertedKey[9] = 0b1 0
		invertedKey[10]= 0b1 0
		invertedKey[11]= 0b1 0
		invertedKey[12]= 0b1 0 
		invertedKey[13]= 0b1 0
		invertedKey[14]= 0b1 0
		invertedKey[15]= 0b1 0
		
		another[0] = (int)0b01110000; 	// 112, 7
		another[1] = (int)0b01100001; //96,6
		another[2] = (int)0b01010010; // 5
		another[3] = (int)0b01000011; // 4
		another[4] = (int)0b00110100; //3
		another[5] = (int)0b00100101; 
		another[6] = (int)0b00010110;
		another[7] = (int)0b00000111; 
		another[8] = (int)0b11111000; //15
		another[9] = (int)0b11101001;
		another[10]= (int)0b11011010;
		another[11]= (int)0b11001011;
		another[12]= (int)0b10111100;
		another[13]= (int)0b10101101;
		another[14]= (int)0b10011110;
		another[15]= (int)0b10001111;
		
		17d -> 10001b
		//9d -> 1001
		
		printKey(key);
	
	System.out.print("\n");
	printKey(invertedKey);
	System.out.print("\n");
	
	printKey(another);
	System.out.print("\n");
	
		// x |= (1 << y); // set the yth bit from the LSB
		
	
	*/
	
	}
	
	/* For Permutation , 32 times 8 positions , and permute -> time 370528=> 
	 * 370,528 sec
	 *  6.175466667 minutes
	 * 

	 * 
	 * For Permutation1 , 32 times 8 positions, 
	 * Time elapsed 70902

*/
	
	
	
	public static void main(String[] args) {
		prefix();
		//Permutation_All.check
		

	}

}

