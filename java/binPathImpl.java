package binPathJava;

public class binPathImpl {

	private void printUsingFunction() {
	    
	    
	    // look at function .. f(pos) = 8*i + pos
	    // int combinations 4294967296
	    // 
	     int t=0;
	     for (int pos = 1; pos < 9;pos++) {
	    	 System.out.println("\nPos "+pos)+"\n");

	        for (int it= 0; it <= 32; it++) {
	            //printf(",%u",t);
	            t = 8*it+pos;
	            if (t % 256 == 0) 
	                System.out.println(t + ", ");
	         }
	        t=0;
	     }
	    
	        
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
