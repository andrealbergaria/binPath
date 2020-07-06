#include <stdio.h>


 // The algorithm works by first getting a base of 0000, and change one bit at a time (0001,0010,etc);
// Then it uess a base of 1111 and change one bit at a time (1110,1101,etc...)

int main() {
	char zeros[] = { '0','0','0','0','0','0','\0'};
				 char ones[] = { '1','1','1','1','1','1','\0'};

				 printf("\n%s",zeros);

				 int iterator;

				 for (iterator=0 ; iterator < (sizeof(zeros)-1) ; iterator++) {
					zeros[iterator] = '1';
					printf("\n%s",zeros);
					zeros[iterator] = '0';
				}
				 printf("\n%s",ones);

				 for (iterator=0 ; iterator < (sizeof(ones)-1); iterator++) {
						ones[iterator] = '0';
						printf("\n%s",ones);
						ones[iterator] = '1';
					}
}
