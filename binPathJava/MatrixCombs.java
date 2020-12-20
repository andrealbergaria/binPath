package binPathJava;

import java.util.ArrayList;
import java.util.List;

public class MatrixCombs {

	
	// https://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
	
	    private static List<String> permutation(String prefix, String str) {
	        List<String> permutations = new ArrayList<>();
	        int n = str.length();
	        if (n == 0) {
	            permutations.add(prefix);
	        } else {
	            for (int i = 0; i < n; i++) {
	                permutations.addAll(permutation(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
	            }
	        }
	        return permutations;
	    }

	
		    
	
	
	public static void main(String[] args) {
		
		printMatrix();
	}

	public static void printMatrix() {
		
			
					String toPermute = "efd";
					String toPermuteLetter  ="wtv";
					
			        List<String> row1Perm = permutation("", toPermute);
			        List<String> row2Perm = permutation("", toPermuteLetter);
					
			        
			        char[] arr;
			        String arrWithSpacesRow1 ="";
			        String arrWithSpacesRow2 ="";
			        for (String s : row1Perm) {
			        	System.out.print("[");
			        	arr = s.toCharArray();
			        	
			        	for (int i=0 ; i < 3; i++) {
			        		if (arr[i] == 'e') 
			        				arrWithSpacesRow1 += " d1 ";
			        		else if(arr[i] == 'f')
			        			arrWithSpacesRow1 += " d2 ";
			        		else {
			        			arrWithSpacesRow1 += " d3 ";
			        			
			        		}
			        			
			        	}
			        	System.out.print(arrWithSpacesRow1);
			        	System.out.println("]");
			        	
			        	
			        	
			        	for (String s2 : row2Perm) {
			        		arr = s2.toCharArray();
			       			arrWithSpacesRow2 = " "+arr[0]+ " " +arr[1] + " " +arr[2];
			       			System.out.println("[" + arrWithSpacesRow2 +" ] ");
			       			System.out.println(arrWithSpacesRow1);
			       			System.out.println("Pos1 , Pos2 , Pos3");
			       			arrWithSpacesRow2 = "";
				     	}
			        }    			
				}
						
				
		
		 
}
	/*public static void callPermute() {
		
		String T = "t";
		String W= "w";
		String V="v";
		String d="d";
		String d1 = "e";
		String d2 = "f";
		String toPermute = T+W+V+d+d1+d2;
        List<String> perms = permutation("", toPermute);

        String[] array = new String[perms.size()];
        for (int i = 0; i < perms.size(); i++) {
            array[i] = perms.get(i);
        }

        int x = array.length;

        for (String str : array) {
        	 printMatrix(str);
        }
		
       

	}*/
	
