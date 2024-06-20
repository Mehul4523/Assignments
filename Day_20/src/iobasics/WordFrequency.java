package iobasics;

import java.io.*;
import java.util.*;
 
public class WordFrequency { 
	public static void main(String[] args) { 
		String inputFile = "input.txt"; 
		String outputFile = "output.txt"; 
 
  try { 
	  FileReader fileReader = new FileReader(inputFile); 
	  BufferedReader bufferedReader = new BufferedReader(fileReader); 
 
	  Map<String, Integer> wordCount = new HashMap<>(); 
	  String line; 
  
	  while ((line = bufferedReader.readLine()) != null) { 
		  	String[] words = line.split("\\W+"); 
		  	for (String word : words) { 
		  			word = word.toLowerCase(); 
		  			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1); 
		  	} 
	  } 
   
	  bufferedReader.close(); 
 
  
	  FileWriter fileWriter = new FileWriter(outputFile); 
	  for (Map.Entry<String, Integer> entry : wordCount.entrySet()) { 
		  	fileWriter.write(entry.getKey() + ": " + entry.getValue() + "\n"); 
	  } 
   
	  fileWriter.close(); 
  		} catch (IOException e) { 
  			e.printStackTrace(); 
  		} 
	}
}
