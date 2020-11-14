ls
//package binPathJava;

public class binPathImpl {

	private void printUsingFunction() {
	    
	    
	    // look at function .. f(pos) = 8*i + pos
	    // int combinations 4294967296
	    // 
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
	
	private static void Try32BytesCombinations() {
		byte a[] = {1,2,3,4,5,6,7,8};
	    byte b[] = {1,2,3,4,5,6,7,8};
	    byte c[] = {1,2,3,4,5,6,7,8};
	    byte d[] = {1,2,3,4,5,6,7,8};
        byte e] =  {1,2,3,4,5,6,7,8};
	    byte f[] = {1,2,3,4,5,6,7,8};
	    byte g[] = {1,2,3,4,5,6,7,8};
	    byte h[] = {1,2,3,4,5,6,7,8};
	    
	    
	    int numOfBytes=0;
	    int total_iterations= 0 ;
	    
	    for (int i1=0 ; i1 < 8; i1++) {
	        total_iterations++;
	        
	        for (int i2=0 ; i2 < 8 ; i2++) {
	            total_iterations++;
	            
	            for (int i3=0 ; i3 < 8 ; i3++) {
	                total_iterations++;
	                
	                for (int i4=0 ; i4 < 8; i4++) {
	                    total_iterations++;
	                    
	                    for (int i5=0 ; i5 < 8 ; i5++) {
	                        total_iterations++;
	                        
	                        for (int i6=0 ; i6 < 8 ; i6++) {
	                            total_iterations++;
	                            System.out.println("\n { "+a[i1]+" , "+b[i2] + " , "+ c[i3] + " , " +d[i4]+" , "+e[i5] +" ,
	                            "+f[i6]);	                                    
	                            // need to get key
	                            InputStream inputStream = new FileInputStream("out");
	                            if (inputStream.read(AES.cipherText) != 32) {
                                    System.err.println("\ndidnt read 32 bytse from file out\n");
                                    exit(-1);
	                            }
	                            
	                            byte secKeyBytes[32];
	                            
	                            AES.deci
	                         }
	                        numOfBytes++;
	                        System.out.println("\n---byte Mark");
	                            }
	                            
	                        }
	                     
	                    }
	                }
	            }
	    System.out.println("\nTotal iterations :  "+total_iterations);
	    System.out.println("\nNum of Bytes scanned : "+numOfBytes);
	}
	
	public static void main(String[] args) {
		Try32BytesCombinations();
		

	}

}
