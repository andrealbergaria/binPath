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

HOME_PATH="/home/andrec/workspace_3_8/binPath";
sudo cp -v -r "$HOME_PATH" /mnt/pen_2G
sudo cp -v -r "$HOME_PATH" /mnt/pen_500g
sudo cp -v -r "$HOME_PATH" /mnt/pen_61G
