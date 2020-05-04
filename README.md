# Bowling Challenge: Java Backend

Adrian Mena Manciati

## Prerequisites

- JAVA 8 must be installed.
- Install MAVEN in your computer. http://maven.apache.org/download.cgi

## Running the program out of the box

At this repo's root path you will find the Executable JAR built with mvn build command and example files for execution, so you can easily try the program even before compiling.

Execute:

> java -jar bowling-0.0.1-SNAPSHOT.jar gameFile.txt

Where gameFile.txt is a text file with the results for several players bowling 10 frames each. 

Example files are included in this repository so you can try them.
- game2PlayerSample.txt
- gamePerfectScore.txt
- gameZeroScore.txt
- gameFouls.txt
- gameBadInput.txt

## Compilation - Building the project

After cloning the project from this repository, run the following commands:

> cd bowling

> mvn clean package

This command generates the jar file **bowling-0.0.1-SNAPSHOT.jar** to **/bowling/target** folder.
This command also runs Unit Tests as part of Maven Lifecycle.

## Unit Testing Execution

> mvn test

## Integration Testing Execution

>mvn verify

This command will execute the maven lifecycle up to verify, which includes compilation, unit testing and integration testing

## Execution after compiling
You can move the generated jar file **bowling-0.0.1-SNAPSHOT.jar** from **/bowling/target** to any folder, and after that, copy the text file you want to try to the same location. Then run
> java -jar bowling-0.0.1-SNAPSHOT.jar gameFile.txt

