package binPathJava;


    

    
   

    
    import javax.crypto.SecretKey;
	import javax.crypto.Cipher;
	 

	 public class AES {
	 
	 
         public static byte[] cipherText = new byte[32]; 
        /*public static String encrypt(String strToEncrypt, String secret) 
	    {
            try {
                byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
                IvParameterSpec ivspec = new IvParameterSpec(iv);
	    
	          
              
                //KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
               // keyGenerator.init(256);
               // SecretKey key = keyGenerator.generateKey();

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
        */	 
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
	    
	    public static void main(String[] args) {
	    //    encrypt("abcefghijklmnopq","abcefghijklmnopq");
	    }
}


