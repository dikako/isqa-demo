#!/bin/bash

# Get the list of modified Java files
modified_files=$(git diff --cached --name-only -- '*.java')

# Run PMD on the modified files
if [ -n "$modified_files" ]; then
  echo $modified_files
  ./libs/pmd-bin-6.52.0/bin/run.sh pmd -d "$modified_files" -R pmd/rules.xml -f text | awk '{ print NR ": " $0 }'
fi