
#include <stdio.h>

void t() {
    unsigned char test = 0b11110000;
    if (test == 0b11110000)
        printf("ABC\n");
    printf("CA");
    
}
void t2() {
    char test = 0b11110000;
    if ((test & 0xff) == 0b11110000)
        printf("ABC");
    printf("%x %x %d", test, 0b11110000, test == 0b11110000);
}
 

int main() {
    t();
}
