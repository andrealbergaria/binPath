package binPathJava;

import java.util.Arrays;

public class Permutation_All {

	public static int[] pos_1 = {  1,9, 17, 25, 33, 41, 49, 57, 65, 73, 81, 89, 97, 105, 113, 121, 129, 137, 145, 153, 161, 169, 177, 185, 193, 201, 209, 217, 225, 233, 241, 249 };
	public static int[] pos_2 = {  2,10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218, 226, 234, 242, 250 };
	public static int[] pos_3 = {  3,11, 19, 27, 35, 43, 51, 59, 67, 75, 83, 91, 99, 107, 115, 123, 131, 139, 147, 155, 163, 171, 179, 187, 195, 203, 211, 219, 227, 235, 243, 251 };
	public static int[] pos_4 = {  4,12, 20, 28, 36, 44, 52, 60, 68, 76, 84, 92, 100, 108, 116, 124, 132, 140, 148, 156, 164, 172, 180, 188, 196, 204, 212, 220, 228, 236, 244, 252};
	public static int[] pos_5 = {  5,13, 21, 29, 37, 45, 53, 61, 69, 77, 85, 93, 101, 109, 117, 125, 133, 141, 149, 157, 165, 173, 181, 189, 197, 205, 213, 221, 229, 237, 245, 253};
	public static int[] pos_6 = {  6,14, 22, 30, 38, 46, 54, 62, 70, 78, 86, 94, 102, 110, 118, 126, 134, 142, 150, 158, 166, 174, 182, 190, 198, 206, 214, 222, 230, 238, 246, 254};
	public static int[] pos_7 = {  7,15, 23, 31, 39, 47, 55, 63, 71, 79, 87, 95, 103, 111, 119, 127, 135, 143, 151, 159, 167, 175, 183, 191, 199, 207, 215, 223, 231, 239, 247, 255 };
	public static int[] pos_8 = {  8,16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 248,256 };

//									Position 1
//								permute{9,10,11,12,13,14,15,16}
//									Position 2
	// quando permuto pos_1 , permuto igualmente pos9?
	// Tentar apenas permuitar algumas opsicções
	// 
	//   Permute pos_1 = {1,9,17} = {1,17,9} = 9,1}
	//   pos_9 = pos1_ = {1,9,17}
	

	
	
	private static void checkBytes_permutation1() {
		Integer[]  key = new Integer[8];
		
		long startTime= System.currentTimeMillis();
		for (int it= 0; it < 32; it++) {
        	key[0] = pos_1[it];  
        	key[1] = pos_2[it];
        	key[2] = pos_3[it];
        	key[3] = pos_4[it];
        	key[4] = pos_5[it];
        	key[5] = pos_6[it];
        	key[6] = pos_7[it];
        	key[7] = pos_8[it];
		
        Permutation1<Integer> perm = new Permutation1<Integer>(key);
        int count = 0;
        while(perm.hasNext()){
            System.out.println(Arrays.toString(perm.next()));
        }
		}
        long endTime = System.currentTimeMillis();
        long len = endTime-startTime;
        System.out.println("\nTime elapsed "+len+"\n");
        
	}
	// Para cada posicao, existe 32 numeros
	//  Falta permutar as posicose para ficar com todos os elems
	private static void checkBytes_permutation() {
		
		Integer[]  key = new Integer[8];
		
		long startTime = System.currentTimeMillis();
				
			for (int it= 0; it < 32; it++) {
            	key[0] = pos_1[it];  
            	key[1] = pos_2[it];
            	key[2] = pos_3[it];
            	key[3] = pos_4[it];
            	key[4] = pos_5[it];
            	key[5] = pos_6[it];
            	key[6] = pos_7[it];
            	key[7] = pos_8[it];

            	
            	// from permutation
            	Permutation.permute(8, key, ',');
              
           }
            	
         long endTime = System.currentTimeMillis();   	
         long resTime = endTime - startTime;
         
         System.out.println("\nTime resultant : "+resTime+"\n");
		
		
		
	
	}

}
