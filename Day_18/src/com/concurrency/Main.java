package com.concurrency;

public class Main{ 
public static void main(String[] args) throws InterruptedException {
    Counter counter = new Counter();
    ImmutableData sharedData = new ImmutableData("Shared information"); 

    Runnable incrementTask = () -> {
      for (int i = 0; i < 1000; i++) {
        counter.increment(1);
      }
      System.out.println("Increment task done");
    };

    Runnable decrementTask = () -> {
      for (int i = 0; i < 1000; i++) {
        counter.decrement(1);
      }
      System.out.println("Decrement task done");
    };

    Thread thread1 = new Thread(incrementTask);
    Thread thread2 = new Thread(decrementTask);
    Thread thread3 = new Thread(incrementTask);

    thread1.start();
    thread2.start();
    thread3.start();

    thread1.join();
    thread2.join();
    thread3.join();

    System.out.println("Final count: " + counter.getCount());
    System.out.println("Shared data: " + sharedData.getData());
  }
}



