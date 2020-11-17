package java;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

import binPathJava.Permutation;

public class deleted_things {
	private static void Try32BytesCombinations() {
		byte a[] = {1,2,3,4,5,6,7,8};
	    byte b[] = {1,2,3,4,5,6,7,8};
	    byte c[] = {1,2,3,4,5,6,7,8};
	    byte d[] = {1,2,3,4,5,6,7,8};
        byte e[] = {1,2,3,4,5,6,7,8};
	    byte f[] = {1,2,3,4,5,6,7,8};
	    byte g[] = {1,2,3,4,5,6,7,8};
	    byte h[] = {1,2,3,4,5,6,7,8};
	    
	    
	    int numOfBytes=0;
	    int total_iterations= 0 ;
	    
	    // 8*8 64
	    //8^6 -> 262144
	    
	    for (int i1=0 ; i1 < 8; i1++) {
	        total_iterations++;
	        
	        for (int i2=0 ; i2 < 8 ; i2++) {
	            total_iterations++;
	            
	            for (int i3=0 ; i3 < 8 ; i3++) {
	                total_iterations++;
	                
	                for (int i4=0 ; i4 < 8; i4++) {
	                    total_iterations++;
	                    
	                    for (int i5=0 ; i5 < 8 ; i5++) {
	                        total_iterations++;
	                        
	                        for (int i6=0 ; i6 < 8 ; i6++) {
	                            total_iterations++;
	                           // System.out.println("\n { "+a[i1]+" , "+b[i2] + " , "+ c[i3] + " , " +d[i4]+" , "+e[i5] +" ,
	                            //"+f[i6]);	                                    
	                            		
	                            int[] key = { a[i1], b[i2], c[i3] ,d[i4],e[i5],f[i6] };
	                            // 32 lines
	                            printKey(key);
	                            
	                            
	                         }
	                        numOfBytes++;
	                        System.out.println("\n---byte Mark");
	                            }
	                            
	                        }
	                     
	                    }
	                }
	            }
	    System.out.println("\nTotal iterations :  "+total_iterations);
	    System.out.println("\nNum of Bytes scanned : "+numOfBytes);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		public class Permutation implements Iterator {

			   private final int size;
			   private final Object [] elements;  // copy of original 0 .. size-1
			   private final Object ar;           // array for output,  0 .. size-1
			   private final int [] permutation;  // perm of nums 1..size, perm[0]=0

			   private boolean next = true;

			   // int[], double[] array won't work :-(
			   public Permutation (Object [] e) {
			      size = e.length;
			      elements = new Object [size];    // not suitable for primitives
			      System.arraycopy (e, 0, elements, 0, size);
			      ar = Array.newInstance (e.getClass().getComponentType(), size);
			      System.arraycopy (e, 0, ar, 0, size);
			      permutation = new int [size+1];
			      for (int i=0; i<size+1; i++) {
			         permutation [i]=i;
			      }
			   }

			   private void formNextPermutation () {
			      for (int i=0; i<size; i++) {
			         // i+1 because perm[0] always = 0
			         // perm[]-1 because the numbers 1..size are being permuted
			         Array.set (ar, i, elements[permutation[i+1]-1]);
			      }
			   }

			   public boolean hasNext() {
			      return next;
			   }

			   public void remove() throws UnsupportedOperationException {
			      throw new UnsupportedOperationException();
			   }

			   private void swap (final int i, final int j) {
			      final int x = permutation[i];
			      permutation[i] = permutation [j];
			      permutation[j] = x;
			   }

			   // does not throw NoSuchElement; it wraps around!
			   public Object next() throws NoSuchElementException {

			      formNextPermutation ();  // copy original elements

			      int i = size-1;
			      while (permutation[i]>permutation[i+1]) i--;

			      if (i==0) {
			         next = false;
			         for (int j=0; j<size+1; j++) {
			            permutation [j]=j;
			         }
			         return ar;
			      }

			      int j = size;

			      while (permutation[i]>permutation[j]) j--;
			      swap (i,j);
			      int r = size;
			      int s = i+1;
			      while (r>s) { swap(r,s); r--; s++; }

			      return ar;
			   }

			   public String toString () {
			      final int n = Array.getLength(ar);
			      final StringBuffer sb = new StringBuffer ("[");
			      for (int j=0; j<n; j++) {
			         sb.append (Array.get(ar,j).toString());
			         if (j<n-1) sb.append (",");
			      }
			      sb.append("]");
			      return new String (sb);
			   }

			   public static void main (String [] args) {
			      for (Iterator i = new Permutation(args); i.hasNext(); ) {
			         final String [] a = (String []) i.next();
			         System.out.println (i);
			      }
			   }}

}
