#! /bin/bash
VUNET= #Fill in your vunet ID here
if [[ -z $VUNET ]]; then
    echo "Please fill in your VUNET id in create_archive.sh";

fi;
#zip submission_$VUNET.zip *.java run.sh compile.sh
#jar -cMf submission.zip ./
