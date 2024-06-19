package com.multi.threading;

public class BankAccount {
	  private final Object lock = new Object(); // Shared lock for the account
	  private int balance;

	  public BankAccount(int initialBalance) {
	    this.balance = initialBalance;
	    System.out.println("Initial Balance: " + initialBalance);
	  }

	  public void deposit(int amount) {
	    synchronized (lock) { // Acquire lock on the account object
	      balance += amount;
	      System.out.println("Deposited: " + amount + ", New balance: " + balance);
	    }
	  }

	  public void withdraw(int amount) {
	    synchronized (lock) { // Acquire lock on the account object
	      if (balance >= amount) {
	        balance -= amount;
	        System.out.println("Withdrew: " + amount + ", New balance: " + balance);
	      } else {
	        System.out.println("Insufficient funds.");
	      }
	    }
	  }

	  public static void main(String[] args) {
	    BankAccount account = new BankAccount(1000);
	    // Anonymous inner class for deposit thread
	    Thread thread1 = new Thread(new Runnable() {
	      @Override
	      public void run() {
	        account.deposit(500);
	      }
	    });
	    // Anonymous inner class for withdraw thread
	    Thread thread2 = new Thread(new Runnable() {
	      @Override
	      public void run() {
	        account.withdraw(750);
	      }
	    });
	    thread1.start();
	    thread2.start();
	    try {
	      thread1.join();
	      thread2.join();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	  }
	}


