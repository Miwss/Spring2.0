package com.miws.spring.hibernate_test;

import com.miws.spring.hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class IzmeneniyaDannih {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();


        try {
            //Создание сессии.
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            //После того как создали сессию, мы берем определенного работника по айди(думаю можно и не по айди) и ниже просто через сеттер меняем ему данные
            //Employee emp = session.get(Employee.class, 4); //так мы указываем что получаем конкретного пользователя с айди 3
            //emp.setSurname("Petr");//таким образом мы можем изменить данные для любого поля
            //===============================================================================//
            //Теперь заменим запрату всем Иванам.
            session.createQuery("update Employee set salary = 1000 where name = 'Ivan'").executeUpdate();


            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}