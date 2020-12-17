package binPathJava;



public class Test {
	 
	/**
	 * @param args
	 */
	private static int  revertNum(int num) {
    	int reversed=1;
    	
    	return reversed;
	}
    	/*int temp = num;
	
	public static void main(String[] args) {
		
		byte[] h = new byte[7];
		
		System.out.println("\n "+h[0]);
	/*	Byte[] byteArray = new Byte[8];
		Byte[] key = new Byte[8];
		Byte[] temp1  = {1,2,3,4,5,6,7,8};
		Byte[] temp2  = {10,11,12,13,14,15,16,17};
		Byte[] temp3  = {11,123,12,123,1,45,23,21};
		
		
		
		Iterator<Byte[]> ite = lArr.iterator();
		System.out.println();
		while (ite.hasNext()) {
			Byte[] byteArr = (Byte[])ite.next();
			for (Byte toPrint : byteArr) {
//				System.out.print(" , "+String.valueOf(toPrint));
			}
//			System.out.println();
		}
		key[0] = binPathImpl.pos_1[0];  
    	key[1] = binPathImpl.pos_2[0];
    	key[2] = binPathImpl.pos_3[0];
    	key[3] = binPathImpl.pos_4[0];
    	key[4] = binPathImpl.pos_5[0];
    	key[5] = binPathImpl.pos_6[0];
    	key[6] = binPathImpl.pos_7[0];
    	key[7] = binPathImpl.pos_8[0];
		
		lArr = Permutation.permute(8, key, ',');
    	int i=0;
    	
    	
    	Iterator<Byte[]> ite1 = (Iterator<Byte[]>) lArr.iterator();
    	
    		while (ite1.hasNext()) {
    			i++;
    			Byte[] byteArr = (Byte[])ite1.next();
    			
    			for (Byte print : byteArr)
    					System.out.print(" , "+String.valueOf(print));
    			System.out.println();
 
    		}
 
	
		
/*		for (int it = 0 ; it < 32; it++) {
    	key[0] =1;  
    	key[1] = 2;
    	key[2] = 3;
    	key[3] = 4;
    	key[4] = 5;
    	key[5] = 6;
    	key[6] = 7;
    	key[7] = 8;
    	lArr = Permutation.permute(8, key, ',');
		}
    	int i=0;
    	
    	
    	Iterator<Byte[]> ite = lArr.iterator();
    	System.out.println();
    		while (ite.hasNext()) {
    			Byte[] byteArr = (Byte[])ite.next();
    			for (Byte toPrint : byteArr) {
    				System.out.print(" , "+String.valueOf(toPrint));
    			}
    			System.out.println();
    		}
    		
*/
	}

