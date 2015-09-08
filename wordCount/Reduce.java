package com.hadoop.examples;

import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {


	//Defining the reduce method for aggregating the generated output of Map phase
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text,IntWritable> output, Reporter reporter) throws IOException {

		// Setting initial counter value as 0
		int count = 0;
		// For every element with similar key attribute, increment its counter value by adding 1.

		while(values.hasNext()) {
			count += values.next().get();
		}
		// Emitting the (key,value) pair
		output.collect(key, new IntWritable(count));
	}
}
