package Test;

public class ClassOnArray {
	  public Integer REF;
	  
	  public String toString() {
		  return "This object has refernce  "+REF;
	  }
	  public void changeInt() {
		  Integer t = REF;
		  System.out.println("\nValue Of Local int is "+t);
		  t += 10;
		  System.out.println("\nValue Of Local int is now "+t);
		  
		  
		  
	  }
	  
}