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
		
	callPermute();
	}

	public static void printMatrix(String str) {
		
		String st = ""; 
		
			
			
			
			st += "[";
			for (int i=0 ; i < str.length(); i++) {
				if (i == 3)
					st+= "] \n";
				if (str.charAt(i) == 'e' )
					st+=" d1 ";
				else if (str.charAt(i) == ('f'))
					st+= " d2 ";
				else
					st+= " "+str.charAt(i)+" ";
			}
			st += "]";
			
			System.out.println(st);
		
		 
	}
	public static void callPermute() {
		
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
       

	}
	
}
