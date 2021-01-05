#!/bin/bash
export ANDREC="/home/andrec/workspace_3_8/binPath";
javac "$ANDREC"/binPathJava/*.java -d "$ANDREC/classes"
cd classes
java binPathJava.binPathImpl;
echo -e "\nDONE";
