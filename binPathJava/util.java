package binPathJava;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class util {

	public static File cipherFileJava  = new File("/home/andrec/workspace_3_8/binPath/files/ciphertext_java");
	public static File cipherFileC  = new File("/home/andrec/workspace_3_8/binPath/files/ciphertext_c");
	
	//https://stackoverflow.com/questions/12944377/how-to-convert-byte-to-byte-and-the-other-way-around
	public static Byte[] toObjects(byte[] bytesPrim) {

	    Byte[] bytes = new Byte[bytesPrim.length];
	    int i = 0;
	    for (byte b : bytesPrim) bytes[i++] = b; //Autoboxing
	    return bytes;

	}
	
	public static byte[] toPrimitives(Byte[] oBytes)
	{

	    byte[] bytes = new byte[oBytes.length];
	    for(int i = 0; i < oBytes.length; i++){
	        bytes[i] = oBytes[i];
	    }
	    return bytes;

	}
	// longToBytes, and bytesTolong from
	// https://stackoverflow.com/questions/4485128/how-do-i-convert-long-to-byte-and-back-in-java
	public static Byte[] longToBytes(long l) {
	   Byte[] result = new Byte[8];
	    for (int i = 7; i >= 0; i--) {
	        result[i] = (byte)(l & 0xFF);
	        l >>= 8;
	    }
	    return result;
	}

	public static long bytesToLong(final byte[] b) {
	    long result = 0;
	    for (int i = 0; i < 8; i++) {
	        result <<= 8;
	        result |= (b[i] & 0xFF);
	    }
	    return result;
	}
	// linux, use tee to write plaintexts to file
	public static void writeFile() {
		try {
			
			
			FileWriter fw = new FileWriter(AES.plaintextsPath,false);
			// List of all plaintexts as byte[]
			ArrayList temp  =AES.allPlainTexts;
		for (int i=0; i < temp.size() ; i++) {
			byte[] bc = (byte[]) temp.get(i);
				String str = getPlaintext(bc);
				fw.write(str+"\n");
			}
			
		
		
		System.out.println("[util.writeFile] Wrote plainTexts files");
		fw.close();
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

public static void printAllPlaintexts() {
	int index = 0;
	
	byte[] b;
	for (int i=0; i < AES.allPlainTexts.size(); i++) {
		System.out.println();
		// type of b (byte[])
		b = (byte[]) AES.allPlainTexts.get(i);
		System.out.println(Arrays.toString(b));
		index++;
	}
	System.out.println("\nNumber of plaintexts printed "+index);
		
	
	}

	
	public static DateTimeFormatter returnFormatter() {
		  DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
		  return dateFormat;
		  
	}
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


	 
	 // l  represents the long (key to be checked for ascii)
      public static boolean isAscii(byte[] keyToBeTested,boolean debug) {
    	   
    	  if (debug) 
    		  printArray("isAscii",keyToBeTested,true);
    		 
      		 for (byte b: keyToBeTested) {
      			 if ( b > 0x7f | b <=0x20) {
      					if (b!=0)
      						return false;
      				}
      		 }
      		
          return true;
    	 
      }
      
      
      
      public static String getPlaintext(byte[] bArr) {
    	  
    	  char [] temp = new char[bArr.length];
    	  
    	  for (int i=0; i < bArr.length; i++) {
    		  if (bArr[i] != 0)
    			  temp[i] = (char) bArr[i];
    		  else
    			  temp[i] = '0';
    	  }
    	  
    	  String s= new String(temp);
    	  
    	  return s;
    	  
      }
      	 	
public static boolean isAscii(Byte[] keyToBeTested,boolean debug) {
    	 
    	
    	  
    	  if (debug) {
    		  
    		  printArray("isAscii",keyToBeTested,true);
    	  }
    		 
      			for (byte b: keyToBeTested) {
      				
      				if ( b > 0x7f | b <=0x20) {
      					if (b!=0)
      						return false;
      				}
      			}
          return true;
    	 
      }
      
      public static void printArray(String arrayName,Byte[] arr,boolean printChars) {
  		
		  System.out.println("---begin array ("+arrayName+")---");
		  System.out.println("Array length : "+arr.length);
		  
		  char c; 
	     	for (byte b : arr) {
	     		
	     		if (printChars) {
	     				if (b == 0)
	     					c = '0';
	     				else
	     				c = (char) b;
	     				System.out.print(c + ",");
	     		}
	     		else {
	     			if (b==0)
	     				System.out.print("0"+",");
	     			else
	     				System.out.print(b + ",");
	     		}
	     	
	     	}
	     	System.out.println("\n---end array ---");
		
	}
		// showChars, instead of ascii number return character
	  // print values == true => print values instead of characters
	  
	public static void printArray(String arrayName,byte[] arr,boolean printChars) {
		
		  System.out.println("---begin array ("+arrayName+")---");
		  System.out.println("Array length : "+arr.length);
		  
		  char c; 
	     	for (byte b : arr) {
	     		
	     		if (printChars) {
	     				if (b == 0)
	     					c = '0';
	     				else
	     				c = (char) b;
	     				System.out.print(c + ",");
	     		}
	     		else {
	     			if (b==0)
	     				System.out.print("0"+",");
	     			else
	     				System.out.print(b + ",");
	     		}
	     	
	     	}
	     	System.out.println("\n---end array ---");
		
	}
	 public static String printShortBits(int number,String modeOfPrint,boolean printLeadingZeros) {
 		int t = (number & 0xff);
 		
 		String firstByte= printBits(t,printLeadingZeros);
 		
 		t = ((number >> 8) & 0xFF);
 		
 		
 		String secondByte = printBits(t,printLeadingZeros);
 		
 		String ret= secondByte + " " + firstByte + " " +number+"(d) "; 
 		if (modeOfPrint.equals("list") || modeOfPrint.equals("listed"))
 			ret+=",";
 		else
 			ret+="\n";
 		return new String(ret); 
 	}



     public static String printIntBits(int number,String modeOfPrint,boolean printLeadingZeros) {
     	
     		int t = number & 0xff;
     		String ret="";
     		String firstByte= printBits(t,printLeadingZeros);
     		
     		t = ((number >> 8) & 0xFF);
     		
     		String secondByte = printBits(t,printLeadingZeros);		
     				
     		t = ((number >> 8) & 0xFF);
     		
     		String thirdByte = printBits(t,printLeadingZeros);
     		t= ((number >> 8) & 0xFF);
     		
     		String fourthByte  =printBits(t,printLeadingZeros);
     		t=  ((number >> 8) & 0xff);
     		
     		ret = fourthByte + " " + thirdByte + " "  +secondByte + " " + firstByte+"  (d) "+number ; 
     		 return ret;  
     	   
     	}

     
     public static String printBits(int b,boolean printLeadingZeros) {
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
     // mode -> it is print with newline or not
 /*    public static void printArray(Byte[] arr,String mode) {
     	System.out.println("----Beginning of Array-----");
     	for (int it : arr) {
     		printBits(arr[it],true);
     		if (mode.equals("new"))
     			System.out.println();
     	}
     		
     	System.out.println("----End of Array-----");
     
     }
     
     public static void printArray(Integer[] arr,String mode) {
     	
     	System.out.println("----Beginning of Array-----");
     	for (int it : arr) {
     		printBits(arr[it],  true);
     		if (mode.equals("new"))
     			System.out.println();
     	}
     		
     	System.out.println("----End of Array-----");
     	
     }
     
   */
     public static void printUsingFunction() {
 	    
 	    
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
}
