all: printAllCombs binPath

printAllCombs: printAllCombs.o
	cc printAllCombs.o util.o -lm -g -o printAllCombs

printAllCombs.o: util.o printAllCombs.c
	gcc printAllCombs.c -g -c -o printAllCombs.o

binPath: binPath.o libbinpath.a
	cc binPath.o -lbinpath -L. -lm -o binPath
# cc -Wall -pg binPath.c util.c crypto.c -lm -lcrypt -o binPathProfiler

binPath.o: binPath.c
	cc binPath.c -g -c -o binPath.o

getValues: getBinariesFromDecimals.o
	cc getBinariesFromDecimals.o -lbinpath -L. -o getValues
	
util.o: util.c util.h
	cc -c util.c -g -o util.o

aes256.o: aes256.c aes256.h
	cc aes256.c -c -g -o aes256.o
	
decryptAES.o: decryptAES.c aes256.h
	cc decryptAES.c -c -g -o decryptAES.o
clean:
	rm -f binPath.o util.o aes256.o 
	rm -f libbinpath.o
	rm -f libbinpath.a
	rm -f binPathApp

libbinpath.a: util.o aes256.o decryptAES.o
	ar -cvr libbinpath.a util.o aes256.o decryptAES.o

getBinariesFromDecimals.o: getBinariesFromDecimals.c
	cc -c getBinariesFromDecimals.c -g -lbinpath -o getBinariesFromDecimals.o
