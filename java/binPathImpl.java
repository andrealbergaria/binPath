ls
//package binPathJava;

public class binPathImpl {

	byte pos_1[] = {  1,9, 17, 25, 33, 41, 49, 57, 65, 73, 81, 89, 97, 105, 113, 121, 129, 137, 145, 153, 161, 169, 177, 185, 193, 201, 209, 217, 225, 233, 241, 249 };
	byte pos_2[] = {  2,10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218, 226, 234, 242, 250 };
	byte pos_3[] = {  3,11, 19, 27, 35, 43, 51, 59, 67, 75, 83, 91, 99, 107, 115, 123, 131, 139, 147, 155, 163, 171, 179, 187, 195, 203, 211, 219, 227, 235, 243, 251 };
	byte pos_4[] = {  4,12, 20, 28, 36, 44, 52, 60, 68, 76, 84, 92, 100, 108, 116, 124, 132, 140, 148, 156, 164, 172, 180, 188, 196, 204, 212, 220, 228, 236, 244, 252};
	byte pos_5[] = {  5,13, 21, 29, 37, 45, 53, 61, 69, 77, 85, 93, 101, 109, 117, 125, 133, 141, 149, 157, 165, 173, 181, 189, 197, 205, 213, 221, 229, 237, 245, 253};
	byte pos_6[] = {  6,14, 22, 30, 38, 46, 54, 62, 70, 78, 86, 94, 102, 110, 118, 126, 134, 142, 150, 158, 166, 174, 182, 190, 198, 206, 214, 222, 230, 238, 246, 254};
	byte pos_7[] = {  7,15, 23, 31, 39, 47, 55, 63, 71, 79, 87, 95, 103, 111, 119, 127, 135, 143, 151, 159, 167, 175, 183, 191, 199, 207, 215, 223, 231, 239, 247, 255 };
	byte pos_8[] = {  8,16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 248, 256 };


	
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
	private static byte[] testKey(byte a[],byte b[], byte c[],byte d[],byte e[],byte f[],byte g[],byte h[]) {
		byte key[32];
		
		for (int i= 0 ;i < 32; i++) {
			
		}
	}
	
	
	private static void Try32BytesCombinations() {
		byte a[] = {1,2,3,4,5,6,7,8};
	    byte b[] = {1,2,3,4,5,6,7,8};
	    byte c[] = {1,2,3,4,5,6,7,8};
	    byte d[] = {1,2,3,4,5,6,7,8};
        byte e[] =  {1,2,3,4,5,6,7,8};
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
	                            
	                            
	                            byte[] key = { a[i], b[i2], c[i3] ,d[i4],e[i5],f[i6] };
	                            
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
