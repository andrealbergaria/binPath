package binPathJava;

import java.awt.print.Printable;
import java.io.File;
import java.nio.ByteBuffer;
import java.time.Instant;


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
     
      
       
      
        
        
        
        	
        	
        	
        
      
      
      
        public static void main(String[] args) { 
        	
        		
        		
            
      			File cipherFile1 = new File("/home/andrec/workspace_3_8/binPath/files/ciphertext1");
      			// Trying several keys at the same time
      			File cipherFile2 = new File("/home/andrec/workspace_3_8/binPath/files/ciphertext2");
      		
      			

      		//byte[] keyFromClang = new byte[32];
	     	
	     	/*for (int i=0; i< keyFromClang.length;i++) {
	     		keyFromClang[i] = 97;
	     		
	     	}*/
	     		
	     	

	     /*	ByteBuffer key = ByteBuffer.allocate(32);
	     	key.clear();
	     	key.putInt(3);
	     	byte[] bytesTest = key.array();

	     	SecretKeySpec tempKey = new SecretKeySpec(bytesTest, "AES");
        	byte[] cipherText1 = AES.encrypt("123one", tempKey,false);
        	
        	AES.writeCipherTextToFile(cipherText1, cipherFile1,true);
        	
        	key.clear();
        	key.putInt(4);
        	bytesTest = key.array();
        	SecretKeySpec secondKey = new SecretKeySpec(bytesTest, "AES");
        	byte[] cipherText2 = AES.encrypt("123two",secondKey,false);
			*/
        	//AES.writeCipherTextToFile(cipherText2, cipherFile2,true);
        	
        //	byte[] cipherText1 = AES.readCipherText(cipherFile1,true);
      	//	byte[] cipherText2 = AES.readCipherText(cipherFile2,true);
        	 
        	
        	int minKey=0;
			int maxKey=65536;
			
			
			//AES.writePrelude(true);
			
		/*	Entry ret = null;
			int i=0;
			//int interval = Integer.MAX_VALUE / maxKey;
			Instant begin = Instant.now();
			int maSize = Integer.MAX_VALUE;
			int test = 2147483647+10;
			System.out.println("INT MAX :"+Integer.MAX_VALUE);
			System.out.println("\nTEST "+test);
			/*for (; i < 65536 && ret == null; i++) {
				
					ret= AES.cycleKey(minKey,maxKey,cipherText1,false);
						
					minKey=maxKey;
					maxKey = maxKey*2;
			}P/	
			if (i >= 2 || ret==null) {
				System.out.println("\nCouldnt find key");
			}
			
			if (ret!=null) {
				System.out.println("\nThe key is "+ret.key);
				System.out.println("\nThe plaintext is "+ret.plainText);
				AES.writeLogSimple(ret,true,true);
			}
				
			*/
			
		//	AES.cycleKey(0,65536,cipherText);
	        //AES.cycleKey(65536,131072,cipherText);
			
	  	
	       
        
       	
        
        
    /*		 // didnt find key get combs
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
        // 1 , 2 , 4 , 8, 16?
	 // Calcular o reverse para cada numero comecado por 0 ou adicionar um um ao inicio
	    // so os qe comecam por zero contam...ou adiciona um um ou reverse os bits
	    // dividir por dois por exemplo Set C, para adicionar zeros.
	    // acresentar zeros a todos os elementos set anteriores, e ao msemo tempo reverse
	    
	    // começo na base e adiciono-lhe uns no final	    
	
		
	
}
}
		