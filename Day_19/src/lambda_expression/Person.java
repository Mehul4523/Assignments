package lambda_expression;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator; 
import java.util.List; 
 
public class Person { 
 private String name; 
 private int age; 
 
 public Person(String name, int age) { 
  this.name = name; 
  this.age = age; 
 } 
 
 public String getName() { 
  return name; 
 } 
 
 public int getAge() { 
  return age; 
 } 
 
 @Override 
 public String toString() { 
  return name + " (" + age + ")"; 
 } 
 
 public static void main(String[] args) { 
  List<Person> people = new ArrayList<>(); 
  people.add(new Person("Mehul", 23)); 
  people.add(new Person("Nikhil", 19)); 
  people.add(new Person("Tukaram", 51)); 
 
  System.out.println("Before sorting: " + people); 
 
  // Using lambda expression to sort by age 
  Comparator<Person> ageComparator = (p1, p2) -> p1.getAge() - 
p2.getAge(); 
  Collections.sort(people, ageComparator); 
 
  System.out.println("After sorting by age: " + people); 
 } 
} 
