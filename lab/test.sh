#/bin/sh

cd ../
pwd

find -name "*.java" > source.txt
javac -cp /usr/share/java/junit4-4.11.jar @source.txt
java -cp /usr/share/java/junit4-4.11.jar:/usr/share/java/hamcrest-core-1.3.jar:/testground/labs/src/ org.junit.runner.JUnitCore test.java.no.uis.intro.FibonacciSequenceTest test.java.no.uis.intro.ArithmeticSequenceTest test.java.no.uis.intro.GeometricSequenceTest 
