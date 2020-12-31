package binPathJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;



import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class binPathImpl {

	  /*  	
        	Trocar para 4 numeros, usa o anterior mais umas quantas
	 		3bits = 1bit = 1
        			2bit = 2
        			3bit= 3
        			
        			  0 	1
        			(0,0) (0,1)
        			  3	 	2
        			(1,1) (1,0)
        			
        			reverse of 0 -> 3
        			reverse of 1 -> 2
        			
        			 	0		1     2      4
        			(0,0,0) (0,0,1)(0,1,0)(1,0,0) 
        		
        			   7       3     5      6     
        			(1,1,1) (0,1,1)(1,0,1)(1,1,0)
        			
        			 reverse of 7 = 0;
        			 reverse of 1 = 6
        			 reverse of 2 = 5
        			 reverse of 4 = 3
        			
        			
        			
        			8+1			8+2			8+3
        			(1,0,0,1)  (1,0,1,0) (1,0,1,1)
         			 				 
        			  8+4		5+8			6+8
        			(1,1,0,0) (1,1,0,1) (1,1,1,0)
        			
        			
        			        			
        		
        	
        	
        	
        	3^3 combs
        	
        	
        	
        }*/
/*
 * 2elems -> 2 posicoes 2^2 3
 *  primeiroByte[1...256]	primeirobyte[1...256]
	 segundo byte[1...256] primeirobytye[1...256]
	 segundobyte[1...256] segundobyte[1...256]
	primeriobytye[1..256] segundo[1...256]
	
	(1,2,3,4,5,6,7,8)
	
	Pos1 = 1;
	(1,2,3)(3,2,1)(2,1,3)						(2,3,2)(3,2,1)(3,1,2)
	pos1  = 1
	pos2  = 2
	pos3 = 3
	
	 posicao (1,2,3) pos1
	 posicao (3,1,2) pos2
	 posicao (3,2,1) pos3
	 
	 todos os elems = {pos1,pos2,pos3.pos4.pos5.pos6.pos7,pos8}
	 
	 todos os numeros = 255 (pode estar em 8 posições) * 8 = 2048
	 					230 * 8 = 1084
	 					
	 				(255,255,230,23,233)		
	 				(255,1,2,3,4)				255*8
	 				(255,255,255,1,3,2)
	 
	
	
	posso trocar as posições...atribuir cada posição a um elemento 
		Pos+1 (2) Pos+2 (1) Pos+3 (1)
	 	 
	 	 
	 	 (1,3,3)
	 	 (2,1,1)
	 	 
	
	(1,2,3)(3,2,1)(2,1,3)(2,3,2)(3,2,1)(3,1,2)
	 
	 1st byte		2sst byte
	 (1,2,3)		 (2,3,1)        
	 
	 (1,2) (1,3)(1,1)
	 
	 (2,2),(2,3)(3,1)
	 
	 (3,2)(3,3,)(3,1)
	 
	 numero 3-> (1,3)(2,3)(3,1)(3,3)(3,1) => 3A2 -> 6

 */
     
      
       
       
        private static int[][][] prefix(int numberOfBytes) {
        	
        	int[] firstByte;
        	int[][][] bytesArray;
        	
        	//int[][] fourthByte;
        	
        	
        		
        		  
        		
       		
        		
        		int begin = 0;
        		int finalB = (int) Math.pow(2,8);
        	
        		int intervalSize = finalB -begin;
 
        		bytesArray = new int[intervalSize][256][numberOfBytes];
        		//bytesArray[0][0] = cByte;
        		
        		
        		// to get the next byte, we duplicate or divide the first byte 
        		
        		byte table;
        		
        		// Para cada um no inicio, adiciona-se o numero na posicao
        		
        		
        		// 1 byte tem 256 combs (2^8)
        		// 2 bytes tem 2^16 vombs (65535) (2^8 * 2^8)
        		
        			/*
        		 starting position -> end position
        		 
        		 --Para 1 b----

        		 
        	2bits
        	[b,0]
        	[0,b] 1bit
        		 
        	2combs 
        		 
        	3bits
        	
        	[b,0,0]	USED
        	[0,b,0] 2bits
        	[0,0,b] 1bits
        	[b,b,b]USED
        	[0,b,b] 2bits 
        	[b,b,0]USED 
        	[b,0,b]USED
        	
        	4 combs
        	
        		  1combs
        		  
        	[b,0,0,0}		USED
        	[0,b,0,0]	 3 bits -> zero em primeiro 
        	[0,0,b,0]	 2 bits
        	[0,0,0,b]    1bits
        		 
        		
				3combs
			[0,0,b,b]	2 bits
			[0,b,0,b}   3bits
			{b,0,0,b]   USED
			[0,b,b,0]    3 bits
			{b,0,b,0]	USED
			[b,b,0,0] 	USED
			
				3combs
			(0,b,b,b)	3bits
			(b,b,b,0)  USED
			(b,0,b,b)  USED
			(b,b,0,b) USED

			3+3+4+2+1 = 13 combs
			
			
			---1b----
			 (1,0,0,0)(0,1,0,0)(0,0,1,0)(0,0,0,1)
			 
			
			
				 -Para 2b's-----
        		 	 5			3		6				
        		2b = (0,1,0,1)(0,0,1,1)(0,1,1,0)  
        			10			12		9			Para obter os 2b, basta fazer o revert dos numeros que comecam com 0 ou 1
        			(1,0,1,0)(1,1,0,0)(1,0,0,1)		

        		
        		 ---------------------------
        		 
        		 ....Para 3 b's.....
        		 11			 13		 14		  7 
        		 (1,0,1,1)(1,1,0,1)(1,1,1,0)(0,1,1,1) reverse de 1b



        		 
        		 
        	
        		 
        		 	 
        		 	 
        		 
        		 
        		 
        		
        	/*	------| ------|-----|			
        	 * 
        	 
        		1		1			1		
        		2		2			2
        		3		3			3
        		
        		1		4			4
        		2		5			5
        		3		6			6
        		
        		1		1			7
        		2		2			8
        		3		3			9
        		
        		po1 = always 2^8 * 3
        		
        		2nd byte different , 2bytes first is firstbyte
        		
        										
        		
        		1 btyte sempre igual => 2^8
        		2 byte=  => 257 -->265
        		 
        		*/
        		
        		// from byte1 to byte2 
        		// from byte2 to byte3, etcc...the interval is always the same, and the elements in the interval are also all equal
        		// 256 -> is the number of elems in each iteration (each interval has 256*intervalSize
        		// the intervals are all equals 255*intervalsize
        		// 
        		int[][] interval = new int[intervalSize][256];
        		
        		int numIntervals = 32 / intervalSize;
        		for (int i=0; i < intervalSize; i++) {
        			//interval[i] = cByte;
        		}
        		
        		for (int i=1 ; i < numberOfBytes; i++) {
        			bytesArray[i] = interval;
        		}
        		return bytesArray;
        		// Number of interval which is equal number of bytes  (1----8 ----16---24) = 4
        		
        		// copy interval to other array
        		
        		
        }
        // first row
        // second column
      
        		
        /*
         * openssl enc -aes-256-cbc -in plaintext.txt -base64 -md sha1
         * openssl enc AES256 -out cipherText -e -iv 0x0 -K abcabcab -nosalt -p
-p, -P
    Additionally to any encryption tasks, this prints the key, initialization vector and salt value (if used). If -P is used just these values are printed, no encryption will take place.
    -K key
    -e or -d encrypto r decryt

         */
       
        
     
      
        public static void main(String[] args) {
        	
        	fillBytes();
        
        
    		 //byte[] key = new byte[32];
    		 //createPlainText(new File("files/plaintext"));
    		 //SecretKeySpec sk = new SecretKeySpec(key, "AES");
    		for (int i=0; i < 65535; i++) 
    		System.out.print(util.printShortBits(i,"new",true));
    	//	}
    /*		 
    		 ow1 11 11 11 11  255
			  row2 11 11 11 10  254 
			  row3 11 11 11 00  252
			  row4 11 11 10 00 248
			  row5 11 11 00 00 240
			  row6 11 10 00 00 224
			  row7 11 00 00 00 192
			  row8 10 00 00 00 128		
			  
MATRIX B		  row 1 = 00000000 0
			  row 2 = 00000001 1
			  row 3 = 00000011 3
					  00000111 7
					  00001111 15
					  00011111 31
					  00111111 63
					  01111111 254
					  
			  
			    00000001 	1
MATRIX C  		00000010	2
			    00000100	4
			    00001000	8
			    00010000	16
			    00100000	32
			    01000000	64
			    10000000	128
    		 
    		 int binT = 0b11111111;
    		 int binReversed= 0b0000000;
    		 
    		 for (int x=0; x < 8; x++) {
    			 elements.add(binT);
    			 elements.add(binReversed);
    			 binT <<= 1;
    			 binReversed = revertNum(binT);
    			 
    		 }
    		 binT = 0b1;
    		 for (int s = 0 ; s < 8 ; s++) {
    			 elements.add(binT);
    			 binReversed = revertNum(binT);
    			 elements.add(binReversed);
    			 binT *= 2 ;
    		 }
    		 
    		 printMissingElems(0, 256, elements);
    		 
        //	SecretKeySpec sks = new SecretKeySpec(,"AES");
        	
        	
        }	
        */
        
        	
        /*	
        	(0,0,0 )	(0,0,1),(0,1,0)(1,0,0)
       
        rev  (1,1,1)    (1,1,0) (1,0,1)(0,1,1)
        			 zero at begin exclude
         
         a) (1,1,1,1)  (1,1,1,0)(1,1,0,1)(1,0,1,1)
         
    rev  (0,0,0,0)	(0, 0,0,1)(0,0,1,0)(0,1,0,0) USED  (zero at first)
         
         (1,1,1,1,1) (1,1,1,1,0)(1,1,1,0,0)(1,1,0,0,0)(1,0,0,0,0)
         
         
         ALL COMPUTED  (use 3bits) EXCEPT (0,1,1,1,1) 0 at firtst) which is taken by a)
         (0,0,0,0,0) (0,0,0,0,1)(0,0,0,1,1,)(0,0,1,1,1)(0,1,1,1,1)

       
       	(1,1,1,1,1,1)(1,1,1,1,
       	
       	
       	[ ref1, ref2 , ref3
       	 ] array of objecct, store refernecsts
       	 
       	 
       	 since all references  are from object, we can have  array of different elements
       	 
       	 
       	 add element to a array of objects
       	 
       	 
       */
        
       
  
	}
	  
        
	   
	/*
	 * First copy several 256 values in byte one. for 2 bytes its 256^2 
	 *   
	 */
   public static void fillBytes() {
	   // Fill first byte (first combination)
	   Integer[] twoByte = new Integer[65535];
	   Integer[] oneByte = new Integer[65535];
	   Integer[] values = new Integer[256];
	   
	   for (int i = 0 ; i < 256;i++){
		   values[i] = i;
	   }
	   
	   // First and second byte done
	   int v=256;
	   int repeatedElem = 0;
	   for (int i=0 ; i < 65535 ; i+=256) { 
		   
		   System.err.println(i);
		   System.arraycopy(values, 0,twoByte,i, values.length);
		   Arrays.fill(oneByte,i,v,repeatedElem);
		   v+=256;
		   repeatedElem++;
	   }
	   
	   // For third and fourth byte
	   //for (int i=65535; i < 65535; i+=256)]
	   
   }
	   
	   
/*1bit  4 (2bits)  8(3bits)   	 16	(4bits)		32 (5bits)
Set A   Set B     Set C  	    Set D   		Set E  		Set F
(0) 	(0,0)     (0,0,0) 0  		(0,0,0,0) 0    (0,0,0,0,0) 0  (0,0,0,0,0,0)
(1)		(0,1)     (0,0,1) 1       (0,0,0,1) 1	 (0,0,0,0,1) 1  (0,0,0,0,0,1)
	    (1,0) 2    	(0,1,0) 2    (0,0,1,0) 2  (0,0,0,1,0) => Set D (3bits)
	    (1,1) 3    	(0,1,1) 3    (0,0,1,1) 3  (0,0,0,1,1)
	    							 
	    		  (1,0,0) 4	      (0,1,0,0) 4   (0,0,1,0,0)
	    		  (1,0,1) 5       (0,1,0,1) 5   (0,0,1,0,1) => Set D (3bits)
	    		  (1,1,0) 6       (0,1,1,0) 6   (0,0,1,1,0) 
	    		  (1,1,1) 7       (0,1,1,1) 7   (0,0,1,1,1)
	    				
	    							 (1,0,0,0) 8   (0,1,0,0,0)
	    							 (1,0,0,1) 9   (0,1,0,0,1) => Set E (4bits) plus leading 0,which equals 4bits
	    							 (1,0,1,0) 10  (0,1,0,1,0)
	    							 (1,0,1,1) 11  (0,1,0,1,1)
	    							 
	    							 (1,1,0,0) 12 (0,1,1,0,0)
	    							 (1,1,0,1) 13 (0,1,1,0,1) => Set E (4bits) plus leading 0,which equals 4bits
	    							 (1,1,1,0) 14 (0,1,1,1,0)
	    							 (1,1,1,1) 15 (0,1,1,1,1) 16combs of leading zeros
	    							 
	    							 			  (1,0,0,0,0) => 5bits.just change one at the beggiging
	    			
	    			lastComb plus one's,
	    			size(a) = 2^1 (1 elem * 2) 1,0
	    			Start leading ones at
	    			size(b) = size(a)  2,3 (2 elems * 2)
	    			size(c) = size(b) , then add one's starting at size b ,4,5,6,7 (2 elemes* 2)
	    			size(d) = size(c) ,then add one's starting at size c ,8,9,10,11,12,13,14,15 (4* 2 elemes
	    			
	    			*/
	    //Get sets and send to 
	   // {0,1} ADD {0,1}
	   // {0,1,2,3} ADD {2,3}
	   // {0,1,2,3,4,5,6,7} ADD {4,5,6,7}
	  //  {0,1,2,3,4,5,6,7,8,9,...}
	 // Calcular o reverse para cada numero comecado por 0 ou adicionar um um ao inicio
	    // so os qe comecam por zero contam...ou adiciona um um ou reverse os bits
	    // dividir por dois por exemplo Set C, para adicionar zeros.
	    // acresentar zeros a todos os elementos set anteriores, e ao msemo tempo reverse
	    
	    // começo na base e adiciono-lhe uns no final	    
	
		
	
}
		