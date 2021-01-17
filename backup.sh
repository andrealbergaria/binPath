#!/bin/bash
WPATH="/home/andrec/workspace_3_8";
BPATH="$WPATH/binPath";
J="$WPATH/javaDoIt"
EXCLUDED_FILES=(upload.sh tryTree/ TODO_STUFF README.md build.xml compareAllFiles.sh findAll.sh keystore.sh classes .settings/ images/ .git/ files/ .externalToolBuilders/ bcprov-jdk15on-168.jar textKey.sh run.bash twoByte backup.sh .project)

DESTINATION=("/mnt/pen_2G" "/mnt/pen_500G" "/mnt/pen_61G" "/mnt/windows_xp_60G")

EXCLUDE_JAVA=("$J/backup.sh" "$J/classes" "$J/compareAllFiles.sh" "$J/findAll.sh" "$J/upload.sh" "$J/.settings" "$J/keystore.sh" "$J/.classpath" "$J/licence" "$J/.project") 

for DIR in "${DESTINATION[@]}"
do  
    sudo rm -rf "$DIR/binPath"
    sudo rm -rf "$DIR/javaDoIt"
    
done

PARAMS=""
PARAM_JAVA=""

# binPath
for FILE in "${EXCLUDED_FILES[@]}"
do
     
    PARAMS=$PARAMS" --exclude=${FILE}"
  
done


# javaDIt
for FILE in "${EXCLUDE_JAVA}"
do
    PARAM_JAVA=$PARAM_JAVA" --exclude=${FILE}"
done;

for DEST in "${DESTINATION[@]}"
do

    rsync -av $PARAMS $BPATH $DEST
    rsync -av $PARAMS_JAVA $J $DEST
done


