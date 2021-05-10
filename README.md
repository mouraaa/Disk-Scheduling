# Disk-Scheduling
### CISC 3320 HW#4

Write a program the implements the following disk-scheduling algorithms: <br>
* FCFS <br>
* SSTF <br>
* SCAN <br>
* C-SCAN <br>
* LOOK <br>
* C-LOOK <br>

Assume you have a disk drive with 5,000 cylinders numbered 0-4,999. <br>
Using the given request numbers below, implement an API that will use the algorithms listed above. The program will use track 100 as your starting track and for any algorithm where a direction is required, the direction is upward. It shall report the total amount of head movement by each algorithm. 


4078, 153, 2819, 3294, 1433, 211, 1594, 2004, 2335, 2007, 771, 1043, 3950, 2784, 1881, 2931, 3599, 1245, 4086, 520, 3901, 2866, 947, 3794, 2353, 3970, 3948, 1815, 4621, 372, 2684, 3088, 827, 3126, 2083, 584, 4420, 1294, 917, 2881, 3659, 2868, 100, 1581, 4581, 1664, 1001, 1213, 3439, 4706

## PLEASE READ
_This program has been written with the assumption that the disk drive has 5000 cylinders numbered 0-4,999. You can change the max value through the int at the top of the code. However, if you want to change the minimum value, you would have to go through the code and change it manually in each of the appropriate algoithims._ <br>

_You can also change the requests by changing the numbers in the array to fit your specific problem._

## Possible Updates:
* Ask user for starting head
* Ask user for direction
* Ask user for a specific algorithim


