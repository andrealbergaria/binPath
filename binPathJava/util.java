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
	public static File decryptedStuffFile = new File ("/home/andrec/workspace_3_8/binPath/files/decrypted");
	
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


	  public static <T> void printArray(T[] arr) {
		  System.out.println("---begin array---");
	     	for (T e : arr) {
	     		System.out.print(e + ",");
	     	}
	     	System.out.println("---end array ---");
	     }
	
	  // Reads a section of the log file
	  
	 
	  public static void writePlaintexts(ArrayList<Byte[]> al,int minKey,int maxKey) {
		  try {
			  byte[] list;
			  if (al.size()<=0)
				  System.out.println("\n[util.writePlainText] No plaintext between ("+minKey+") ("+maxKey+")");
			  for (Byte[] bArr : al) {
				  list = toPrimitives(bArr);
				  System.out.print("\n[util.writePlainTexts] ");
				  printArray("Plaintext_decrypted ",list,true);
			  }
			  
			  FileWriter fw = new FileWriter(util.decryptedStuffFile,true);
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			  dtf.withZone(ZoneId.systemDefault());
	 		     
				fw.write("date : "+dtf.format(Instant.now())+"\n");
	 			
			  fw.write("minKey : "+minKey+"\n");
			  
			  fw.write("--plaintext : \n");
			  for (Byte[] a : al) {
				   
				  byte[] toWrite =  toPrimitives(a);
				  fw.write(new String (toWrite)+"\n");  
			  }
			  fw.write("--end\n");
				  fw.write(maxKey+"\n");
		  System.out.println("\n[util.writePlaintexts] finished");
		  fw.close();
	      
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

      public static boolean isAscii(Byte[] input) {
    	 
      			for (byte b: input) {
      				if ( b > 0x7f | b <=0x20)
      					return false;
      			}

          return true;
      }

      	 	

		// showChars, instead of ascii number return character
	  // print values == true => print values instead of characters
	  
	public static void printArray(String arrayName,byte[] arr,boolean printValues) {
		
		  System.out.println("---begin array ("+arrayName+")---");
		  System.out.println("Array length : "+arr.length);
		  int it=0;
		  char c; 
	     	for (byte b : arr) {
	     		
	     		if (printValues) {
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
	     		it++;
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
