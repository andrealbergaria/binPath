#!/bin/bash
STRING='"aString that may haveSpaces IN IT" bar foo "bamboo" "bam boo"'
echo $STRING
for word in $STRING; do echo $word; done
