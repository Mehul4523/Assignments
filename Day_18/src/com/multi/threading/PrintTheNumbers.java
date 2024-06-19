package com.multi.threading;

public class PrintTheNumbers implements Runnable{

		  private int start;

		  public PrintTheNumbers(int start) {
		    this.start = start;
		  }

		  @Override
		  public void run() {
		    for (int i = start; i <= 10; i++) {
		      System.out.println(Thread.currentThread().getName() + ": " + i);
		      try {
		        Thread.sleep(1000); // 1 second delay
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
		  }

		  public static void main(String[] args) {
		    Thread thread1 = new Thread(new PrintTheNumbers(1));
		    Thread thread2 = new Thread(new PrintTheNumbers(1)); // Both threads start from 1

		    thread1.setName("Thread-1");
		    thread2.setName("Thread-2");

		    thread1.start();
		    thread2.start();
		  }
		}


