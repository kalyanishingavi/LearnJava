package com.interferance;

public class App {
	public static void main(String[] args) {
		Cat c = new Cat();
		Dog d = new Dog();
		c.trait();
		c.sound();
		d.trait();
		d.Sound();
	}
}
class Animal{
	public void trait() {
		System.out.println("Animal trait");
	}
}

class Cat extends Animal{
	public void trait() {
		System.out.println("Cat traits");
	}
	public void sound() {
		System.out.println("meow");
	}
}

class Dog extends Animal{
	public void Sound() {
		System.out.println("Bhow");
	}
}