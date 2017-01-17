#!/bin/bash
# Remplacer par des cut si l'on souhaite faire du .sh
for f in  `find home/*/SAVE/* -daystart -type f -mtime 0`; do
    date="$(stat -c %y $f)"
    tmpUser=${f#*/} # Retrait du home/
    user=${tmpUser%%/*} # Retrait du tout ce qu'il y a après le prermier /*
    fileName=${f##*/}
    backup=home/BACKUP
    cp $f $backup/$user
    mv "$backup/$user/$fileName" "$backup/$user/$fileName$date"
    
    echo "Utilisateur $user - Nom du Fichier : $fileName"
    echo "Déplacement vers $backup/$user/ ..."
    echo
done


