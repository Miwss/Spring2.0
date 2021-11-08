package com.miws.spring.spring_introduction;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        context.close();
        System.out.println(person.getName());
        System.out.println(person.getAge());

//        Cat cat = context.getBean("catBean", Cat.class);
//        cat.say();
    }
}
