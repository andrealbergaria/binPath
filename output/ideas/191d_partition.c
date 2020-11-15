#include <stdio.h>

int main() {
        int b=0;
          //8*8 = 64 1000000
        //11111111 - 1000000 = 10111111 191
        
        
        
        for (int i = 0;i < 100; i++) {
           for (int pos= 0 ; pos < 100;pos++) {
                b = 8*i + pos;
                
                if (b == 191)  {
                    printf("\nEntered 191");
                    printf("\n I %i , POS %i ",i,pos);
                    
                }
                
                
            }
            
        }
}
