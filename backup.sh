#!/bin/bash
BPATH="/home/andrec/workspace_3_8/binPath";
EXCLUDED_FILES=(upload.sh tryTree/ TODO_STUFF README.md build.xml compareAllFiles.sh findAll.sh keystore.sh classes .settings/ images/ .git/ files/ .externalToolBuilders/ bcprov-jdk15on-168.jar textKey.sh run.bash twoByte backup.sh .project)

DESTINATION=("/mnt/pen_2G" "/mnt/pen_500G" "/mnt/pen_61G" "/mnt/windows_xp_60G" "/root")

PARAMS=""

for DIR in "${DESTINATION[@]}"
do  
    sudo rm -rf "$DIR/binPath"
    
done


for FILE in "${EXCLUDED_FILES[@]}"
do
     
    PARAMS=$PARAMS" --exclude=${FILE}"
  
done

for DEST in "${DESTINATION[@]}"
do

    rsync -av $PARAMS $BPATH $DEST
    
done


