package binPathJava;

public class printCombs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] threeBits =new int [1500];
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

		    int threeBitsSize=0;
		    
		    if (args[2].equals("listed"))
		        System.out.print("{ ");

		    for (int i = 0; i< s ; i++) {
		    	if (args[2].equals("tuples")) 
		    		binPathImpl.printTuples(startByte);
		    	else
		    		binPathImpl.printBits((byte)startByte,args[1]);

		    	if (startByte == t && args[2].equals("new"))) {
		    	    		System.out.println("   (3bits : "+startByte+" ) ");
		    	    		t+=8;
		    	    		threeBitsSize++;
		    	    		threeBits[it] = startByte;
		    	    		it++;

		    	}

		        if (args[2].equals("listed")) {
		            System.out.print(",");
		            startByte++;
		        }
		        else if (args[2].equals("new")) {
		            System.out.println("\n");
		            startByte++;
		        }
		        else  {
		        	System.out.println("\nUnkown arg");

		        }
		        

		    }
		    System.out.print(" } \n");
		    System.out.println("\n Number of three bits : "+threeBitsSize);
		    
		    while (it > 0) {
		    	
		    	if (args[2].equals("listed")) {
		    		System.out.print(threeBits[it]+",");
			    	it--;
		    	}
		    	else {
		    		System.out.println(threeBits[it]);
			    	if (it % 10 == 0)
			    		System.out.println("\n");
			    	it--;
		    	}
		    		
		    	
		    }
			
		}
	

}
