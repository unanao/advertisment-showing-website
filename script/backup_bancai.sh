#!/bin/sh
time=`date +"%F_%H:%M"`
database_name="bancai"
backup_path=`pwd`/backup

mysqldump -ubancai -pevilstorm_110 --single-transaction $database_name | gzip > $backup_path/$database_name.$time.gz

find $backup_path -type f -mtime +7 | xargs rm -rf
