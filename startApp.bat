@echo off

REM Compile the Java files
javac -d bin Main.java

REM Navigate to the bin directory
cd bin

REM Run the Main class with the bin directory in the classpath
java Main