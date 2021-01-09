package Test;

import java.util.List;
import binPathJava.*;


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
		Integer[] int1 = new Integer[2];
		int[] int2 = new int[4];
		int[] t;
		/*Integer[] t1;
		does int1, initializes the components to null?
		how does int2 initializes the components?
		*/
		//test(ref);
		byte b = 0b1000;
		// No 
		Integer[] testInt1 ;
		Integer testIntPrim;
		
		Integer[] testInt2 = new Integer[2];
		int[] arr;
		int[] arr2 = new int[5];
		int[][] arr3  = new int[2][3];
		int[] n = null;
// error good		arr2[2] = null;

		
		class CustomArray {
			int a;
			int method() {
				return 1;
			}
		}
		CustomArray ca = new CustomArray();
		int[][] arr4 = new int[3][];
		/*
		 * 
		 * nao pode ter references , visto que é uma array de ints, 
			arr4[2] = new int[3];
		 *
		 * 
		 */ 
				
				
		
		

		// matrix[d] é uma array de references e nao de ints
		int[][] matrix = new int[3][4];
		System.out.println("\nMatrix len "+matrix.length);
		for (int d = 0; d < matrix.length; d++) {
		    matrix[d] = new int[3];
		    System.out.println("\nMatrix["+d+"] -> "+matrix[d]);
		}
		
		matrix[0]  =new int[3];
		matrix[1]  = new int[3];
		matrix[2]  = null;
		
		// instead of making matrix[0] a refernece, use it with values
		//matrix[0] é uma referencia ?
	//	matrix[0][0] é um valor?
		
		//matrix[0] = 1 ; matrix[0][1]= 2
				// 3*4 => size of matrix array
		// 
			
		
				//matrix[0][0] = ?
			//	so the arrays is composed of references
		
	for (int i = 0; i < 3 ; i++) {
		for (int i2= 0 ; i2 < 4; i2++) {
			System.out.println("\nMATRIX -> "+matrix[i][i2]);
		}
	}
		/*
		System.out.println("\nTESTINT1 "+testInt1); // correct doesnt allow (no default init)
		System.out.println("\nSSS "+testIntPrim); // correct doesnt allow (no default init)
		System.out.println("\nARR int[] "+arr);  // correct doesnt allow (no default init)
		*/
		System.out.println("\nTESTINT2 "+testInt2);  // print reference
		System.out.println("\nTESTINT2 IDX  "+testInt2[0]); // prints null
		
		
		System.out.println("\nARR2 int[] "+arr2[1]); // 0
		System.out.println("\n N == NULL "+n);
		
		System.out.println("\nArr[0] " + arr2[0]);
		//do component arrays, have a default value
		// howcome they have a default value, since they are local variables
		
		Object[] aArrays= new Object[5];
		aArrays[0] = "ABC";
		aArrays[1] = 123;
		aArrays[2] =  new Integer(1);
		
//		and each component of the array is initialized to its default value 
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

