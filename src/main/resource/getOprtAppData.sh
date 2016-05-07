#!/bin/bash
ftp -n<<!
open $1
user $2 $3
binary
time=$(date -d + "%Y%m")
cd $4
lcd $5
# mput OPRT_APP01_${time}*
mget OPRT_APP02_${time}*
prompt
close
bye
!

