

      

binPath: binPath.o libbinpath.a
	cc binPath.o -lcrypt -lbinpath -L. -o b
	cc -Wall -pg binPath.c util.c crypto.c -lcrypt -o binPathProfiler

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
