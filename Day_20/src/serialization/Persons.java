package serialization;

import java.io.Serializable;

class Persons implements Serializable {
	  private static final long serialVersionUID = 1L;
	  String name;
	  int age;

	  Persons(String name, int age) {
	    this.name = name;
	    this.age = age;
	  }

	  @Override
	  public String toString() {
	    return "Person{name='" + name + "', age=" + age + "}";
	  }
	}