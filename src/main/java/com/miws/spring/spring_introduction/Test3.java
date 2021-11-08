package com.miws.spring.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Person p1 = context.getBean("myPerson", Person.class);
//        Pet pet = new Dog();
        //Pet pet = context.getBean("myPet", Pet.class);
        Person person = context.getBean("myPerson", Person.class);
        System.out.println(person.getAge());
        System.out.println((person.getName()));
        person.callYourPet();
    }
}
