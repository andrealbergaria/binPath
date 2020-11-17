package binPathJava;

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
	
	private static void printKey(int[] key){
		System.out.printf("%n 0x%d", key[0]);
		System.out.printf(" , 0x%d", key[1]);
		System.out.printf(" , 0x%d", key[2]);
		System.out.printf(" , 0x%d ", key[3]);
		System.out.printf(" , 0x%d", key[4]);
		System.out.printf(" , 0x%d", key[5]);
		System.out.printf(" , 0x%d", key[6]);
		System.out.printf(" , 0x%d%n", key[7]);
													
	}
	
	private static void prefix() {
		byte[] firstBit256 = new byte [256];
		byte[] firstBit128 = new byte [256];
		byte[] firstBit64  = new byte [256];
		byte[] firstBit32  = new byte [256];
		byte[] firstBit16 =  new byte[256];
		byte[] buffer = new byte[6];
		
	for (int i= 0 ; i< 256; i++) {
		firstBit256[i] = 1;
		if (i >= 128)			//	256 divides between 0 and 1 , when reaching 128... 
			firstBit256[i] = 0;
	}
		
	for (int i=0 ; i < 256;  i++) {
		firstBit128[i] = 1;
		if (i >= 64)
			firstBit128[i]=0;
	}
	
	for (int i = 0 ; i < 256 ; i++) {
		firstBit64[i] = 1;
			if (i >= 32)
				firstBit64[i]=0;
	}
			
	for (int i = 0 ; i < 256; i++) {
		firstBit32[i] = 1;
		if (i >= 16)
			firstBit32[i] = 0;
	}
	
	for (int i=0 ; i < 256; i++) {
		firstBit16[i] = 1;
		if (i >= 8)
			firstBit16[i] =0 ;
	}
	
		for (byte i=0 ; i < 256; i++) {
			buffer[0] = firstBit256[i];
			buffer[1] = firstBit128[i];
			buffer[2] = firstBit64[i];
			buffer[3] = firstBit32[i];
			buffer[4] = firstBit16[i];
			buffer[5] = i;
			System.out.print("\n"+new String(buffer));
			
		}
	
	
	}
	
	
	// Para cada posicao, existe 32 numeros
	//  Falta permutar as posicose para ficar com todos os elems
	private static void checkBytes() {
		
		Integer[]  key = new Integer[8];
		int[] ret = new int[8];
int it=0;
			//for (int it= 0; it < 32; it++) {
            	key[0] = pos_1[it];  
            	key[1] = pos_2[it];
            	key[2] = pos_3[it];
            	key[3] = pos_4[it];
            	key[4] = pos_5[it];
            	key[5] = pos_6[it];
            	key[6] = pos_7[it];
            	key[7] = pos_8[it];
           
          // for (int i= 0 ; i < 3; i++) {
        	   Permutation.permute(8, key, ',');
       //    }
            	//printKey(key);
				//Integer[] arr= { key[0],key[1],key[2],key[3],key[4],key[5],key[6],key[7]};
            	
            	
            	
		//}
		
		
		
	
	}
  
	
	
	
	
	public static void main(String[] args) {
		//prefix();
		checkBytes();

	}

}

