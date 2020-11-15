/*
 * decryptAES.c



 *
 *  Created on: Nov 15, 2020
 *      Author: andrec
 */


#include <stdlib.h>
#include <stdio.h>
#include "aes256.h"

void decrypt(uint8_t *txt,aes256_context ctx) {
//	aes256_context ctx;
	 //aes256_init(&ctx, key);
	    aes256_decrypt_ecb(&ctx, txt);


}
