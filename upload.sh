#!/bin/bash
if [[ -z $1 ]];
then
    echo -e "Must set commit msg on arg\n";
    exit;
fi

git add .

git commit -m $1

USER="andrealbergaria";
git push https://github.com/andrealbergaria/binPath < $USER

