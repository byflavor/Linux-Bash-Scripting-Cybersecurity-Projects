#!/bin/bash

#EXERCISE 1
#PART A - GETTING STARTED
echo -n What is your name? 
read varname
echo Hello $varname 
echo $(date)
echo $(who)
varname2=12
echo value in varname2 is $varname2

#PART B - IF STATEMEMNTS
if (( $(date +%k) < 5 || $(date +%k) > 22 )) ; then 
echo YOU SHOULD BE SLEEPING
elif (( $(date +%k) < 12 )); then
echo Good morning
else 
echo Good evening
fi
if (( $# != 1 )) ; then
echo Enter only one argument
exit 1
fi

#PART A,B - WHILE LOOPS, COMMAND LINE ARGUMENTS
x=$1
while (( $x > 0 )) ; do
echo $x
let x--
done
echo GO!
for var in {1..5}
do
echo $var chimpanzee...
done
echo DONE!!
for file in *
do
echo $file
done

#PART C,D - FOR LOOPS, USEFUL SCRIPTS
if (( $# != 2 )) ; then
echo Enter two arguments
exit 1
fi
usernameExists=false
classlist=$1
if [ -f $classlist ]; then
for line in $(cat $classlist); do
	if [ $line == $2 ]; then 
		usernameExists=true
	fi
done
fi
if [ $usernameExists = false ] ; then
echo $2 >> $classlist
fi
