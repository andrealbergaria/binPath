package binPathJava;

import java.util.ArrayList;
import java.util.List;

public class util {

	public static Integer[] fillByteInt() {
		Integer[] comb = new Integer[256];
		for (int i=0; i < 256; i++) {
			comb[i] = i;
		}
		return comb;
	}
	
	public static List fillByteList() {
		List<Integer> l = new ArrayList<Integer>();
		for (int i=0; i < 256; i++) {
			l.add(i);
		}
		return l;
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
     
     public static void printArray(byte[] arr) {
     	System.out.println("----Beginning of Array-----");
     	for (int it : arr)
     		printBits(arr[it],true);
     		
     	System.out.println("----End of Array-----");
     
     }
     
     private static void printArray(int[] arr) {
     	
     	System.out.println("----Beginning of Array-----");
     	for (int it : arr)
     		printBits(arr[it],  true);
     		
     	System.out.println("----End of Array-----");
     	
     }
     
     private static <T> void printArray(T[] arr) {
     	for (T e : arr) {
     		System.out.print(e);
     	}
     }
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
