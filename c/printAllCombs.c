#include "util.h"


int main(int argc,char *argv[]) {
    u_int threeBits[500];
    if (argc != 4) {
        printf(" ARG[1] -> number_of_bits_to_print\n");
        printf(" ARG[2] -> start_byte\n");
        printf(" ARG[3] -> wheter print bytes in new line or not (new | listed)\n");
        return -1;
    }
    int startByte = atoi(argv[2]);
    int numberOfBits = atoi(argv[1]);
    
    
    printf("\nUsing %i bits\n",numberOfBits);
    printf("\nStarted printing at %i",startByte);
    
    u_int s = pow(2,numberOfBits);
    
    printf("\nNumber of elems printed %i\n",s);
    int t=7;
    int it=0;

    int threeBitsSize=0;

    if (strcmp(argv[3],"listed")==0)
        printf("\n{ ");

    for (int i = 0; i< s ; i++) {



    	printBits(startByte);

    	if (startByte == t) {
    	    		printf("   (3bits : %i )",startByte);
    	    		t+=8;
    	    		threeBitsSize++;
    	    		threeBits[it] = startByte;
    	    		it++;

    	}

        if (strcmp(argv[3],"listed")==0) {
            printf(" , ");
            startByte++;
        }
        else if (strcmp(argv[3],"new")==0) {
            printf("\n");
            startByte++;
        }
        else  {
        	printf("\nUnkown arg");

        }
        

    }
    printf(" } \n");
    printf("\n Number of three bits : %i\n",threeBitsSize);
    printf("\n");
    while (it > 0) {
    	printf(" , %i ",threeBits[it]);
    	if (it % 10 == 0)
    		printf("\n");
    	it--;
    }

}
