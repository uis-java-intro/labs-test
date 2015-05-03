#/bin/sh

cd ../
javac -cp /usr/share/java/junit4-4.11.jar /testground/uis-java-intro/labs/src/test/java/no/uis/intro/*.java /testground/uis-java-intro/labs/src/main/java/no/uis/intro/*.java /testground/uis-java-intro/labs/src/main/java/autograder/Score.java
java -cp /usr/share/java/junit4-4.11.jar:/usr/share/java/hamcrest-core-1.3.jar:/testground/uis-java-intro/labs/src/ org.junit.runner.JUnitCore test.java.no.uis.intro.FibonacciSequenceTest test.java.no.uis.intro.ArithmeticSequenceTest test.java.no.uis.intro.GeometricSequenceTest 
