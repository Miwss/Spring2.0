package com.miws.spring.hibernate_test;

import com.miws.spring.hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PolychaemRabotnikaPoID {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();


        try {
            //добавление работника в таблицу
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Elena", "Petrova", "Sales", 1000);
            session.beginTransaction();//начало транзакции
            session.save(emp);//сохранение объекта с данными
            session.getTransaction().commit();//закрываем транзакцию коммитом, либо колбеком если хотим откатить
            //получение информации о работнике по id
            int myId = emp.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee);
        }finally {
            factory.close();
        }
    }
}