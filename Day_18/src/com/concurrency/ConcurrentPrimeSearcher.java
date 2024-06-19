package com.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ConcurrentPrimeSearcher { 

  public static boolean isPrime(int num) {
    if (num <= 1) return false;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
    }
    return true;
  }

  public static void main(String[] args) throws InterruptedException {
    int searchLimit = 150; 
    
    // Use ExecutorService to parallelize prime number search
    ExecutorService searcherPool = Executors.newFixedThreadPool(4);
    CompletableFuture<Void> searchFuture = CompletableFuture.runAsync(() -> {
      IntStream.rangeClosed(2, searchLimit)
          .filter(ConcurrentPrimeSearcher::isPrime)
          .forEach(System.out::println);
    }, searcherPool);

    // Use CompletableFuture to write results asynchronously (simulated)
    searchFuture.thenRunAsync(() -> {
      System.out.println("Writing prime numbers to a file...");
      try {
        Thread.sleep(1000); // Simulate writing time
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Prime numbers written successfully.");
    }, searcherPool);

    // Wait for all tasks to finish
    searcherPool.shutdown();
    searcherPool.awaitTermination(10, TimeUnit.SECONDS);
  }
}
