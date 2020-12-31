package binPathJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


    

    
   

    

	
	 

	 public class AES {
		 public static void tryCipher(byte[] key) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
			   SecretKeySpec sks = new SecretKeySpec(key,"AES");
			   byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			   byte[] cipherText = readCipherText(new File("files/plainText"));

			   Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		       cipher.init(Cipher.DECRYPT_MODE, sks,new IvParameterSpec(iv));
		       
		       byte[] decrypted =cipher.doFinal(cipherText);
		       util.printArray(decrypted);
		        
			   }
		 
		 public static byte[] readCipherText(File f) {
	        	int len = (int) f.length();
	        	byte[] cipherText = new byte[len];
	        	try {
	       	 byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	       	 IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
	         FileInputStream fis = new FileInputStream(f);
	         
	         int fileSize = (int) f.length();
	         
	         if (fileSize % 32 != 0) {
	        	System.err.println("\n File size is not a mulitple of 32");
	         	System.exit(-1);
	         }
	         
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
	         		
	         		return cipherText;
	         }
	         catch(FileNotFoundException e) {
	         		e.printStackTrace();
	        }
	        	catch(IOException e) {
	        		e.printStackTrace();
	        	}
	        	return cipherText;
	        }
		 public static void createPlainText(File f) {
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
	        
	 /*
         public static byte[] cipherText = new byte[32]; 
       
         public static String encrypt(String strToEncrypt, String secret) 
	    {
            try {
                byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
                IvParameterSpec ivspec = new IvParameterSpec(iv);
	    
	          
              
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(256);
                SecretKey key = keyGenerator.generateKey();

              Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	          cipher.init(Cipher.ENCRYPT_MODE, key,ivspec);
	          
	          byte[] out= cipher.doFinal(strToEncrypt.getBytes());
	            //return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	            
	            try (FileOutputStream stream = new FileOutputStream("encrypted")) {
                        stream.write(out);
                    }

	            
	            //decrypt(out,key);
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Error while encrypting: " + e.toString());
	        }
	    
	        return null;
	    }
         
	    public static String decrypt(SecretKey key) {
	    
	    try {
	            
	            
	           
	            
	      //      byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            //    IvParameterSpec ivspec = new IvParameterSpec(iv);
         
	       //     Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
             //   cipher.init(Cipher.DECRYPT_MODE, key, ivspec);
	          //  byte[] decrypt =cipher.doFinal(cipherText);
	            //return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Error while decrypting: " + e.toString());
	        }
	        return null;
	    }
	    */	
	    public static void main(String[] args) {
	    //    encrypt("abcefghijklmnopq","abcefghijklmnopq");
	    }
}


