#!/bin/bash
#all commands needed to push to github
git add *
git commit -m "$1"
git push -u origin "$2"
