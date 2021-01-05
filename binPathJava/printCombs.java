package binPathJava;

import java.util.ArrayList;

public class printCombs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		if (args.length != 3) {
			 System.err.println(" ARG[1] -> number_of_bits_to_print\n");
			 System.err.println(" ARG[2] -> start_byte\n");
			 System.err.println(" ARG[3] -> wheter print bytes in new line,listed or tuples (new | listed | tuples)\n");
			 System.exit(-1);
	   }
		
		  int startByte = Integer.parseInt(args[1]);
		  int numberOfBits =Integer.parseInt(args[0]);
		    
		    
		   System.out.println("\nUsing "+numberOfBits+"  bits\n");
		   System.out.println("\nStarted printing at "+startByte);
		    
		    int  numCombs = (int) Math.pow(2, numberOfBits);
		    
		    System.out.println("\nTrying to print "+numCombs);
		    
		    int t=7;
		    

		    ArrayList<Integer> threeBits = new ArrayList<>();
		    
		    if (args[2].equals("listed"))
		        System.out.print("{ ");
		    String resultToPrint = "";
		    for (int i = 0; i< numCombs ; i++) {
		    	//if (args[2].equals("tuples")) 
		    	//	binPathImpl.printTuples(startByte);
		    	//else
		    	
		    	
		    	if (numberOfBits >= 1 && numberOfBits <= 8) {
		    		resultToPrint = util.printBits(startByte, true);
		    		System.out.print(resultToPrint);
		    		
		    	}
	    		else if (numberOfBits >= 8 && numberOfBits <=  16 ) {
		    		resultToPrint = util.printShortBits(startByte,"new",true);
		    		System.out.print(resultToPrint);
	    		}

	    		else if (numberOfBits >= 16 && numberOfBits < 33) {
	    			resultToPrint = util.printIntBits(startByte,"new",true);
	    			System.out.print(resultToPrint);
	    		}

		    	if (startByte == t && args[2].equals("new")) {
		    	    		System.out.print("   (3bits : "+startByte+" ) ");
		    	    		t+=8;
		    	    		threeBits.add(startByte);
		    	    		

		    	}

		        if (args[2].equals("listed")) {
		            System.out.print(",");
		            startByte++;
		        }
		        else if (args[2].equals("new")) {
		        	System.out.println();
		            startByte++;
		        }
		        else  {
		        	System.out.println("\nUnkown arg");

		        }
		        

		    }
		    if (args[2].equals("listed"))
		    	System.out.print(" } \n");
		    
		    System.out.println("\nNumber of three bits : "+threeBits.size());
		    int elemsPrinted = startByte;
		    System.out.println("\nElements printed "+elemsPrinted);
		    
		    int multiple = threeBits.size();
		    
		    for (int i=1; i < threeBits.size() ; i++) {
		    		// The division equals m, and if the rest of the division of multiple by i (some integer)
		    	    // then m must be integer , and therefore n is multiple of m
		    	     if ( multiple % i == 0) 
		    	 		 System.out.println();
		    		System.out.print(threeBits.get(i-1)+",");
		    	
		    }
			
		}
	
}
