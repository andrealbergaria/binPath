package binPathJava;

public class factorize {

	/**
	 * SEems to work
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberToFactorize= 2;
		int m1=0;
		
		for (int numberOfSummands=1; numberOfSummands <= 3000; numberOfSummands++) {
			if (numberToFactorize%numberOfSummands == 0 ) {
				// If result is integer
				m1 = numberToFactorize / numberOfSummands;
				System.out.println(m1);
		
			}
			
			
		}
	}

}
