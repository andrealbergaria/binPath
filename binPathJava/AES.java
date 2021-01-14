package binPathJava;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


    

    
   

    

	
	 

	 public class AES {
		 
		 LocalDateTime nowDate;
		 ArrayList<Entry> entries = new ArrayList<>();
		 static File logFile = new File("/home/andrec/workspace_3_8/binPath/files/log");
		 
		 public void writePrelude() {
				try {
					
					DateTimeFormatter df = util.returnFormatter();
					LocalDateTime ldt = LocalDateTime.now();
					String dateString = ldt.format(df);
					
				FileWriter fw = new FileWriter(logFile,true);
				fw.write(dateString+"\n");
				fw.close();
				System.out.println("[writePrelude] completed");
				  
				
				  }
				catch(IOException e) {
					e.printStackTrace();
				}
				  
			}
			
		 
		 public static void writeLogSimple(Entry e) {
				/*
				 * Format of file 
				 * min max
				 * key1 key2 key3
				 * 
				 * 
				 */
				try {
				  System.out.println("\n[writeLogSimple] Running writeLog");
				  FileWriter fw = new FileWriter(logFile,true);
				  fw.write(e.minKey+" "+e.maxKey+" "+"\n");
				  if (e.keys.size() > 0) {
				    for (int i : e.keys)
					  fw.write(i+" ");
				  }
				  else 
					  fw.write("---NULL---\n");
				  fw.close();
				}
				catch(IOException ex) {
					ex.printStackTrace();
					
					
					
					
				}
				
			}
		 
		 
		 public void readLogSimple(String logFiles) {
			  /*
			   * 
			   * format of file
			   * min max
			   * key1 key2 key3
			   * 
			   */
			 System.out.println("[readLogSimple] started");
			  try {
			  Charset cs = Charset.defaultCharset(); 
			  Path path = FileSystems.getDefault().getPath(logFiles); 
			  BufferedReader br = Files.newBufferedReader(path,cs);

			  String dateStr = br.readLine();
			  	  
			  
			  String line=br.readLine();
			  while(line != null) {
				  
				  String line2 = br.readLine();
				  String[] minAndMaxKeys = line.split(" ");
				  String[] KeysString = line2.split(" ");
				  Entry e = new Entry();
				  e.minKey =  Integer.parseInt(minAndMaxKeys[0]);
				  e.maxKey = Integer.parseInt(minAndMaxKeys[1]);  
				  
				  if (!line2.contains("---NULL---")) {
				  // KeysString -> "key1 key2 key3"
				  for (String t : KeysString) {
					  Integer i = Integer.parseInt(t);
					 e.keys.add(i);
				  }
				  }
				  	entries.add(e);
			  }
				 System.out.println("[readLogSimple] finished");

			  }
			  catch(IOException e) {
				  e.printStackTrace();
			  }
		  }
		 
		 public static byte[] readCipherText(File f,boolean debug) {
	        	int len = (int) f.length();
	        	byte[] cipherText = new byte[len];
	        	
	        	try {
	       	 
	         if (!f.exists()) {
	        	 System.out.println("\nCan't read ciphertext "+f.getAbsolutePath()+", since file doesnt exists");
	        	 
	         	return null;
	         }
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
		public static void writeCipherTextToFile(byte[] cipherText,File outputFile,boolean debug) {
			try {
				
					
			
			 FileOutputStream stream = new FileOutputStream(outputFile,false);
	          stream.write(cipherText);
	          stream.flush();
	          stream.close();
				if (debug==true) {
					if (cipherText.length != outputFile.length())
						System.out.println("\n[writeCipherTextToFile] Buffer not equal to file read (size mismatch) ");
					else
						System.out.println("\n[writeCipherTextToFile] Buffer ok");
				}
					System.out.println("[writeCipherTextToFile] wrote bytes("+cipherText.length+") to file ("+outputFile.length()+")");
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
         public static byte[] encrypt(String strToEncrypt,SecretKey key ,boolean debug) {
        	 
        		try {  
        		 if (debug==true) {
        			System.out.println("\n-------------ENCRYPTING -------------");
        			System.out.println("\nEncrypting the string \""+strToEncrypt+"\"");
        			
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
			
 			   
  		  
 	          byte[] out = cipher.doFinal(toEnc);
			  
 	         
 				
               System.out.println("\n(AES.encrypt) Finished encryption ");
               return out;
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
 		    
              
        		  
   		     catch (IOException e) {

  				e.printStackTrace();
  			}
   		     	
  			   catch (IllegalBlockSizeException | BadPaddingException e) {

				e.printStackTrace();
			}
		    return null;
         }
         
        		
         public static byte[] decrypt(byte[] cipherText,SecretKeySpec sks,boolean debug) {
        	 
	    	 try {
	        	if (debug==true)
	        	System.out.println("\n([decrypt] Decrypting...");
	        
	        byte[] iv = new byte[16];
	  		Cipher cipher;
	  		IvParameterSpec ivspec = new IvParameterSpec(iv);
	  		cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	  		
	        	 
	        cipher.init(Cipher.DECRYPT_MODE, sks, ivspec);
	        
		     
		      
	        byte[] decrypt =cipher.doFinal(cipherText);
	        	 return decrypt;	
	        	 	
        	}
	        catch(BadPaddingException e) {
	        	if (debug==true)
	        	System.out.println("\n[decrypt] Bad padding");
	        	
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
         
     
         
         public static void cycleKey(int minKey,int maxKey,byte[] cipherText,boolean debug) {
        	 
        	 
        	 
   			ByteBuffer buf = ByteBuffer.allocate(32);
 			byte[] temporaryKeyBuffer;
 			
 			
 			Entry e = new Entry(minKey,maxKey);
 		 for (int key=minKey; key < maxKey ; key++) {
	    	 if (debug==true)
	    		 System.out.println("\nTrying key : "+key);
     		
	    	 
	    	if (key % 5000 == 0) {
     			
     			e.maxKey = maxKey;
     			e.minKey = minKey;
     			writeLogSimple(e);
     		}
     		buf.clear();
     		// key to be tested
 			buf.putInt(key);
     		temporaryKeyBuffer = buf.array();
 			SecretKeySpec tryKey = new SecretKeySpec(temporaryKeyBuffer, "AES");

 			// returns Byte[] corresponding to plainText decrypting
 			 byte[] decrypted = AES.decrypt(cipherText,tryKey,false);
 			
 			 // use tee program (linux) to print stdout and file
 			 
 			if (decrypted != null) {
 				if (util.isAscii(decrypted)==true) {
 					e.keys.add(key);
 					System.out.println("Got key ("+key+")");
 					System.out.println("Plaintext : "+new String(decrypted));
 				}
 			}
         
         }
         
         	 
         }
         
	 }