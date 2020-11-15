package java;

public class deleted_things {
	private static void Try32BytesCombinations() {
		byte a[] = {1,2,3,4,5,6,7,8};
	    byte b[] = {1,2,3,4,5,6,7,8};
	    byte c[] = {1,2,3,4,5,6,7,8};
	    byte d[] = {1,2,3,4,5,6,7,8};
        byte e[] = {1,2,3,4,5,6,7,8};
	    byte f[] = {1,2,3,4,5,6,7,8};
	    byte g[] = {1,2,3,4,5,6,7,8};
	    byte h[] = {1,2,3,4,5,6,7,8};
	    
	    
	    int numOfBytes=0;
	    int total_iterations= 0 ;
	    
	    // 8*8 64
	    //8^6 -> 262144
	    
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
	                           // System.out.println("\n { "+a[i1]+" , "+b[i2] + " , "+ c[i3] + " , " +d[i4]+" , "+e[i5] +" ,
	                            //"+f[i6]);	                                    
	                            		
	                            int[] key = { a[i1], b[i2], c[i3] ,d[i4],e[i5],f[i6] };
	                            // 32 lines
	                            printKey(key);
	                            
	                            
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
