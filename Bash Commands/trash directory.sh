#!/bin/bash
: <<'END'
echo $HOME
echo $USER
echo $PWD
echo $PATH


file=$1
#if its a file
if [ -f $file ]; then
	#if trash exists
	if [ -d trash ]; then
	mv $file trash
	echo "$file is in trash"
	else
	echo "Trash directory now exists"
	mkdir trash
	mv $file trash
	fi
else 
echo "No such file"
fi

function rand () {
num=$(( $RANDOM%100 + 1 ))
echo Enter username
read username
echo -n $username
echo $num
}
rand
END
declare -a fileArray
fileArray=($(ls .))
counter=1
for i in "${fileArray[@]}"
do
echo $counter. $i
let counter++
done
echo Length of array: $((counter-1))
