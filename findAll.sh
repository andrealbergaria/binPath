#!/bin/bash
#redireccionar o tee para um filedescriptor

#find AllFiles -exec sh -c "echo $1 | tr ' ' '_' | xargs diff -q "$1" output/"$1""  _ {} \;
find AllFiles -exec bash -c "echo {}" \;
