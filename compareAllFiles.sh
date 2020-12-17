#!/bin/bash

#FILE1 -nt FILE2
#          FILE1 is newer (modification date) than FILE2

#   FILE1 -ot FILE2
#     FILE1 is older than FILE2

#for F in output/AllFiles/*; do echo $F; done
#for F in AllFiles/*; do echo $F; done
#OIFS="$IFS"
#IFS=$"\n"

#for FILEONOUTPUT in output/AllFiles/*;
#do
#    for FILE in AllFiles/*;
#    do
#        FILEB=basename $FILE
#        FILEBOUT=basename $FILEONOUTPUT;
        
#        if [ "$FILEB" == "$FILEBOUT" ];
#        then
#            if [ "$FILE" -nt "$FILEONOUTPUT" ];
#            then
#                echo -e "$FILE is newer";
#            else
#                echo -e "$FILEONOUTPUT is newer";
#           fi
#        fi;
#    done
#done
#IFS="$OIFS"


#find AllFiles -name "*" -exec sh -c "cd output ; echo {} | tr ' ' '_' | xargs diff -q  " \;
inside quotes, word spliting doesnt work
"AB CW" 

echo -e "AB WE\n" | xargs file
AB: cannot open `AB' (No such file or directory)
WE: cannot open `WE' (No such file or directory)

printf '%s' "$IFS" | od -v -An -tx1 -c

xargs does word splitting

quero atribuir um nome de ficheiro com spaces ..file f = "AB AC"
se IFS =<space>  dois valores (ou seja 2 ficheiros AB e AC) se IFS='' "ABAC" tambem nao da

what i want
"AB WE"

string='"aString that may haveSpaces IN IT" bar foo "bamboo" "bam boo"'
echo $string
for word in '$string'; do echo $word; done'


    STDOUT=STDIN
echo "AB Q" | cat
ok

what is the data of cat?

 it's gonna read information from where?..does it assing a temporary file
 
 
 
cat concatenates information

cat - concatenate files and print on the standard output

tem de ler os ficheiros

de que ficheiro é que le, nao le informação de nenhum ficheiro, ou seja se eu quiser


echo "AB Q " "QW E" | cat 
AB Q  QW E

echo "AB Q "         "QW E" | cat 
AB Q  QW E
catcat 

Argument -> 

cat AB Q


find AllFiles -exec sh -c "echo $1 | tr ' ' '_' | xargs diff -q $1 output/AllFiles/$1 " _ {} \;
