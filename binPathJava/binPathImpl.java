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

	// first number to multiply 
	// second number to multiply (for example 4*3) = first = 4 last = 3
	 public static boolean isPrime(int first,int last) {
		 int[] positions = new int[first];
		 for (int i=0 ; i< last ; i++) {
			 positions[i] = first;
			 
		 }
		 
		 
		 return true;
	 }
	public static void AlgebraError() {
		double Xnegative = -3;
		double X2 = Math.pow(Xnegative,2);
		double X3 = Math.pow(Xnegative,3);
		
		if (X2 > 0)
			System.err.println("\n X2 is bigger than 0");
		System.out.println("   "+X3);
		if (X2< X3) {
			System.err.println("X neagttive less that X2");
		}

	}
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
	
	
        
       
       
        
        public static String printShortBits(int number,String modeOfPrint,boolean printLeadingZeros) {
    		int t = (number & 0xff);
    		
    		String firstByte= printBits(t,modeOfPrint,printLeadingZeros);
    		
    		t = ((number >> 8) & 0xFF);
    		
    		
    		String secondByte = printBits(t,modeOfPrint,printLeadingZeros);	
    	   
    		return secondByte + " " + firstByte + " (d) "+number;
    	}



        public static String printIntBits(int number,String modeOfPrint,boolean printLeadingZeros) {
        	
        		int t = number & 0xff;
        		String ret="";
        		String firstByte= printBits(t,modeOfPrint,printLeadingZeros);
        		
        		t = ((number >> 8) & 0xFF);
        		
        		String secondByte = printBits(t,modeOfPrint,printLeadingZeros);		
        				
        		t = ((number >> 8) & 0xFF);
        		
        		String thirdByte = printBits(t,modeOfPrint,printLeadingZeros);
        		t= ((number >> 8) & 0xFF);
        		
        		String fourthByte  =printBits(t,modeOfPrint,printLeadingZeros);
        		t=  ((number >> 8) & 0xff);
        		
        		ret = fourthByte + " " + thirdByte + " "  +secondByte + " " + firstByte+"  (d) "+number ; 
        		 return ret;  
        	   
        	}

        
        // FROM https://mkyong.com/java/java-how-to-convert-a-byte-to-a-binary-string/
        public static String printBits(int b,String modeOfPrint,boolean printLeadingZeros) {
        	String e="";
        		if (printLeadingZeros == true) {
        			e = String.format("%8s",Integer.toBinaryString(b));
        			e = e.replace(' ','0');
        		}
        			
        		else
        			e = Integer.toBinaryString(b);
        		
        		return e;
        }
        
        public static void printMissingElems(int min,int max,List Elems) {
        	Integer it;
        	System.out.println(" [ ");
        	for (int i = min ; i < max ; i++) {
        		it = new Integer(i);
        		if (!Elems.contains(it)) {
        			System.out.print(it+",");
        		}
        				
        	}
        	System.out.println(" ] ");
        	
        }
        
        /*public static boolean isBitSet(byte b, int bit) {
        	if (b & bit)
        		return true
        	else
        		return false;
        }
        public static void printTuples(int min,int max) {
        	
        	System.out.print("(");
        	int combs = (int) Math.pow()
        			
        	for (int i=; i <= max; i++) 
        		System.out.print(i+",");
        	
        	System.out.print(")");
        	
      /*  	
        	Trocar para 4 numeros, usa o anterior mais umas quantas
	 		3bits = 1bit = 1
        			2bit = 2
        			3bit= 3
        			
        			(0,0,0)	REV
        			(1,1,1)
        			
        			 	0		4       2       1
        			(0,0,0) (1,0,0)(0,1,0)(0,0,1), para obter a proxima combinação reverse os numeros
        			   3       5     6
        			(0,1,1)(1,0,1)(1,1,0)
        			
        			 4+8		2+8		  1+8					 
        			(1,1,0,0) (1,0,1,0) (1,0,0,1)
        			3+8			5+8			6+8
        			(1,0,1,1) (1,1,0,1) (1,1,1,0)
        			
        			
        			        			faltam 9 e 10
        			        			(1001 e 1010
        	(2,3,1)
        	
        	(3,1,2)
        	(
        	
        	
        	
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
        	int[] cByte = setOneToAll();
        	
        		
        		  
        		
       		
        		
        		int begin = 0;
        		int finalB = (int) Math.pow(2,8);
        	
        		int intervalSize = finalB -begin;
 
        		bytesArray = new int[intervalSize][256][numberOfBytes];
        		bytesArray[0][0] = cByte;
        		
        		
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
        			interval[i] = cByte;
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
        private static void printArray(int[][] table) {
        	
        	System.out.println();
        	int row_len = table.length;
        	System.out.println("\nLEN "+row_len	);
        			for (int j=0 ;j < 256 ; j++) {
        				
        				for (int i=0; i < row_len ; i++)
        					print
        					System.out.print(String.valueOf(table[j][i])+ " ");
        			
        					
        		
        	}
        	
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
        	
        	
        	fos.write(toWrite);
        	System.out.println("\n wrote "+toWrite.length+" to "+f.getName());
        	
        	}
        	catch(IOException e) {
        		e.printStackTrace();
        		System.out.println("\nCOUDLNT CREATE PLAIN TEXT");
        	}
        	
        }
        
        private static void AEShelp(File f) {
        	try {
       	 byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
       	 IvParameterSpec ivspec = new IvParameterSpec(iv);
         
         FileInputStream fis = new FileInputStream(f);
         
         int fileSize = (int) f.length();
         
         if (fileSize % 32 != 0) {
        	System.err.println("\n File size is not a mulitple of 32");
         	System.exit(-1);
         }
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
         			System.err.println("\n Didnt read the number of bytes from ciphertext");
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
        
      /*  private static void AESDecrypt(byte[] cipherText,SecretKeySpec s, IvParameterSpec iv) {
        	try  {
        		
        		if (key.length != 32) {
        			System.err.println("\nKey is not in a block size");
        			System.exit(-1);
        		}
        	
        	 
        	 
            
             
             
             Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	         cipher.init(Cipher.DECRYPT_MODE, s,iv);
	         
	         
	         byte[] decrypted =cipher.doFinal(cipherText);
	          printArray(decrypted);
	          
	         cipher.
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
			
	          
             
        	
        } */
      
        public static void main(String[] args) {
        	fillBytes(5);
        
        
    	/*	int[][][] bytes =  prefix(32);
        	
    		byte[] key = new byte[32];
    		createPlainText(new File("files/plaintext"));
    		 SecretKeySpec sk = new SecretKeySpec(key, "AES");
    		 List<Integer> elements = new ArrayList<>();
    		 
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
        	//AESPower(sks, iv);
        	
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
        
       
  //  AlgebraError();
	}
	  public static void test() {
     	   Byte threeBits[] = {0,1,2,3,4,5,6,7};
     	   Byte[][] fourBits = new Byte[2][8];
     	   fourBits[0] = threeBits;
     	   for (int i=0 ; i < fourBits.length; i++) {
     		   fourBits[1][0] = 1;
     	   }
     			   
     			   
     	   	
        }
        
	   
	  
	/*
	 * Quero derefernciar um array, adicionar um byte, e depois referenciar oura vez
	 * Quero obter uma ref para lista. List a = new ArrayList() ; 
	 *   
	 */
   public static void fillBytes(int numBits) {
	   
	   // 4 bytes (where are 3bits
	   
	   int[] arr = {0,1,2,3,4,5,6,7};
	   
	   int[] firstByte = new int[256];
	   int[] secondByte = new int[256];

	   int[] thirdByte = new int[256];
	   int[] fourthByte = new int[256];

	   int table[][] = { fourthByte,thirdByte,secondByte,firstByte };
	   Vector<Integer> threeBits =new Vector<>(); 
	   //first index = row
	   // Numbver of 3 bits
	   int n=1;
	   for (int x = 1 ; x <= numBits; x++) {
		   n = n*2;
	   }
			
	   for(int i=7 ; i < n ; i += 8 ) {
		      System.arraycopy(arr, 0, firstByte, i, 8);
		      threeBits.add(i);
		}
	   
	   //System.arraycopy(firstByte,0,secondByte,0,256);
	   secondByte = firstByte.clone();
	   thirdByte = firstByte.clone();
	   fourthByte = firstByte.clone();
	   
	   for (int e : threeBits) {
		   secondByte[]
	   }
	   
	   
   }
}
		