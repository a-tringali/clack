# clack
 CS 242 Project - Henry Rausch & Andrew Tringali
 
 ## Part 1
A negative port number wouldn't really change anything, it would just make no sense within the context of the problem
We will likely need to add some check once port is actually interacting with code and transmission to make sure they are legal

Null users would make it difficult to reference that given user, so we would have to simply make sure that there is a value for user
in order to make sure it can be accessed.

## Part 2

#### Example of TestClackClient output.

[PUT HERE]

## Part 3

### Below example was done on Andrew's computer in a terminal, using the compiled ClackClient and ClackServer .jar files. 

andy@orion:~/IdeaProjects/clack/out/artifacts/ClackClient$ java -jar ClackClient.jar localhost 7000 

Enter your command/message 


Hello world! This is a test of ClackClient and ClackServer working together!
 
username: localhost 

type: 2 

date: Tue Nov 15 21:08:07 EST 2022 

message: Hello world! This is a test of ClackClient and ClackServer working together! 

Enter your command/message 
