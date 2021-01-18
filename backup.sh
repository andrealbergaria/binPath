#!/bin/bash
WPATH="/home/andrec/workspace_3_8";
BPATH="$WPATH/binPath";
J="$WPATH/javaDoIt"
SHORTPATH="$WPATH/binPathShort"

EXCLUDED_FILES=(upload.sh tryTree/ TODO_STUFF README.md build.xml compareAllFiles.sh findAll.sh keystore.sh classes .settings/ images/ .git/ files/ .externalToolBuilders/ bcprov-jdk15on-168.jar textKey.sh run.bash twoByte backup.sh .project)

DESTINATION=("/mnt/pen_2G" "/mnt/pen_500G" "/mnt/pen_61G" "/mnt/windows_xp_60G")

EXCLUDE_JAVA=("$J/backup.sh" "$J/classes" "$J/compareAllFiles.sh" "$J/findAll.sh" "$J/upload.sh" "$J/.settings" "$J/keystore.sh" "$J/.classpath" "$J/licence" "$J/.project") 

EXC_SHORT=("$SHORTPATH/backup.sh" "$SHORTPATH/classes/" "$SHORTPATH/.classpath" "$SHORTPATH/.git" "$SHORTPATH/.gitignore" "$SHORTPATH/upload.sh" "$SHORTPATH/.project" "$SHORTPATH/.settings")

for DIR in "${DESTINATION[@]}"
do  
    sudo rm -rf "$DIR/binPath"
    sudo rm -rf "$DIR/javaDoIt"
    sudo rm -rf "$DIR/binPathShort"
    
done

PARAMS=""
PARAM_JAVA=""
PARAM_SHORT=""
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

# binPathShort
for V in "${EXC_SHORT}"
do
    PARAM_SHORT=$PARAM_SHORT" --exclude=${V}"

done


for DEST in "${DESTINATION[@]}"
do

    rsync -av $PARAMS $BPATH $DEST
    rsync -av $PARAMS_JAVA $J $DEST
    rsync -av $PARAM_SHORT $SHORTPATH $DEST
done


