// taken from https://stackoverflow.com/questions/49478238/permutation-iterator-in-java
// Author : Anilal

package binPathJava;

	import java.util.Arrays;
	import java.util.Iterator;

	class Permutation1<E> implements  Iterator<E[]>{

	    E[] arr1 = null;
	    E[] arr2 = null;
	    int size;
	    int[] stack = null;

	    int index = 0;
	    public Permutation1( E[] arr ){

	        if( arr.length > 0 ){
	            arr1 = arr;

	            size = arr1.length;
	            arr2 = Arrays.copyOf(arr1, size);

	            stack = new int[size];
	            Arrays.fill(stack, 0);
	        }
	    }

	    @Override
	    public boolean hasNext() {
	        return (null != arr1 && arr1.length > 0);
	    }

	    @Override
	    public E[] next() {

	        // start computing.
	        // We will return original array as value of last permutation.
	        // This is to make "hasNext() " implementation easy.
	        updateValue();
	        return arr2;
	    }

	    protected void updateValue(){

	        boolean bret = false;

	        for( ; index < size ; ){

	            if( stack[index] < index ){

	                if( index %2 == 0 ){
	                    swap(0, index);
	                }else{
	                    swap(stack[index], index);
	                }

	                stack[index]++;           
	                index = 0;
	                bret = true;
	                break;
	            }else{
	                stack[index] = 0;
	                index++;
	            }
	        }

	        if( !bret ){
	            // No more permutation available. 
	            // Set the original array as return value.
	            // Also set arr1 = null , so that hasNext() will return false for next test
	            arr2 = arr1;
	            arr1 = null;
	        }
	    }

	    private void swap (final int i, final int j) {
	        E temp = arr2[i];
	        arr2[i] = arr2 [j];
	        arr2[j] = temp;
	    }
	    
	    public static void main(String[] args) {
	    	Integer[] elems = {1,2,3,4,5,6,7,8};	
	        Permutation1<Integer> perm = new Permutation1<Integer>(elems);
	        int count = 0;
	        while(perm.hasNext()){
	            System.out.println(Arrays.toString(perm.next()));
	            count++;
	        }
	        System.out.println("total: " + count);
	    }

	}	


