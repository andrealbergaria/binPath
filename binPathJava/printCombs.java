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
		    
		    int  s = (int) Math.pow(2, numberOfBits);
		    
		    System.out.println("\nNumber of elems printed "+s);
		    
		    int t=7;
		    int it=0;

		    ArrayList<Integer> threeBits = new ArrayList<>();
		    
		    if (args[2].equals("listed"))
		        System.out.print("{ ");
		    String resultToPrint = "";
		    for (int i = 0; i< s ; i++) {
		    	//if (args[2].equals("tuples")) 
		    	//	binPathImpl.printTuples(startByte);
		    	//else
		    	
		    	
		    	if (numberOfBits >= 1 && numberOfBits <= 8) {
		    		resultToPrint = binPathImpl.printBits((byte)startByte, args[2],true);
		    		System.out.print(resultToPrint);
		    		
		    	}
	    		else if (numberOfBits >= 8 && numberOfBits <=  16 ) {
		    		resultToPrint = binPathImpl.printShortBits((short)startByte,args[2],true);
		    		System.out.print(resultToPrint);
	    		}

	    		else if (numberOfBits >= 16 && numberOfBits < 33) {
	    			resultToPrint = binPathImpl.printIntBits((int) startByte,args[2],true);
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
		    
		    System.out.println("Number of three bits : "+threeBits.size());
		    
		    
		    for (int i=0; i < threeBits.size() ; i++) {
		    	 	 
		    		System.out.print(threeBits.get(i)+",");
		    	
		    }
			
		}
	

}
