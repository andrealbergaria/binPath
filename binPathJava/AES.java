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
	        	System.err.println("\n File size is not a mulitple of 256");
	         	System.exit(-1);
	         }
	         
	         int numBytesRead = 0;
	         
	         numBytesRead = fis.read(cipherText);
	         
	         if (numBytesRead  <= 0) {
	        	 System.err.println("Read returned error or zero");
	        	 System.exit(-1);
	         }
	         
	         else
	        	 System.out.println("(readCypherText) Read "+numBytesRead+" from "+f.getAbsolutePath()+" fileSize "+f.length());
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
		
         
         public static void encrypt(String strToEncrypt,File outputFile,SecretKey key )  {
        	 
        		try {  
        		 
        			System.out.println("\n-------------ENCRYPTING -------------");
        			System.out.println("(AES.encrypt) Key is ");
        			util.printArray("Key used in encryption",key.getEncoded(),true);
        			
        		 byte[] iv = new byte[16];
        		 int keySize = key.getEncoded().length;
        		 if (keySize != 32 && keySize != 16) {
            		System.out.println("\nKey is neither 32 or 16");
            	}
            	else 
            		System.out.println("\nKeySize is "+keySize);
            	
            	
                byte[] toEnc = strToEncrypt.getBytes("UTF-8");
				
 			   Cipher cipher;
 			  cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
 			 cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(iv));
			
 			   System.out.println("\n(AES.encrypt) Encrypting the string \""+(new String(toEnc))+"\" to "+outputFile.getAbsolutePath());
  		      
 		       
  		      byte[] out = cipher.doFinal(toEnc);
 			  if (out.length != outputFile.length())
 				  System.out.println("\n(AES.encrypt) Wrong buffer byte[] on encrypting");
 			  else
 				 System.out.println("\n(AES.encrypt) Buffer ok");
  		     

 	          
  		    FileOutputStream stream = new FileOutputStream(outputFile);
  			stream.write(out);
  			stream.flush();
  			stream.close();
 				
 				
               System.out.println("\n(AES.encrypt) Finished encryption");	
        		}
        		 catch (UnsupportedEncodingException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
                 
			 catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		    catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		    
              
        		  
              catch (FileNotFoundException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
   		     catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
   		     	
  			   catch (IllegalBlockSizeException | BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
         }
        	// 
	     public static String checkKeys(byte[] cipherText,SecretKeySpec sks) {
	    	 String ret=null;
	        try {
	        	
	        	
	        byte[] iv = new byte[16];
	  		Cipher cipher;
	  		IvParameterSpec ivspec;
	  		cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	  		
	  		System.out.println("\n----Validating key  ------");
	  		 	
	  			
	  			 
	        ivspec  = new IvParameterSpec(iv);
	        	 
	        cipher.init(Cipher.DECRYPT_MODE, sks, ivspec);
	        byte[] decrypt =cipher.doFinal(cipherText);
	        ret = new String(decrypt);
	        System.out.println("----Stuff decrypted -----");
	        System.out.println("---(" +ret+ ")----");
	        	 	System.out.println("\n-----Checking valid keys done -----");
	        	 	

	        	 	
	        	 	
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
	            finally {
	            	return ret;
	            }
	    
	        
	    }
	 }
         
	   



