package binPathJava;

import java.util.ArrayList;
import java.util.List;

public class Tuple {

	
		private ArrayList<Integer> tupleElems;
		private int numberOfElems;
	
		
		
	
	public Tuple(int i1,int i2,int i3) {
			numberOfElems = 3;
			tupleElems = new ArrayList<Integer>();
			tupleElems.add(i1);
			tupleElems.add(i2);
			tupleElems.add(i3);
			
	}
	
	public Tuple(ArrayList<Integer> l) throws Exception {
		numberOfElems=l.size();
		tupleElems = new ArrayList<Integer>();
		
		System.arraycopy(l, 0, tupleElems, 0, l.size());
	}
	
	public int getNumOfElems() {
		return numberOfElems;
	}
	
	public ArrayList<Integer> getElems() {
		return tupleElems;
	}
	
	public String toString() {
		String s;
		System.out.println();
		s= "(";
		for (Integer b : tupleElems) {
			s += b +",";
		}
		s+= ")";
		
		return s;
	}
	
	public static void print(ArrayList<ArrayList<Tuple>> toPrint) {
		for (ArrayList<Tuple> aux : toPrint) {
				for (Tuple t : aux)
					System.out.println(t);
		}


	}

}
