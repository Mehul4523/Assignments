package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ComplexTaskExecutor {
	public static void main(String[] args) throws InterruptedException {
	    // Create a thread pool with 2 threads
	    ExecutorService processor = Executors.newFixedThreadPool(2);

	    // Define tasks with different processing times and inputs
	    Runnable process1 = () -> {
	      try {
	        System.out.println("Processing Unit 1 started... (Data: Input A)");
	        Thread.sleep(4000); // Simulate complex operation (e.g., data analysis)
	        System.out.println("Processing Unit 1 completed.");
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    };

	    Runnable process2 = () -> {
	      try {
	        System.out.println("Processing Unit 2 started... (Data: Input B)");
	        Thread.sleep(2000); // Simulate complex operation (e.g., network call)
	        System.out.println("Processing Unit 2 completed.");
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    };

	    Runnable process3 = () -> {
	      try {
	        System.out.println("Processing Unit 3 started... (Data: Input C)");
	        Thread.sleep(1000); // Simulate complex operation (e.g., file processing)
	        System.out.println("Processing Unit 3 completed.");
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    };

	    // Submit tasks to the thread pool
	    processor.submit(process1);
	    processor.submit(process2);
	    processor.submit(process3);

	    // Wait for all tasks to finish
	    processor.shutdown();
	    if (processor.awaitTermination(10, TimeUnit.SECONDS)) {
	      System.out.println("All processing units completed successfully.");
	    } else {
	      System.out.println("Timeout waiting for processing units to finish.");
	    }
	  }
}
