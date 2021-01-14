package binPathJava;

import java.util.ArrayList;

public class Entry {

	public int minKey;
	public int maxKey;
	public ArrayList<Integer> keys = new ArrayList<>();
	
	public Entry(int m,int n) {
		this.minKey = m;
		this.maxKey = n;
	}
	public Entry() {
		
	}
}
