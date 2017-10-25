Created a business search program that is started from the command line with one argument, the filename of a textfile 
containing a list of businesses and phone numbers. Each line of the text file contains the business name, a comma, then a 
phone number. For example: Dan's Burgers,(512)365-1322. Once the program is started it reads the entire business database file 
and builds an array of businesses sorted by name. It then waits for input on stdin. After a business name is entered, the 
server does a binary search to find the given business. If the business name is not found, the server prints "NOT FOUND". If 
the business is found then the program prints out its telephone number. A blank line as input causes the program to terminate.

Example run:

$ BusinessSearch favorites.txt
Dan's 
NOT FOUND
Dan's Burgers
(512)365-1322
Alex's Sushi
(192)789-1234
Alex's Sushi
(192)789-1234
4 total queries, 1 not found
