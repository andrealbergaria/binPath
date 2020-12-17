//  taken from https://stackoverflow.com/questions/11707066/timer-in-java-thread
package binPathJava;

public class SpeedOfPermutation {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Start benchmarking....
		long endTime;
		
		int[] key = new int[8];
		int[] ret = new int[8];
		
		long startTime = System.currentTimeMillis();
		
		for (int it= 0; it < 32; it++) {
        	key[0] = 12;  
        	key[1] = 6;
        	key[2] = 7;
        	key[3] = 9;
        	key[4] = 3;
        	key[5] = 15;
        	key[6] = 4;
        	key[7] = 8;
        	//printKey(key);
        	//ret = Permutation.permute(key,false);
        	endTime = System.currentTimeMillis();
        	long calc = endTime-startTime;
        	System.err.println("\n----- CALCULATED TIME : \n"+calc+"\n");
        	System.err.println("---- Array \n");
        	for (int i : ret) {
        		System.out.println(i);
        	}
        	
	}
	
		
		
        

	}

}
