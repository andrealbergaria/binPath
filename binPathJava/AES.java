package binPathJava;

import java.io.*;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
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
	         		fis.close();
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

 					e.printStackTrace();
 				}
                 
			 catch (NoSuchAlgorithmException e) {

				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				
				e.printStackTrace();
			}
 		    catch (InvalidKeyException e) {
				
				e.printStackTrace();
			} catch (InvalidAlgorithmParameterException e) {
				
				e.printStackTrace();
			}
 		    
              
        		  
              catch (FileNotFoundException e) {
 
  				e.printStackTrace();
  			}
   		     catch (IOException e) {

  				e.printStackTrace();
  			}
   		     	
  			   catch (IllegalBlockSizeException | BadPaddingException e) {

				e.printStackTrace();
			}
		    
         }
         
        		
         public static Byte[] checkKeys(byte[] cipherText,SecretKeySpec sks,boolean debug) {
        	 
	    	 try {
	        	if (debug==true)
	        	System.out.println("\n(checkKeys) Decrypting...");
	        
	        byte[] iv = new byte[16];
	  		Cipher cipher;
	  		IvParameterSpec ivspec = new IvParameterSpec(iv);
	  		cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	  		
	        	 
	        cipher.init(Cipher.DECRYPT_MODE, sks, ivspec);
	        
		     
		      
	        byte[] decrypt =cipher.doFinal(cipherText);
	        Byte[] r = util.toObjects(decrypt);
	        	 return r;	
	        	 	
        	}
	        catch(BadPaddingException e) {
	        	System.out.println("\nBad padding");
	        	
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
         
         public static void cycleKey(int minKey,int maxKey,byte[] cipherText) throws IOException {
        	 ArrayList<Byte[]> plainTexts = new ArrayList<>();
        	 Byte[] plainTextArray;
   			ByteBuffer buf = ByteBuffer.allocate(32);
 			
 			byte[] temporaryKeyBuffer;
 			
 			
// 			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
// 		            .withZone(ZoneId.systemDefault());
 		     
	     for (int key=minKey; key < maxKey ; key++) {
     		if (key % 5000 == 0) {
     			
     			System.out.println("\nMinKey : "+minKey+" MaxKey: "+maxKey);
     			System.out.println("\nRunning ("+key+")");
                log temporaryLog = new log(minKey,maxKey,plainTexts); 
		        temporaryLog.writeLogToFile(log.triedCombinations);
     			
     		}
     		buf.clear();
 			buf.putInt(key);
     		temporaryKeyBuffer = buf.array();
 			SecretKeySpec tryKey = new SecretKeySpec(temporaryKeyBuffer, "AES");
 			// last boolean is to return strnig instead of byte[]
 			 plainTextArray = AES.checkKeys(cipherText,tryKey,false);
 			//plainTextDeciphered byte[]
 			if (plainTextArray!=null) {
 				if (util.isAscii(plainTextArray)==true) {
 					
 					plainTexts.add(plainTextArray);
 					// output to file, and search for good key
 					System.out.println("Good key "+key);

 					
 					
 				}
 			}
         
         }
         
         	 
         }
         }