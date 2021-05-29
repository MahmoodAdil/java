package com.animals;

public class MainRunner {

	public static void main(String[] args) {
		BabyDog babyDog = new BabyDog();
		Dog babyDog2 = new BabyDog();
		Dog dog = new Dog();
		Cat cat = new Cat(); 
		
		System.out.println("babyDog behaviour");
		babyDog.weep();  
		babyDog.bark();  
		babyDog.eat();
		
		System.out.println("babyDog2 behaviour");
		babyDog2.bark();
		babyDog2.eat();
		//babyDog2.weep();//The method weep() is undefined for the type Dog
		((BabyDog) babyDog2).weep();//add cast to babyDog2
		
		System.out.println("cat behaviour");
		cat.eat();
		cat.meow();
		
		System.out.println("dog behaviour");
		dog.eat();
		dog.bark();

	}

}
