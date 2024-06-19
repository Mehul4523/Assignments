package reflectionapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

  public static void main(String[] args) {
    try {
      // Assuming Book.class is in the same package (reflectionapi)
      Class<?> bookClass = Class.forName("reflectionapi.Book");

      // Inspect methods
      System.out.println("** Methods of " + bookClass.getSimpleName() + " **");
      Method[] methods = bookClass.getDeclaredMethods();
      for (Method method : methods) {
        System.out.println(method);
      }

      // Inspect fields
      System.out.println("\n** Fields of " + bookClass.getSimpleName() + " **");
      Field[] fields = bookClass.getDeclaredFields();
      for (Field field : fields) {
        System.out.println(field);
      }

      // Inspect constructors
      System.out.println("\n** Constructors of " + bookClass.getSimpleName() + " **");
      Constructor<?>[] constructors = bookClass.getConstructors();
      for (Constructor<?> constructor : constructors) {
        System.out.println(constructor);
      }

      // Modify private fields and invoke private method
      Object bookInstance = bookClass.getConstructor(String.class, String.class).newInstance("The Lord of the Rings", "J.R.R. Tolkien"); // Example constructor with arguments

      Field titleField = bookClass.getDeclaredField("title");
      titleField.setAccessible(true);
      titleField.set(bookInstance, "The Hitchhiker's Guide to the Galaxy");

      Field authorField = bookClass.getDeclaredField("author");
      authorField.setAccessible(true);
      authorField.set(bookInstance, "Douglas Adams");

      Method printDetailsMethod = bookClass.getDeclaredMethod("printDetails"); // Replace with your private method name
      printDetailsMethod.setAccessible(true);
      printDetailsMethod.invoke(bookInstance);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
