package binPathJava;

import java.util.Arrays;
import java.util.Vector;

import binPathJava.Permutation;

public class binPathImpl {

	
//java.util.Arrays
//System.arraycopy(copyFrom, 2, copyTo, 0, 7);
	
	public static int[] setOneToAll() {
		int[] ret = new int[256];
		for (int i=0; i < 256 ; i++) {
			ret[i] = i;
		}
		return ret;
	}
		
	public static void printPositions() {
	    
	    int pos = 1;
	    int temp = pos;
	    for (int i = 1 ; i < 9 ; i++) {
	    pos = temp;
	    System.out.print("\n public static byte[] pos_"+pos+" = { "+pos+" , ");
	    for (int i2=0; i2 < 31; i2++) {
	        pos+=8;
	        if (pos > 128 )
	        	System.out.print(" (byte) ");
	        else if (pos < -127)
	        	System.out.print(" (byte) ");
	        System.out.print(pos+" , ");

	    }
	    System.out.print(" } ");
	    temp++;
	    }
	    
	}

	
	private void printUsingFunction() {
	    
	    
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
	
	
        /* 
         * 
         * FROM Maghoumi
         * https://stackoverflow.com/questions/5263187/print-an-integer-in-binary-format-in-java
         * System.out.println(intToString(5463, 4));
         * Converts an integer to a 32-bit binary string
         * @param number
         *      The number to convert
         * @param groupSize
         *      The number of bits in a group
         * @return
         *      The 32-bit long bit string
         */
        public static String intToString(int number, int groupSize) {
            StringBuilder result = new StringBuilder();

            for(int i = 31; i >= 0 ; i--) {
                int mask = 1 << i;
                result.append((number & mask) != 0 ? "1" : "0");

                if (i % groupSize == 0)
                    result.append(" ");
            }
            result.replace(result.length() - 1, result.length(), "");

            return result.toString();
        } 
        
        
       
        
        private static <T> Vector<Integer> getThreeBitsMarkerM(int num_three_bits) {
        	Vector<Integer> threeBitsMarker= new Vector<>();


        	int num = 0;
        	
 
        	// etapa = 66536
        	double etapa = Math.pow(2,num_three_bits)  / 65536;
        	
        	 num = 7;
        	threeBitsMarker.add(new Integer(num));
        	num+=8;
        	
        	//int it = 0;
        	int it2 =1;
        	int total=0;
        	
        	
        	for (double i=0 ; i < etapa; i++) {
        		threeBitsMarker.add(new Integer(num));
        		num+=8;
        		
        		it2++;
        		total++;
        		System.out.println(i);
        	}
        
        	System.err.println("\nTotal markers : "+total);
        	return threeBitsMarker;
        	
        }
        
        
        
        // FROM https://mkyong.com/java/java-how-to-convert-a-byte-to-a-binary-string/
        private static void printBits(byte b) {
        	String resultWithPadZero = String.format("%8s", Integer.toBinaryString(b))
                    .replace(" ", "0");
        	    System.out.println(resultWithPadZero+"  (d) "+(int) b);
        	   

        	   
        	}
/*
 * 2elems -> 2 posicoes 2^2 3
 *  primeiroByte[1...256]	primeirobyte[1...256]
	 segundo byte[1...256] primeirobytye[1...256]
	 segundobyte[1...256] segundobyte[1...256]
	primeriobytye[1..256] segundo[1...256]
 */
//     /  2^8 * 2^8   * 2^8 * 2^8
       
       
       
        private static void prefix() {
        	int[] firstByte;
        	int[][] secondByte;
        	int[][] thirdByte;
        	int[][] fourthByte;
        	int[] cByte = setOneToAll();
        	
        	
        		  
        		firstByte = cByte;
       		
        		
        		int begin = 0;
        		int finalB = (int) Math.pow(2,8);
        	
        		int intervalSize = finalB -begin;
        		
        		
        		System.out.println("\nBegin : "+begin);
        		System.out.println("\nFinalB  : "+finalB);
        		System.out.println("\nintervalSize  : "+intervalSize);
        		
        		// from byte1 to byte2 
        		// from byte2 to byte3, etcc...the interval is always the same, and the elements in the interval are also all equal
        		// 256 -> is the number of elems in each iteration (each interval has 256*intervalSize
        		// the intervals are all equals 255*intervalsize
        		// 
        		int[][] interval = new int[intervalSize][256];
        		
        		// Number of interval which is equal number of bytes  (1----8 ----16---24) = 4
        		int numIntervals = 32 / intervalSize;
        		for (int i=0; i < intervalSize; i++) {
        			interval[i] = cByte;
        		}
        		// copy interval to other array
        		secondByte = interval;
        		thirdByte = interval;
        		fourthByte = interval;
        		
        			
        		//	printArray(cByte);
        		
        		
        			
        		
        }
        
        private static void printArray(int[] arr) {
        	System.out.println();
        	for (int elem = 0 ; elem < arr.length; elem++)
        		System.out.print(" , "+String.valueOf(elem));
        	System.out.println();
        	
        }
        private static void printThreeBits(int num_three_bits) {
        	
        	Vector<Integer> threeBitsMarker= new Vector<>();
        	
        	threeBitsMarker = getThreeBitsMarkerM(num_three_bits);
        			
        	//[65536,131072,262144]
        		
        			
        	int sizeA = threeBitsMarker.size();
        	
        	Integer[] pos = new Integer[sizeA];
        	
        	threeBitsMarker.copyInto(pos);
        	
        			for (int sizeOfMarker =0 ;  sizeOfMarker <= 7 ; sizeOfMarker++) {
        				//printArray(pos);
        				for (int i = 0 ; i < pos.length; i++) {
        					pos[i]++;
        					
        				}
        			}	
        		
        	
        	
        }
        public static void main(String[] args) {
    		prefix();
        }	
}
			