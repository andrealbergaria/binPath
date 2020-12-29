package Permutations;



import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;






 

public class printPartitions {
	
	
	
	

	/**
	 * 
	 * The algorithm is as follow, for example, partition 3, the minimum tuples are (A=1,B=1,C=1)(1,1,1)
   	the elements added must be (1,2), less than 3  (since adding one to 3 would break the parition number)
   	and bigger than zero, because that way would break numbers of summands
   	So for,
   	A = 3
   	A+B = 3
   	A+B+C = 3
   	
   	Possible values
   	A= {1,2} B = {1,2} C={1,2}
   	
   	get all tuples
   	
   	// from https://www.mathsisfun.com/combinatorics/combinations-permutations-calculator.html
	2P3
	{1,1,1} {1,1,2} {1,2,1} {1,2,2} {2,1,1} {2,1,2} {2,2,1} {2,2,2}
   		X										
   	So there is only one possible outcome.
   	
   	For (4 summands , A+B+C+D) 
   	A= {1,2,3} B={1,2,3} C = {1,2,3} D={1,2,3}
   	 
   	A+B+C+D = 4

	
	 */
	
	
	
	public static Integer[] getRange(int max) {
		Integer[] arr = new Integer[max];
		int v=0;
		for (int i=1; i <= max;i++) {
			arr[v] = new Integer(i);
			
			v++;
		}
		return arr;
	}
	public static int sumValues(Integer[] arr) {
		int sum=0;
		 
			
		for (int i=0; i < arr.length ; i++) {
			sum+=arr[i];
		}
			return sum;
	}
	 
	public static boolean checkPart(Integer[] tuple,int partitionNumber,boolean print) {
		//System.out.println("\n Partition number "+partitionNumber);
		int sum;
		sum = sumValues(tuple);
		boolean ret=false;
		//Print array
		if (print==true) {
		String tupleString=new String();
		
		tupleString="[ ";
		for(Integer elem : tuple) {
			
			tupleString += elem + " , ";
		}
		tupleString+="] ";
			
		
		//System.out.println("The part number is " +partitionNumber);
		if (sum == partitionNumber)
	 		 //out.println(tupleString);
	 	// else
	 	//	out.println("\n Tuple "+tupleString+" is not part");
		ret= true;
		}
		else {
			out.println("Printing not enable on checkPart");
			ret= false;
		}
		return ret;
	}
	/*
	 * 
	 * 
	 * List All Permutations
	 */
	public static void ListAllPermutations(List<Integer[]> listOfTuples) {
		for (Integer[] tuple : listOfTuples) 
			listTuple(tuple);
	}
	
	public static String listTuple(Integer[] tuple) {
		String str = "\n[";
		for (Integer elem: tuple) {
			str+=elem+",";
		}
		str+=("]");
		return str;
					}
	// FROM https://stackoverflow.com/questions/3770289/converting-array-of-primitives-to-array-of-containers-in-java
	public static Integer[] toObject(int[] array) {
	    if (array == null) {
	        return null;
	    } else if (array.length == 0) {
	        return null;
	    }
	    Integer[] result = new Integer[array.length];
	    for (int i = 0; i < array.length; i++) {
	        result[i] = new Integer(array[i]);
	    }
	    return result;
	}

	
	// FROM https://stackoverflow.com/questions/11492842/converting-an-array-of-wrappers-to-an-array-of-primitives
	public static int[] toPrimitiveArray(Object[] wrappedArray) {

        int i = 0;
        int[] arr = new int[wrappedArray.length];

          for ( Object w : wrappedArray){


              arr [i] = (Integer) w;
                      i++;
          }

           return arr;
       }
	
	// to check if they are equal, sorted them and compared them one by one
	/*
	 * @param returns a list of tuples with no repeatitions
	 * 
	 */
	public static void compareTuples(ArrayList<Integer[]> allTuples) {
			
		// FROM https://www.softwaretestinghelp.com/sort-arrays-in-java/
		int temp;
		int[] intArray;
		ArrayList<Integer[]> listTuplesOrdered = new ArrayList<Integer[]>();
		for (Integer[] tuple : allTuples) {
			intArray = toPrimitiveArray(tuple);
			
		 for (int i = 0; i <intArray.length; i++) {     
	          for (int j = i+1; j <intArray.length; j++) {     
	              if(intArray[i] >intArray[j]) {      //swap elements if not in order
	                 temp = intArray[i];    
	                 intArray[i] = intArray[j];    
	                 intArray[j] = temp;    
	               }
	              
	              Integer[] tupleToList = toObject(intArray);
	              listTuple(tupleToList);

	              if (!listTuplesOrdered.contains(tupleToList)) {
	            	  listTuplesOrdered.add(tupleToList);
	               
	              }
	            }     
	        }
		  
		}
//	       ListAllPermutations(listTuplesOrdered);

		

	}
	
	/*
	 * @returns list with tuples that are parts 8from partition math theory
	 * 
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("\nNeeds number of summands or partiiton number");
			System.exit(-1);
		}
		
	int maxSummands = Integer.parseInt(args[0]);
	//	int maxSummands= 6;
		
        Integer[] possibleValuesForTuple; 
         List<Integer[]> listObj;
         boolean print = true;
         ArrayList<Integer[]> allTuples = new ArrayList<Integer[]>();
         Integer[] te;
         
       for (int summand=1; summand <= maxSummands ;summand++) {
    	   
    	   		// Gets the values from 1...summand works
        	 	 possibleValuesForTuple = getRange(summand);
        	 	 
        	 	 print=false;
        	 	 listObj = PermutationWithRepeats.permute(possibleValuesForTuple, summand,print);

        	 	 for (Integer[] tuplePermuted : listObj) {
        	 		 // returns list and assign to tuple
        	 		 checkPart(tuplePermuted, maxSummands,true);
        	 		 te = new Integer[tuplePermuted.length];
        	 		 System.arraycopy(tuplePermuted, 0, te, 0, tuplePermuted.length);
        	 		 allTuples.add(te);
        	 	 }

         
       }
       
       
       compareTuples(allTuples);
       
       }
        	 
      

}

