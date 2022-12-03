# clack
 CS 242 Project - Henry Rausch & Andrew Tringali
 
 ## Part 1
A negative port number wouldn't really change anything, it would just make no sense within the context of the problem
We will likely need to add some check once port is actually interacting with code and transmission to make sure they are legal

Null users would make it difficult to reference that given user, so we would have to simply make sure that there is a value for user
in order to make sure it can be accessed.

## Part 2

#### Example of TestClackClient output.

Command line output of testClient as directed

Expected error occurred
clackClient1 getUserName(): testUser1
clackClient2 getUserName(): testUser2
clackClient3 getUserName(): testUser3
clackClient4 getUserName(): Anon
clackClient5 getUserName(): testUser2
clackClient6 getUserName(): testUser3
clackClient7 getUserName(): Anon
clackClient8 getUserName(): testUser3
clackClient9 getUserName(): Anon
clackClient10 getUserName(): Anonymous

clackClient1 getHostName(): hostName1
clackClient2 getHostName(): hostName2
clackClient3 getHostName(): localhost
clackClient4 getHostName(): localhost
clackClient5 getHostName(): hostName2
clackClient6 getHostName(): localhost
clackClient7 getHostName(): localhost
clackClient8 getHostName(): localhost
clackClient9 getHostName(): localhost
clackClient10 getHostName(): localhost

clackClient1 getPort(): 12345
clackClient2 getPort(): 7000
clackClient3 getPort(): 7000
clackClient4 getPort(): 7000
clackClient5 getPort(): 7000
clackClient6 getPort(): 7000
clackClient7 getPort(): 7000
clackClient8 getPort(): 7000
clackClient9 getPort(): 7000
clackClient10 getPort(): 7000

clackClient1 hashCode(): 1475037949
clackClient2 hashCode(): 1345357726
clackClient3 hashCode(): 1488094097
clackClient4 hashCode(): 1429790395
clackClient5 hashCode(): 1345357726
clackClient6 hashCode(): 1488094097
clackClient7 hashCode(): 1429790395
clackClient8 hashCode(): 1488094097
clackClient9 hashCode(): 1429790395
clackClient10 hashCode(): 459912698

clackServer1 equals null: false
clackServer1 equals clackServer1: true
clackServer1 equals clackServer2: false
clackServer1 equals clackServer3: false
clackServer1 equals clackServer4: false
clackServer1 equals clackServer5: false
clackServer1 equals clackServer6: false
clackServer1 equals clackServer7: false
clackServer1 equals clackServer8: false
clackServer1 equals clackServer9: false
clackServer1 equals clackServer10: false
clackServer2 equals clackServer1: false
clackServer5 equals clackServer2: true
clackServer5 equals clackServer6: false
clackServer6 equals clackServer3: true
clackServer7 equals clackServer4: true
clackServer8 equals clackServer3: true
clackServer8 equals clackServer6: true
clackServer8 equals clackServer9: false
clackServer9 equals clackServer4: true
clackServer9 equals clackServer7: true
clackServer10 equals clackServer4: false
clackServer10 equals clackServer7: false
clackServer10 equals clackServer9: false

clackClient1:
This instance of ClackClient has the following properties:
Username: testUser1
Host name: hostName1
Port number: 12345
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

clackClient2:
This instance of ClackClient has the following properties:
Username: testUser2
Host name: hostName2
Port number: 7000
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

clackClient3:
This instance of ClackClient has the following properties:
Username: testUser3
Host name: localhost
Port number: 7000
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

clackClient4:
This instance of ClackClient has the following properties:
Username: Anon
Host name: localhost
Port number: 7000
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

clackClient5:
This instance of ClackClient has the following properties:
Username: testUser2
Host name: hostName2
Port number: 7000
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

clackClient6:
This instance of ClackClient has the following properties:
Username: testUser3
Host name: localhost
Port number: 7000
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

clackClient7:
This instance of ClackClient has the following properties:
Username: Anon
Host name: localhost
Port number: 7000
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

clackClient8:
This instance of ClackClient has the following properties:
Username: testUser3
Host name: localhost
Port number: 7000
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

clackClient9:
This instance of ClackClient has the following properties:
Username: Anon
Host name: localhost
Port number: 7000
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

clackClient10:
This instance of ClackClient has the following properties:
Username: Anonymous
Host name: localhost
Port number: 7000
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

clackClient11:
This instance of ClackClient has the following properties:
Username: Anonymous
Host name: localhost
Port number: 7000
Connection status: Open
Data to send to the server: null
Data to receive from the server: null

Enter your command/message

SENDFILE file
Couldn't open File //expected since I'm looking for a fake file - assuming that the method works
//since it will be tested with data

No data to retrieve

No data to retrieve

clackClient1

clackClient10

Enter your command/message

send this message
username: testUser1
type: 2
date: Fri Oct 28 09:29:11 EDT 2022
message: send this message
Enter your command/message

DONE
username: testUser1
type: 2
date: Fri Oct 28 09:29:11 EDT 2022
message: send this message

Process finished with exit code 0

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

## Part 4

### Why should a separate class receive data from the server and print it? Also, why is the class called a 'listener'?
It's to separate the code that receives & prints the data from the rest of ClackClient, which only executes when the user sends a message. The class is called a listener because it waits for an event to happen before executing- in this case, receiving data from the server. -Andrew

### Explain why you need a separate thread for each client, and why you cannot handle all clients in the main server thread. Conceptually, why is the listener class ‘ClientSideServerListener’ different from the class ‘ServerSideClientIO’?
Each client naturally needs its own thread so that it can function as its own entity. You can't handle all clients in one thread so that you can listen to all of them at once. Clients only need to send and receive from the server, where the server processes and distributes that information.

### Explain why the broadcast() and remove() methods are synchronized. You may find it easier to answer this question after completing all programming.
They are synchronized to ensure that all of the operations of one are complete before the others begin. Without this, you could have issues with messages getting incorrectly interpreted. 

### Discuss all new methods and new code in existing methods that you wrote to handle LISTUSERS.
I tried to handle this as simply as possible and just display a message from the server where the contents of the message were the userlist. I did this by adding code to the clause for listusers such that a new clackdata type ListUserData would be passed (although I ended up not actually using this datatype for display, opting to show it as a message instead). As a result of this, I just needed to track in an ArrayList the list of users, and then add a condition where if the server is passed a userlist item it will create its own userlist message instead.
