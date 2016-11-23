build:
		javac *.java

test:
		javac *.java
		java Main < ../test/Testbed.java

rig:
		javac MiniJava*.java
		java org.antlr.v4.runtime.misc.TestRig MiniJava goal -gui

grammar:
		java -jar /usr/local/lib/antlr-4.5.3-complete.jar MiniJava.g4
