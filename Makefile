binPath: binPath.o libbinpath.a
	cc binPath.o -lcrypt -lbinpath -lm -L. -o b
	cc -Wall -pg binPath.c util.c crypto.c -lm -lcrypt -o binPathProfiler

getValues: getBinariesFromDecimals.o
	cc getBinariesFromDecimals.o -lbinpath -L. -o getValues
	
binPath_16_32_64bits.o: binPath_16_32_64bits.c
	cc -c binPath_16_32_64bits.c -g -o binPath_16_32_64bits.o
	
binPath.o: binPath.c
	cc -c binPath.c -g -o binPath.o
	
util.o: util.c
	cc -c util.c -g -o util.o

crypto.o: crypto.c
	cc -c crypto.c -g -o crypto.o

clean:
	rm -f binPath.o util.o b crypt.o
	rm -f libbinpath.o

libbinpath.a: util.o crypto.o
	ar -cvq libbinpath.a util.o crypto.o

getBinariesFromDecimals.o: getBinariesFromDecimals.c
	cc -c getBinariesFromDecimals.c -g -lbinpath -o getBinariesFromDecimals.o