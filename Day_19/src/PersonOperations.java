
import java.util.function.Consumer; 
import java.util.function.Function; 
import java.util.function.Predicate; 
import java.util.function.Supplier; 
 
public class PersonOperations { 
 
 public static void operateOnPerson1(Person1 person, Predicate<Person1> 
predicate, Function<Person1, String> function, 
   Consumer<Person1> consumer, Supplier<Person1> supplier) { 
  // Predicate to check a condition on the person 
  if (predicate.test(person)) { 
   System.out.println("Predicate test passed."); 
  } else { 
   System.out.println("Predicate test failed."); 
  } 
 
  // Function to apply an operation and return a result 
  String result = function.apply(person); 
  System.out.println("Function result: " + result); 
 
  // Consumer to perform an operation on the person 
  consumer.accept(person); 
 
  // Supplier to provide a new person object 
  Person1 newPerson = supplier.get(); 
  System.out.println("Supplier provided: " + newPerson); 
 } 
 
 public static void main(String[] args) { 
  Person1 person = new Person1("Vikram", 20); 
 
  Predicate<Person1> ageCheck = p -> p.getAge() > 25; 
  Function<Person1, String> nameExtractor = Person1::getName; 
  Consumer<Person1> namePrinter = p -> System.out.println("Person's name: " + p.getName()); 
  Supplier<Person1> personSupplier = () -> new Person1("Yash", 17); 
 
  operateOnPerson1(person, ageCheck, nameExtractor, namePrinter, 
personSupplier); 
 } 
} 
