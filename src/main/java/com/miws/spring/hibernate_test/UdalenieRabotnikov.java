package com.miws.spring.hibernate_test;

import com.miws.spring.hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UdalenieRabotnikov {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();


        try {
            //Создание сессии.
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            //получаем работника и затем удаляем его.
//            Employee emp = session.get(Employee.class, 5);
//            //метод по удалению работника
//            session.delete(emp);
            //===========================================//
            //Удаление нескольких работников
            //таким запросом мы удаляем всех работников с именем Иван(я не удалял), метод екзекьютАпдейт - расматривайте как любое изменение в таблице!
            session.createQuery("delete Employee where name = 'Ivan'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}