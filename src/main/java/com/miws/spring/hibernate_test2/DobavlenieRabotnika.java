package com.miws.spring.hibernate_test2;

import com.miws.spring.hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DobavlenieRabotnika {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();


        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Ivan", "Ivanov", "IT", 1500);
            session.beginTransaction();//начало транзакции
            session.save(emp);//сохранение объекта с данными
            session.getTransaction().commit();//закрываем транзакцию коммитом, либо колбеком если хотим откатить
        }finally {
            factory.close();
        }
    }
}