default: 
	find . -name \*.class -type f -print0  | xargs -0 rm -f
	javac -cp ".:./jars/gson.jar" Manager.java
	java -cp ".:./jars/gson.jar" Manager http://localhost:3000
