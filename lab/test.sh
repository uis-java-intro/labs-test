#/bin/sh

javac -cp /usr/share/java/junit4-4.11.jar src/test/java/no/uis/intro/*.java src/main/java/no/uis/intro/*.java
java -cp /usr/share/java/junit4-4.11.jar:/usr/share/java/hamcrest-core-1.3.jar:/testground/uis-java-intro/labs-test/src/ org.junit.runner.JUnitCore test.java.no.uis.intro.FibonacciSequenceTest test.java.no.uis.intro.ArithmeticSequenceTest test.java.no.uis.intro.GeometricSequenceTest 
