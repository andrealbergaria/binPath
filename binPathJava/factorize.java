package binPathJava;

public class factorize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberToFactorize= 10;
		int m1=1;
		for (int numberOfSummands=1; numberOfSummands <= 10; numberOfSummands++) {
			m1 = numberToFactorize / numberOfSummands;
			System.out.println(m1);
		}
	}

}
