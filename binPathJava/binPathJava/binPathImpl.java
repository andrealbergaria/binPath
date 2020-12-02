package binPathJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Vector;

import binPathJava.Permutation;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class binPathImpl {

	 

// NEEDS 8 ints (32bytes/4bytes)
	public static int[] setOneToAll() {
		int[] ret = new int[256];
		for (int i=0; i < 256 ; i++) {
			ret[i] = i;
		}
		return ret;
	}
		// it is 32,64,128....
	public static void printPositions(int it) {
	    
	    int pos = 1;
	    int temp = pos;
	    int number = 1;
	    for (int i = 1 ; i < 9 ; i++) {
	    pos = temp;
	    System.out.print("\n public static byte[] pos_"+pos+" = { "+pos+" , ");
	    for (int i2=1; i2 <= it; i2++) {
	        pos+=8;
	        number++;
	        if (pos > 128 )
	        	System.out.print(" (byte) ");
	        else if (pos < -127)
	        	System.out.print(" (byte) ");
	        System.out.print(pos+" , ");

	    }
	    System.out.print(" } Total Len  "+number);
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
        
        private static void printShortBits(short number) {
    		String resultWithPadZero = String.format("%8s",Integer.toBinaryString(number).replace(" ", "0"));
        	    System.out.println(resultWithPadZero+"  (d) "+number);
        	   
    	   
    	}



        private static void printIntBits(int number) {
        		String resultWithPadZero = String.format("%8s",Integer.toBinaryString(number).replace(" ", "0"));
            	    System.out.println(resultWithPadZero+"  (d) "+number);
            	   
        	   
        	}

        
        // FROM https://mkyong.com/java/java-how-to-convert-a-byte-to-a-binary-string/
        private static void printBits(byte b) {
        	String resultWithPadZero = String.format("%8s", Integer.toBinaryString(b))
                    .replace(" ", "0");
        	    System.out.println(resultWithPadZero+"  (d) "+(int) b);
        	   

        	   
        	}
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
	 
	 

 */
     
       
       
       
        private static int[][][] prefix(int numberOfBytes) {
        	int[] firstByte;
        	int[][][] bytesArray;
        	
        	//int[][] fourthByte;
        	int[] cByte = setOneToAll();
        	
        		
        		  
        		
       		
        		
        		int begin = 0;
        		int finalB = (int) Math.pow(2,8);
        	
        		int intervalSize = finalB -begin;
 
        		bytesArray = new int[intervalSize][256][numberOfBytes];
        		bytesArray[0][0] = cByte;
        		
        		
        		// to get the next byte, we duplicate or divide the first byte 
        		
        		byte table;
        		
        		// 1 byte tem 256 combs (2^8)
        		// 2 bytes tem 2^16 vombs (65535) (2^8 * 2^8)
        	/*								1byte * 1 byte
        	  							8				8
        	 		B = base byte
        													
        													24 combs -> 8*3
        													0 B 
        													B 0
        													B B
        													
        													4 bits   cobms-> 8*4
        													2^4 = 16 
        													
        													
        													faz os arranjos com repetição 2^4, e vai substituindo B pelo byte
        													0 0 0 B
        	
        							
        											para 8 ints => 2^8 = 255
        											{0,0,0,0,0,0,B}		
        	
        	 		/*
        		*
        		*()								
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
        			interval[i] = cByte;
        		}
        		
        		for (int i=1 ; i < numberOfBytes; i++) {
        			bytesArray[i] = interval;
        		}
        		return bytesArray;
        		// Number of interval which is equal number of bytes  (1----8 ----16---24) = 4
        		
        		// copy interval to other array
        		
        		
        }
        
        private static void printArray(int[] arr) {
        	System.out.println();
        	for (int elem = 0 ; elem < arr.length; elem++)
        		System.out.print(" , "+String.valueOf(elem));
        	System.out.println();
        	
        }
        private static void printArray(byte[] arr) {
        	System.out.println();
        	for (int elem = 0 ; elem < arr.length; elem++)
        		System.out.print(" , "+String.valueOf(elem));
        	System.out.println();
        
        }
        /*
         * openssl enc -aes-256-cbc -in plaintext.txt -base64 -md sha1
         * openssl enc AES256 -out cipherText -e -iv 0x0 -K abcabcab -nosalt -p
-p, -P
    Additionally to any encryption tasks, this prints the key, initialization vector and salt value (if used). If -P is used just these values are printed, no encryption will take place.
    -K key
    -e or -d encrypto r decryt

         */
        private static void createPlainText(File f) {
        	try {
        		
        	FileOutputStream fos = new FileOutputStream(f);
        	byte[] toWrite;
        	
        	String t = "";
        	for (int i=0 ; i < 32 ; i++)
        		t+="a";
        		
        	toWrite  = t.getBytes();
        	System.out.println("\n wrote "+t.length()+" to "+f.getName());
        	}
        	catch(IOException e) {
        		e.printStackTrace();
        	}
        	
        }
        
        private static void AEShelp(File f) {
        	try {
       	 byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
       	 IvParameterSpec ivspec = new IvParameterSpec(iv);
         
         FileInputStream fis = new FileInputStream(f);
         int fileSize = (int) f.length();
         byte[] cipherText = new byte[fileSize];
         
         int numBytesRead = 0;
         numBytesRead = fis.read(cipherText);
         if (numBytesRead  <= 0) {
        	 System.err.println("Read returned error or zero");
        	 System.exit(-1);
         }
         
         else
        	 System.out.println("Read "+numBytesRead);
         		if (cipherText.length != 32) {
         			System.err.println("\n Ciphertext not size of block");
         			System.exit(-1);
         		}
         		if(numBytesRead != 32 ) {
         			System.err.println("\n Didnt read the correct bytes from ciphertext");
         			System.exit(-1);
         		}
         		
         		
         }
         catch(FileNotFoundException e) {
         		e.printStackTrace();
        }
        	catch(IOException e) {
        		e.printStackTrace();
        	}
        }
        
        private static void AESPower(SecretKeySpec s, IvParameterSpec iv) {
        	//try  {
        		
        		/*if (key.length != 32) {
        			System.err.println("\nKey is not in a block size");
        			System.exit(-1);
        		}
        	
        	 
        	 
            
             
             
             Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	         cipher.init(Cipher.DECRYPT_MODE, sks,ivspec);
	         
	         // Read cipherText
	         
	         byte[] decrypted =cipher.doFinal(cipherText);
	          printArray(decrypted);
	          
	         
        	}
        	catch(InvalidAlgorithmParameterException e) {
        		e.printStackTrace();
        	} catch (InvalidKeyException e) {
				 
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				 
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				 
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				 
				e.printStackTrace();
			} catch (BadPaddingException e) {
				 
				e.printStackTrace();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
			*/
	          
             
        	
        } 
        private static void printThreeBits(int num_three_bits) {
        	
        	Vector<Integer> threeBitsMarker= new Vector<>();
        	
        	threeBitsMarker = getThreeBitsMarkerM(num_three_bits);
        			
        	//[65536,131072,262144]
        		
        			
        	int sizeA = threeBitsMarker.size();
        	
        	Integer[] pos = new Integer[sizeA];
        	
        	threeBitsMarker.copyInto(pos);
        	
        			for (int sizeOfMarker =0 ;  sizeOfMarker <= 7 ; sizeOfMarker++) {
        				//printArray(pos);
        				for (int i = 0 ; i < pos.length; i++) {
        					pos[i]++;
        					
        				}
        			}	
        		
        	
        	
        }
        
      
        public static void main(String[] args) {
        	// 2^6 = 64
    		printPositions(64);
    	/*	int[][][] bytes =  prefix(32);
        	for (int i=0 ; i < 4; i++ ) {
        		byte[] key = bytes [0][0][0]
        	}
    		// createPlainText(new File("files/plaintext"));
        	SecretKeySpec sks = new SecretKeySpec(,"AES");
        	AESPower(s, iv)*/
        	
        }	
}
			