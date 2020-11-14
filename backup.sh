#!/bin/bash
sudo rm -rf /mnt/pen_2G/binPath 
sudo rm -rf /mnt/pen_500g/binPath
sudo rm -rf /mnt/pen_61G/binPath

sudo mkdir -p /mnt/pen_2G/binPath
sudo mkdir -p /mnt/pen_500g/binPath
sudo mkdir -p /mnt/pen_61G/binPath

sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/pen_2G/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/pen_500g/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/pen_61G/binPath
