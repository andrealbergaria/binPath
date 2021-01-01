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
        		 
        		 --Para 1 b----

        		 
        	----2bits----
        	[b,0]	 X
        	[0,b] 
        		 
        	 
        		 
        	----3bits----
        	
        	[b,0,0]	X
        	[0,b,0] 
        	[0,0,b] 
        	[0,b,b]
        	[b,b,b] X  
        	[b,b,0] X 
        	[b,0,b] X
        	
        	If 3 bits are key tested (using full combs),4 bits that do not have a leading zero will be good   
        	
        	---4bits---
         1combs = number of bs=1)
        		  
        	[b,0,0,0}		X
        	[0,b,0,0]	 
        	[0,0,b,0]	
        	[0,0,0,b]   
        		 
        		
				3combs (number of bs = 2)
			[0,0,b,b]	
			[0,b,0,b}   
			{b,0,0,b]   X
			[0,b,b,0]   
			{b,0,b,0]	X
			[b,b,0,0] 	X
			
			3combs (number of bs = 3)
			(0,b,b,b)	
			(b,b,b,0)  X 
			(b,0,b,b)  X
			(b,b,0,b)  X
		
			X are numbers not leading zeros

			4 bits = Total combs = 16 combs. . Leading zero = 7 combs -> Useful combs 16-7 = 9
			3 bits => Total combs = 8 combs    Leading zero = 3 combs -> Useful combs 8-3 = 5

			For example, if i want to send (0,b,b,0), and sent (0,b,0,0)
			(0,1,1,0) (0,1,0,0)
			
			  a) (0,1,0,0) is gone =boolean =true;
			  b) (0,0,1,0) i sent as well 
			 
 	 			MATRIX B							MATRIX AES          MATRIX A
			 [0 1 0 0 ]							[1,0,0,1]           	[1 0 1 0]
			 [0 0 1 0 ] ->transform with AES => [0,0,1,0		<=AES	[0,1,1,0]
			 obter matriz igual a outra
			 
			 matrices that after processed , must be compared to the original matrices, to remove equals.
			 
			 for example ,if we have a MATRIX AES
			 is there any other matrix, that processes it?
			 MATRIX A = MATRIX B
			 (general case of eleminating elems)
			 (in the former case, we ignored leading zeros)
			 
			 rearranjing elems. The row sum , must be equal.
			 
			row sum is equal
			
			use  numbers,, like (0,1,1,0) = 6 , 
			 
			 			check which number have 6 as factor
			 			
			 			(1,1,0,0) = 12
			 			factor(12) = {1,2,3,4,6,12}
			 			 6d				12d			6d
			 			[0 1 1 0 ] = [1,1,0,0] - [0 1 1 0]
			 			
			 			   6D			3d			2d
			 			 [0 1 1 0] = [0,0,1,1] * [0 0 1 0 ]
			 			 
			 			 sum of 6 = 2+2+2		[ 1 0] [1 0] [1 0]
			 			 		  = 3+2+1
			 			 		  = 2+2+2
			 			 		  = 3+3
			 			 		  
			 			 		  [ 1 2 3 ]  = [ 2 1 3 ] =  [1 3 2]
			 			 		  
			 			 		   Se a permutação tiver valores iguais então temos matrices
			 			 		  
			 			 		  
			 			
			 		
			 		using numbers (with bits), we can get an equivalent matrix 
			 		
			 		if the matrix, solves an equation, what is the other matrix that does that?
			 		
			 		if there are several solutions, then there are other matrices
			 		
			 
			 Como representar numeros iguais ? 
			 
			 
			 
			 Posso concluir alguma coisa da chave? (por exemplo (0,1,1,0) não é chave)
			 
			 If they arent the key, 
			 
			 			 como se processa a chave
			 			 
from wikipedia

			 			  16 bytes
			 		[ b1 b2 b3 b4 ]
			 		[ b5 b6 b7 b8 ]
			 		[b9 b10 b11 12]
			 		[b13 b14 b15 b16]
			 		
			 		
			 		
			 			 
			 			 
			-----
			b= 1 (can't be 0) 
			-----
        		 
        		 
        		
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
        		
        		
        		
        		
        		
        }
        		
        /*
         * openssl enc -aes-256-cbc -in plaintext.txt -base64 -md sha1
         * openssl enc AES256 -out cipherText -e -iv 0x0 -K abcabcab -nosalt -p
-p, -P
    Additionally to any encryption tasks, this prints the key, initialization vector and salt value (if used). If -P is used just these values are printed, no encryption will take place.
    -K key
    -e or -d encrypto r decryt

         */
       
        
        public static void getEquals() {
        	int[] arr  = new int[65536];
        	for (int i=0; i < 65536;i++) {
        		
        	}
        }
    	
    	Posso poupar combinações, se usar matrices?
    	quais os valores iguais?
      
        public static void main(String[] args) {
        	
        	fillBytes();
        
        
    		 //byte[] key = new byte[32];
    		 //createPlainText(new File("files/plaintext"));
    		 //SecretKeySpec sk = new SecretKeySpec(key, "AES");
    		//for (int i=0; i < 65535; i++) 
    	//	System.out.print(util.printShortBits(i,"new",true));
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
    		 
    		 
    	
        }	

       	
       	
       	[ ref1, ref2 , ref3
       	 ] array of objecct, store refernecsts
       	 
       	 
       	 since all references  are from object, we can have  array of different elements
       	 
       	 
       	 add element to a array of objects
       	 
       	 
       */
        
       
  
	}
	  
        
	   
	/*
	   
	   
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
		