#!/bin/bash
sudo rm -rf /mnt/pen_2G/binPath 
sudo rm -rf /mnt/pen_500g/binPath
sudo rm -rf /mnt/pen_61G/binPath
sudo rm -rf /mnt/jessie_40G/binPath
sudo rm -rf /mnt/windows_xp_60G/binPath
sudo rm -rf /root/binPath
sudo rm -rf /root/utf8
sudo rm -rf /root/javaDoIt

sudo mkdir -p /mnt/pen_2G/binPath
sudo mkdir -p /mnt/pen_500g/binPath
sudo mkdir -p /mnt/pen_61G/binPath
sudo mkdir -p /mnt/jessie_40G/binPath
sudo mkdir -p /mnt/windows_xp_60G/binPath
sudo mkdir -p /root/binPath
sudo mkdir -p /root/utf8
sudo mkdir -p /root/javaDoIt


sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/pen_2G/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/pen_500g/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/pen_61G/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/*  /mnt/jessie_40G/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/  /mnt/windows_xp_60G/binPath
sudo cp -v -r /home/andrec/workspace_3_8/binPath/  /root/binPath
sudo cp -v -r /home/andrec/workspace_3_8/utf8/*     /root/utf8
sudo cp -v -r /home/andrec/workspace_3_8/javaDoIt/*     /root/javaDoIt

