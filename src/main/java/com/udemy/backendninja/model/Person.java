package com.udemy.backendninja.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@NotNull
	@Size(min=2, max=6)
	private String name;

	
	@NotNull 
	@Min(45)
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person() {
		
	}
}