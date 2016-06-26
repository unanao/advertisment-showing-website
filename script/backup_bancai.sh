#!/bin/sh
time=`date +"%F_%H:%M"`
database_name=""	#Write your database name
backup_path=`pwd`/backup
passwd_name=""		#Write your password

mysqldump -ubancai -p$password --single-transaction $database_name | gzip > $backup_path/$database_name.$time.gz

find $backup_path -type f -mtime +7 | xargs rm -rf
