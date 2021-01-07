package binPathJava;

import java.awt.print.Printable;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

import binPathJava.util;


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
     
      
       
      
        
        
        
        	
        	
        	
        
      
      
    //https://javadeveloperzone.com/java-basic/java-convert-int-to-byte-array/
      private static byte[] intToByteArray (  int i )  {
    	  ByteArrayOutputStream bos=null;
    	  try {
    	    bos = new ByteArrayOutputStream();
    	    DataOutputStream dos = new DataOutputStream(bos);
    	    dos.writeInt(i);
    	    dos.flush();
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  finally {
    		  return bos.toByteArray();  
    	  }
    	  
    	    
    	}
      
      
        public static void main(String[] args) { 
        	
        	try {
        		
        		File cipherFile  = new File("/home/andrec/workspace_3_8/binPath/files/ciphertext");
            	
        		
            	
            
      		byte[] cipherText = AES.readCipherText(cipherFile);
      		
      			
      			
	  			
            	
      		 byte[] iv = new byte[16];
	  		IvParameterSpec ivspec = new IvParameterSpec(iv);
	  		 	
      		
 	  		Cipher cipher;
 	  		cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
 	  		
 	  		System.out.println("\n----DECRYPTING------\n");
 	  		
         	// Used on real encryption
 	  		String trueKey = "1234abcdabcdabcdabcdabcdabcdabcd";
	     	
 	  		// Test key
         	String testKey = "1234asddaasdabcdabcdabcdabcdabcd";
       		
	     	System.out.println("True Key  : "+trueKey);
	     	System.out.println("Test Key  : "+testKey);
	     	
	   			 if (testKey.equals(trueKey)) {
	   				 System.out.println("\n(main) Test key not equal to True key");
	   			 }
	   			// Se a chave 
	     	byte[] key = testKey.getBytes();
      		
	     	SecretKeySpec sk1 = new SecretKeySpec(key,"AES");
	    	AES.encrypt("abcd1241",cipherFile ,sk1);
	    	
	  		byte[] randomKey = new byte[32];
	  		byte[] rawKey = new byte[32];
	  		
	  		Random rand = new Random();
	  		
	  		rand.nextBytes(randomKey);
	  		
	  		int it=0;
            for (int i= 2; i < 5 ;i++) {
	  			 
	  			 
	  			 if (i % 5000 == 0 && i != 0) {
	  				 System.out.println("\nReached i : " +i);
	  				 System.gc();
	  			 }
	  	         
	  			
            	rawKey[it] = (byte) i;
            	it++;
            	System.out.println("\nRight key ");
            	System.out.println(trueKey);
            	//System.out.println("\nTrying key ");
            //	util.printArray(rawKey,true);
            	
            	//SecretKeySpec sks = new SecretKeySpec(rawKey,"AES");
            	SecretKeySpec sks = new SecretKeySpec(randomKey,"AES");
            	
            	System.out.println("\nTrying key ");
                	util.printArray("trying random_key",randomKey,true);
            	
	      		cipher.init(Cipher.DECRYPT_MODE, sks, ivspec);
	      		
        	 	byte[] decrypt =cipher.doFinal(cipherText);
        	 	System.out.println("\nDecrypt finished\nString decrypted => "+new String(decrypt));
        	 
    	  		rand.nextBytes(rawKey);

        	 	
            }	
	 	  	
	  			
	  			// cipherFile -> cypherText1
     	  		// cipherFile2 -> cipherText2
 			 //AES.checkKeys(cipherText, sk1);
 			
 			
 			
 			/*
 			 * 
 			 * Other arbitrary decryption
 			 * SecretKeySpec sk2 = getKey(key2);
 			   encryptAux("123",cipherFile2,sk2);
 			 * AES.checkKeys(cipherText2, sk2);
 			 */
 			
 	  		
 			
	  			
	  	//		System.out.println("\nOtherKeySpec-----");
	  	
	  			   
	        	 
        	
	  		 
	  		 
        	}
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
        }
        @Override
        // finalize method is called on object once  
        // before garbage collecting it
        // https://www.geeksforgeeks.org/garbage-collection-java/
        protected void finalize() throws Throwable 
        { 
            System.out.println("Garbage collector called"); 
             
        } 
          
    	//	for (int i=1; i <= 65536; i++) 
    		//	System.out.print(util.printShortBits(i,"new",true));
    		// 2^16 * 2 ^16
    		// didnt find key, get combs 
    		//double sizeOfIt = Math.pow(2,16);
    		//for (int i=65536; i < 65536*8; i++) 
    			//System.out.print(util.printShortBits(i,"new",true));
        
        

        
        
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
		