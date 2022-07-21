/*

Given a text file file.txt, transpose its content.

You may assume that each row has the same number of columns, and each field is separated by the ' ' character.

Example:

If file.txt has the following content:

name age
alice 21
ryan 30
Output the following:

name alice ryan
age 21 30

*/

#!/bin/bash

declare -a names
declare -a ages

while read line
do 
	words=($line)
	names+=(${words[0]})
	ages+=(${words[1]})
done < file.txt

for name in ${names[@]}
do 
	printf "%s " $name
done

printf "\n"

for age in ${ages[@]}
do 
	printf "%s " $age
done
