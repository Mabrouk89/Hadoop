package com.hadoop.examples;

import java.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
import org.apache.hadoop.conf.*;

public class WordCount extends Configured implements Tool{


public int run(String[] args) throws IOException{

	JobConf conf = new JobConf(WordCount.class);
	conf.setJobName("wordcount");

	//For defining the output key format
	conf.setOutputKeyClass(Text.class);
	//For defining the output value format
	conf.setOutputValueClass(IntWritable.class);
	// For defining the Mapper class implementation
	conf.setMapperClass(Map.class);
	//For defining the Reducer class implementation
	conf.setReducerClass(Reduce.class);
	//For defining the type of input format
	conf.setInputFormat(TextInputFormat.class);
	//For defining the type of output format
	conf.setOutputFormat(TextOutputFormat.class);
	//For defining the command line argument sequence for input dataset path
	FileInputFormat.setInputPaths(conf, new Path(args[0]));
	//For defining the command line argument sequence for output dataset path
	FileOutputFormat.setOutputPath(conf, new Path(args[1]));
	//For submitting the configuration object
	JobClient.runJob(conf);
	return 0;
  }

public static void main(String[] args) throws Exception {
	int exitCode = ToolRunner.run(new WordCount(), args);
	System.exit(exitCode);
  }

}
