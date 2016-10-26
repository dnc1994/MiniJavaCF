build:
		javac *.java

test:
		java Main < ../test/factorial.java

grammar:
		java -jar /usr/local/lib/antlr-4.5.3-complete.jar MiniJava.g4
		javac MiniJava*.java
		java org.antlr.v4.runtime.misc.TestRig MiniJava goal -gui
