package binPathJava;


public class Entry {

	public int minKey;
	public int maxKey;
	Integer key;
	String plainText;
	

	
	
	public Entry(int m,int n) {
		this.minKey = m;
		this.maxKey = n;
	}
	public Entry() {
		
	}
	public String toString() {
		String r= "[Entry toString] ";
		r += "Min : "+minKey+" Max : "+maxKey + " Key : "+key+" PlainText "+plainText;
		return r;
	}
	public boolean hasKey() {
		return (key == null) ? false : true;
	}
}
