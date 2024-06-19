package generics;

public class Pair<T1, T2> { // Class name changed for clarity

  private final T1 firstValue; // Variable names changed
  private final T2 secondValue;

  public Pair(T1 firstValue, T2 secondValue) {
    this.firstValue = firstValue;
    this.secondValue = secondValue;
  }

  public T1 getInitialValue() { // Method names changed
    return firstValue;
  }

  public T2 getSecondaryValue() {
    return secondValue;
  }

  public Pair<T2, T1> getSwappedHolder() { // Method name and return type changed
    return new Pair<>(secondValue, firstValue);
  }

  public static void main(String[] args) {
    Pair<String, Integer> originalholder = new Pair<>("John", 30);
    System.out.println("Original pair: (" + originalholder.getInitialValue() + ", " + originalholder.getSecondaryValue() + ")");
    Pair<Integer, String> swappedHolder = originalholder.getSwappedHolder();
    System.out.println("Reversed pair: (" + swappedHolder.getInitialValue() + ", " + swappedHolder.getSecondaryValue() + ")");
  }
}

