# Writing a Hadoop MapReduce example :

In this example, we already have a set of text files, we want to identify the
frequency of all the unique words existing in the files. We will get this by designing
the Hadoop MapReduce phase. So, we have developed three Java classes for the MapReduce program; they are Map.
java , Reduce.java , and WordCount.java.

 .Map.java : This is the Map class for the word count Mapper.
 .Reduce.java : This is the Reduce class for the word count Reducer.
 .WordCount.java : This is the task of Driver in the Hadoop

#Compile the Java classes :

// create a folder for storing the compiled classes and download the Dependencies
// compile the java class files with classpath:

$javac -classpath ./hadoop-core-1.1.0.jar:./commons-cli-1.2.jar -d classes *.java

// create jar of developed java classes

$ cd classes
$  jar -cvf WordCount.jar com

// run the jar with command hadoop

$hadoop jar WordCount.jar com.hadoop.examples.WordCount /user/ahmed/test/input /user/ahmed/test/out/
