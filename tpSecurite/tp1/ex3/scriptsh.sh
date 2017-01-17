#!/bin/sh
REP_HOME=/home
REP_BACKUP=/roor/BACKUP
cd $REP_HOME
for $user in *; do
    mkdir -p $REP_BACKUP/$user
    for p in `find $REP_HOME/$user/SAVE/ --daystart -type f -mtime 0 -print`; do
        date=`stat --printf=%y $p | tr ' ' '_'`
        fime=`baseName $p`
        cp $p $REP_BACKUP/$user/${file}_$date
    done
done
