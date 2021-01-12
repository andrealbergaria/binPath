package binPathJava;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;

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
		 public static byte[] readCipherText(File f,boolean debug) {
	        	int len = (int) f.length();
	        	byte[] cipherText = new byte[len];
	        	
	        	try {
	       	 
	         
	         FileInputStream fis = new FileInputStream(f);
	         
	         int fileSize = (int) f.length();
	         if (debug==true)
	         System.out.println("\nSize of cipher text file "+fileSize);
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
	         
	         else {
	        	 if (debug==true)
	        	 System.out.println("(readCypherText) Read "+numBytesRead+" from "+f.getAbsolutePath()+" fileSize "+f.length());
	         		if (256 % cipherText.length != 0) {
	         			System.err.println("\n Ciphertext not size of block");
	         			System.exit(-1);
	         		}
	         		if(numBytesRead % 2 != 0 ) {
	         			System.err.println("\n Didnt read the number of bytes from ciphertext");
	         			System.exit(-1);
	         		}
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
		
         
         public static void encrypt(String strToEncrypt,File outputFile,SecretKey key ,boolean debug) {
        	 
        		try {  
        		 if (debug==true) {
        			System.out.println("\n-------------ENCRYPTING -------------");
        			System.out.println("\nEncrypting the string \""+strToEncrypt+"\" ("+strToEncrypt.length()+"bytes) to "+outputFile.getAbsolutePath());
        			
        			util.printArray("KEY USED IN ENCRYPTION",key.getEncoded(),false);
        		 }
        		 byte[] iv = new byte[16];
        		 int keySize = key.getEncoded().length;
        		 if (keySize != 32 && keySize != 16) {
        			 if (debug==true)
            		System.out.println("\nKey is neither 32 or 16");
            	}
            	else 
            		if (debug==true)
            		System.out.println("\nKeySize is "+keySize);
            	
            	
                byte[] toEnc = strToEncrypt.getBytes("UTF-8");
				
 			   Cipher cipher;
 			  cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
 			 cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(iv));
			
 			   
  		  
  		      
  		      if (outputFile.delete() == false) {
  		    	  if (debug==true)
  		    	  System.err.println("\n(AES.encrypt) Couldnt delete output file on encrypting");
  		    	  throw new IOException("COULDNT DELETE FILE");
  		    	  
  		    	  
  		      }
  		      
 	          outputFile.createNewFile();
 	         
 	          byte[] out = cipher.doFinal(toEnc);
			  
 	          FileOutputStream stream = new FileOutputStream(outputFile);
 	          stream.write(out);
 	          stream.flush();
 	          stream.close();
 				if (debug==true) {
 	         if (out.length != outputFile.length())
				  System.out.println("\n(AES.encrypt) Buffer not equal to file read (size mismatch) ");
			  else
				 System.out.println("\n(AES.encrypt) Buffer ok");
 				
 				
 				
               System.out.println("\n(AES.encrypt) Finished encryption ("+outputFile.getAbsolutePath()+")");
 				}
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
         
        		
         public static byte[] checkKeys(byte[] cipherText,SecretKeySpec sks,boolean debug) {
        	 
	    	 try {
	        	if (debug==true)
	        	System.out.println("\n(checkKeys) Decrypting...");
	        
	        byte[] iv = new byte[16];
	  		Cipher cipher;
	  		IvParameterSpec ivspec = new IvParameterSpec(iv);
	  		cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	  		
	        	 
	        cipher.init(Cipher.DECRYPT_MODE, sks, ivspec);
	        
		     
		      
	        byte[] decrypt =cipher.doFinal(cipherText);
	        

	        	 return decrypt;	
	        	 	
        	}
	        catch(BadPaddingException e) {
	        	
	        	;
	        }
	  		catch (IllegalBlockSizeException e) {
	  			
	  			System.out.println("\nIllegal Block");
            } catch (NoSuchAlgorithmException e) {
				
				System.out.println("\n[Exception] No such alg");
				
				
				
			} catch (NoSuchPaddingException e) {
				
				System.out.println("\n[Exception] No such padding");
			} catch (InvalidKeyException e) {
				
				System.out.println("\n[Exception] Invalid Key");
				
			} catch (InvalidAlgorithmParameterException e) {
				
				
				System.out.println("\n[Exception] invalid alg");
			}
           	
	    	 return null;
		           
	          
	        
	        
	    }
         
         public static void cycleKey(int minKey,int maxKey,byte[] cipherText) {
        	 ArrayList<Byte[]> al = new ArrayList<>();
        	 Byte[] wrap;
 			ByteBuffer buf = ByteBuffer.allocate(32);
 			byte[] plainTextDeciphered;
 			byte[] temporaryKeyBuffer;

         for (int key=minKey; key < maxKey ; key++) {
     		if (key % 5000 == 0) {
     			System.out.println("\nMinKey : "+minKey+" MaxKey: "+maxKey);
     			System.out.println("\nRunning ("+key+")");
     		}
     		
     		buf.clear();
 			buf.putInt(key);
     		temporaryKeyBuffer = buf.array();
 			SecretKeySpec tryKey = new SecretKeySpec(temporaryKeyBuffer, "AES");
 			
 			
 			
 			plainTextDeciphered = AES.checkKeys(cipherText,tryKey,false);
 			if (plainTextDeciphered!=null) {
 				if (util.isAscii(plainTextDeciphered)) {
 					wrap = util.toObjects(plainTextDeciphered);
 					al.add(wrap);
 					System.out.println("Good key "+key);
 					System.out.println("\nPlainText : "+new String(plainTextDeciphered));
 					
 				}
 			}
         }
         
         util.writePlaintexts(al,minKey,maxKey);
 
         }
         }
	 
     