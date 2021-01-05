package binPathJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;


    

    
   

    

	
	 

	 public class AES {
		 public static byte[] readCipherText(File f) {
	        	int len = (int) f.length();
	        	byte[] cipherText = new byte[len];
	        	try {
	       	 
	         
	         FileInputStream fis = new FileInputStream(f);
	         
	         int fileSize = (int) f.length();
	         
	         if (256 % fileSize != 0) {
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
	         		if (256 % cipherText.length != 0) {
	         			System.err.println("\n Ciphertext not size of block");
	         			System.exit(-1);
	         		}
	         		if(numBytesRead % 2 != 0 ) {
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
		 // not needed use cat > plaintext <<EOF
		/* public static void createPlainText(File f) {
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
	        
	 */
          public static void paste() throws NoSuchAlgorithmException {
        	 
        	  KeyGenerator kg = KeyGenerator.getInstance("AES");
     		 kg.init(256);
     		 SecretKey sk = kg.generateKey();
     		 System.err.println("\nSecretKey (Getalgorithm) : "+sk.getAlgorithm());
     		System.err.println("\nSecretKey (get format) : "+sk.getFormat());
     		System.err.println("\nSecretKey (toString()) : "+sk.toString());
     		System.err.println("\nSecretKey (getClass()) : "+sk.getClass());
     		System.err.println("\nSecretKey :(getEncoded) : "+new String(sk.getEncoded()));
     		System.err.println("\nSecretKey (sk.getEncoded().length) : "+sk.getEncoded().length);
     		 
     		 
     		if (sk.getEncoded().length != 32)
   			 System.err.println("\nSecret Key is not 256bits");
   		 else
   			 System.err.println("\nSecret Key is 256 bits");
     		 
          }
         public static void encrypt(String strToEncrypt,File outputFile,SecretKey key )  {
        		  
        		 
        		 byte[] iv = new byte[16];
        		 int keySize = key.getEncoded().length;
        		 if (keySize != 32 && keySize != 16) {
            		System.out.println("\nKey is neither 32 or 16");
            	}
            	else 
            		System.out.println("\nKey is "+keySize);
            	
            	
                byte[] toEnc = strToEncrypt.getBytes("UTF-8");
                
 			   Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
 		       cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(iv));
 		       System.out.println("\nEncrypting to "+(new String(toEnc)));
 		      
 		       
 		      byte[] out= cipher.doFinal(toEnc);
 		     
 		     System.out.println("\nByte buffer has "+out.length);
 		     

	          
 		    FileOutputStream stream = new FileOutputStream(outputFile);
 		     stream.write(out);
 		     stream.close();
              System.out.println("\nFinished encryption");
           
         }
        	 
	        public static void checkKeys(byte[] cipherText,SecretKeySpec sks) {    
	        try {
	        byte[] iv = new byte[16];
	  		Cipher cipher;
	  		IvParameterSpec ivspec;
	  		cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	  		System.out.println("\n----DECRYPTING------\n");
	  		 	
	  			
	  			 
	        ivspec  = new IvParameterSpec(iv);
	        	 
	        cipher.init(Cipher.DECRYPT_MODE, sks, ivspec);
	        byte[] decrypt =cipher.doFinal(cipherText);
	        	 	System.out.println("\nDecrypt finished\nString decrypted => "+new String(decrypt));
	        	 	
        	}
	  		 
	       
	            catch (NoSuchAlgorithmException e) {
	            	e.printStackTrace();
	            }
	            
	            catch (NoSuchPaddingException e) {
	            	e.printStackTrace();
	            }
	            
	            
	            catch (InvalidKeyException e) {
	            	e.printStackTrace();
	            }
	            
	            
	            catch (InvalidAlgorithmParameterException e) {
	            	e.printStackTrace();
	            }
	            
	            catch (IllegalBlockSizeException e) {
	            	e.printStackTrace();
	            }
	            catch (BadPaddingException e) {
	            	e.printStackTrace();
	            }
	            
	    
	        
	    }
	 }
         
	   



