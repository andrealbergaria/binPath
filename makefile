
binPath: binPath.o util.o crypto.o
	cc binPath.o util.o crypto.o -lcrypt -o b
	
binPath.o: binPath.c
	cc -c binPath.c -g -o binPath.o
	
util.o: util.c
	cc -c util.c -g -o util.o

crypto.o: crypto.c
	cc -c crypto.c -g -o crypto.o

clean:
	rm -f binPath.o util.o b crypt.o
