// FROM
// https://howtodoinjava.com/java/java-security/java-aes-encryption-example/
// And 
// https://howtodoinjava.com/java/java-security/invalidkeyexception-parameters-missing/
//package binPathJava;


    

    import javax.crypto.spec.IvParameterSpec;


    import java.io.*;
    import javax.crypto.KeyGenerator;


    import java.security.AlgorithmParameters;
    import java.io.UnsupportedEncodingException;
	import java.security.MessageDigest;
	import java.security.NoSuchAlgorithmException;
	import java.util.Arrays;
	import java.util.Base64;
    import javax.crypto.SecretKey;
	import javax.crypto.Cipher;
	import javax.crypto.spec.SecretKeySpec;
	 

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
	            
	            
	           
	            
	            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
                IvParameterSpec ivspec = new IvParameterSpec(iv);
         
	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(Cipher.DECRYPT_MODE, key, ivspec);
	            byte[] decrypt =cipher.doFinal(cipherText);
	            System.out.println
	            //return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Error while decrypting: " + e.toString());
	        }
	        return null;
	    }
	    
	    public static void main(String[] args) {
	        encrypt("abcefghijklmnopq","abcefghijklmnopq");
	    }
}


