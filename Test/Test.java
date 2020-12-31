package Test;

import java.util.List;
import java.util.Vector;

import binPathJava.SubInterface;


public class Test {
	 
	public static void test(Object[] ref) {
		for (int i=0; i < ref.length; i++) {
			System.out.println("abc");
			System.out.println(ref[i]);
	     }
	}
	
	public static void main(String[] args) {
		Object[] ref = new Object[3];
		//test(ref);
		byte a = 8;
		byte b = 0b1000;
		
		//if (a==b)
			//System.out.println("tru");
		
		Integer i= new Integer(Integer.reverse(7));
		System.out.println(i);
		
	}
		//SuperIntergace si = new Super();
		//SubInterface s = 
		// que class tenho de por aqui? posso meter uma superclass?
				// um objecto de subinterface, pode ser colocado na superclass
			//	interface subinterface = new SuperObject();
					// subinterface extends superinterface. SuperObject impelemtn SuperItnerface
					// desde que subinterface extends superinterface, posso usar o superObject? 
				//		subinterface = { int a , b};
				//		superinterface = (void g(),int j());
						
					//	super_object = { void g() { print } int j() { return 3 }};
	//	sup_obj extends super_object => { void g() {print} ; int j() { return 3} ; void no_in_super() {boolean b;}
					//	sub_obj herda o interface, por isso por por subclass ou superclass na refenrecia de tipo
				//		Por exemplo SubInterface si = new SuperObject();
						// sub_obj pode ter outros metodo contudo
}

