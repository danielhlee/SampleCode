As part of a marathon, participants run or walk a 5k. While seasoned and enthusiastic runners take off from the get go, others only participate by watching people around them run. There are people who will always run no matter what, and always walk no matter what, but a lot of the participants who aren’t certain how they’re going to participate will only run if they see a certain other number of people running first.

Since you want to get as many people to run as possible, how many people do you need to add to the race in order to make sure that everyone who will consider running does so? 

My program's input is pairs of positive integers, the first of which is the number of other runners that group will need to see running in order to run themselves, and the second of which is the number of runners who share that “run number.”  My program reads a text file containing pairs of integers, one pair per line, until the end of file. It then outputs the minimum number of people that need to be added to the race in order to make sure that everyone runs.

Example:

In:
2 1 (“one person will need to see two runners before running”)
3 1 (“one person will need to see three runners before running”)
6 3 (“three people will need to see six runners before running”)
7 6 (“six people will need to see seven runners before running”)

Out: 4

In:
0 1 (“one person will run no matter what”)
1 1 (“one person will need to see one runner before running”)
2 1 (“one person will need to see two runners before running”)
3 1 (“one person will need to see three runners before running”)
4 1 (“one person will need to see four runners before running”)

Out: 0
