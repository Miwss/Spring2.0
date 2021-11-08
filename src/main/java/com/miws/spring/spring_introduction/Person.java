package com.miws.spring.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.PrimitiveIterator;
@Component("personBean")
public class Person {
    @Autowired()
    @Qualifier("catBean")
    private Pet pet;
    @Value("${person.age}")
    private int age;
    @Value("${person.name}")
    private String name;
//public Person(){
//    System.out.println("Person bean is created");
//}

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

  //  public Person(Pet pet) {
    //    this.pet = pet;
  //  }
    public  void callYourPet(){
        System.out.println("Person bean is created");
        System.out.println("Hello, my lovely pet");
        pet.say();
    }
}
