default: test build

all: test build

build:
	echo Compiling code and tests
	javac -g -d classes data/*.java
	javac -g -d classes main/*.java
	javac -g -d classes test/*.java

# Your test drive should return 0 on success, nonzero on fail
# Right now it fails since it doesn't exist
test: build
	echo Testing
	java -cp classes test.TestClackData

doc:
	echo Compiling documentation
	javadoc -d doc data/*.java main/*.java

clean:
	rm -rf */.class doc classes
