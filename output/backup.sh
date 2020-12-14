#!/bin/bash
sudo rm -rf /mnt/pen_2G/binPath 
sudo rm -rf /mnt/pen_500g/binPath
sudo rm -rf /mnt/pen_61G/binPath
sudo rm -rf /mnt/jessie_40G/binPath
sudo rm -rf /mnt/windows_xp_60G/binPath

sudo mkdir -p /mnt/pen_2G/binPath
sudo mkdir -p /mnt/pen_500g/binPath
sudo mkdir -p /mnt/pen_61G/binPath
sudo mkdir -p /mnt/jessie_40G/binPath
sudo mkdir -p /mnt/windows_xp_60G/binPath


sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/pen_2G/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/pen_500g/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/pen_61G/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/jessie_40G/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/windows_xp_60G/binPath

