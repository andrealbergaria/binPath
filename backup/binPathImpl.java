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

	//https://www.javatpoint.com/factorial-program-in-java
        public static void factorial(int n) {  
         int fact=1;  
             
         for(int i=1;i<=n;i++){    
             fact=fact*i;    
         }    
         System.out.println("Factorial of "+n+" is: "+fact);    
        }  
        
       
      
        // x |= 0b1; // set LSB bit
        // x |= 0b10; // set 2nd bit from LSB
	private static void prefix() {
		// 256 bits / / 8bits =>  
		byte[] key = new byte[16];
		
		//o toggle a bit use:
		// x ^= (1 << y) | (1 << z); // toggle yth and zth bit
		//	x ^= 0b1;
		// MSB -> 256 index 0;
					  	
		key[0] = 0b01110000;
		key[1] = 0b01100000;
		key[2] = 0b01010000;
		key[3] = 0b01000000;
		key[4] = 0b00110000;
		key[5] = 0b00100000;
		key[6] = 0b00010000;
		key[7] = 0b00000000;
		key[8] = 0b11110000;
		key[9] = 0b11100000;
		key[10]= 0b11010000;
		key[11]= 0b11000000;
		key[12]= 0b10110000;
		key[13]= 0b10100000;
		key[14]= 0b10010000;
		key[15]= 0b10000000;
				    
				     
		System.out.println();
	for (byte b : key) {
		System.out.print(" , "+Integer.valueOf(b));
	}
	System.out.print("\n");
		
	
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
	
	public static void printCombinations(int numElements,int positions) {
		for (int i=0 ; i < numElements ; i++) {
			
		}
	}
  
	
	
	
	
	public static void main(String[] args) {
		prefix();
		//Permutation_All.check
		

	}

}

