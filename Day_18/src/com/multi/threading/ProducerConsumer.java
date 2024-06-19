package com.multi.threading;

public class ProducerConsumer {
	  private final Object lock = new Object();
	  private Integer item = null; // Buffer to hold the item

	  public void produce() throws InterruptedException {
	    synchronized (lock) {
	      while (item != null) { // Wait if buffer is full
	        lock.wait();
	      }
	      item = 1; // Produce an item (replace 1 with your actual data)
	      System.out.println("Produced: " + item);
	      lock.notify(); // Notify the consumer
	    }
	  }

	  public void consume() throws InterruptedException {
	    synchronized (lock) {
	      while (item == null) { // Wait if buffer is empty
	        lock.wait();
	      }
	      System.out.println("Consumed: " + item);
	      item = null; // Consume the item
	      lock.notify(); // Notify the producer
	    }
	  }

	  public static void main(String[] args) {
	    ProducerConsumer pc = new ProducerConsumer();
	    Thread producerThread = new Thread(() -> {
	      try {
	        for (int i = 0; i < 5; i++) {
	          System.out.println("Product No: " + (i + 1));
	          pc.produce();
	          Thread.sleep(1000); // Simulate production time
	        }
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    });
	    Thread consumerThread = new Thread(() -> {
	      try {
	        for (int i = 0; i < 5; i++) {
	          pc.consume();
	          Thread.sleep(500); // Simulate consumption time
	        }
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    });
	    producerThread.start(); // Start producer first
	    consumerThread.start();
	    try {
	      producerThread.join();
	      consumerThread.join();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	  }
	}
