package com.concurrency;

class Counter { 
  private int count;

  public synchronized void increment(int amount) { 
    count += amount;
  }

  public synchronized void decrement(int amount) { 
    count -= amount;
  }

  public synchronized int getCount() { 
    return count;
  }
}

final class ImmutableData { 
  private final String data;

  public ImmutableData(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }
}

  