package com.miws.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Library {
    public void getBook(){
        System.out.println("Take a book");
    }
}
