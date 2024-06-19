package com.multi.threading;

public class ThreadStateSimulator implements Runnable {
		private final String ThreadName;
		
		public ThreadStateSimulator(String threadName) {
			this.ThreadName = threadName;
		}
	  @Override
	  public void run() {
	    System.out.println(ThreadName + ": NEW");  // Initially in NEW state

	    try {
	    		synchronized(this){
	    			System.out.println(ThreadName + ": RUNNABLE");
	    			wait(2000); // Simulate waiting state
	    			System.out.println(ThreadName + ": WAITING");
	    		}
	    		
	    		Thread.sleep(1000); // Simulate timed waiting state
	    		System.out.println(ThreadName + ": TIMED_WAITING");
	    		
	    		synchronized (this) {
	    			System.out.println(ThreadName + ": BLOCKED (waiting on notify)");
	    			notify(); // Simulate release from blocked state
	    		}
	    		
	    			System.out.println(ThreadName + ": RUNNABLE");
	    		} catch (InterruptedException e) {
	    				e.printStackTrace();
	    		}
	    			System.out.println(ThreadName + ": TERMINATED");
	  }
	  

	  public static void main(String[] args) throws InterruptedException {
		  ThreadStateSimulator simulate = new ThreadStateSimulator("Sample Thread");
		  Thread thread = new Thread(simulate);
	    thread.start();

	    synchronized (simulate) {
	    	System.out.println("Main thread: RUNNABLE");
	    	simulate.notify(); // Simulate notification to waiting thread
	    	System.out.println("Main thread: WAITING");
	    	simulate.wait(); // Simulate waiting on thread completion
	    	System.out.println("Main thread: RUNNABLE");
	    	}
	    	thread.join(); // Wait for the thread to finish
	  }
	}



