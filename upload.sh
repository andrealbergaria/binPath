#!/bin/bash

if [[ -z $1 ]];
then
    echo -e "Must set commit msg on arg\n";
    exit;
fi

git add .

git commit -m "$1"
echo -e "\nCommited git repo with msg "$1
git push https://github.com/andrealbergaria/binPath
sudo rm -rf /mnt/pen_2G/binPath 
sudo rm -rf /mnt/pen_500g/binPath
sudo rm -rf /mnt/pen_61G/binPath

sudo mkdir -p /mnt/pen_2G/binPath
sudo mkdir -p /mnt/pen_500g/binPath
sudo mkdir -p /mnt/pen_61G/binPath

FILES_TO_COPY=(/home/andrec/workspace_3_8/binPath/*);
sudo cp -v -r "$FILES_TO_COPY" /mnt/pen_2G/binPath
sudo cp -v -r "$FILES_TO_COPY" /mnt/pen_500g/binPath
sudo cp -v -r "$FILES_TO_COPY" /mnt/pen_61G/binPath
