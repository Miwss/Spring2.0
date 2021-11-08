package com.miws.spring.hibernate_test;

import com.miws.spring.hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PolychaemRabotnikaPoPriznaky {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();


        try {
            //Создание сессии и получение работников
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            //Мы закинем всех работников в лист, для этого используем сессию с криейтКвери куда указываем не таблицу а именно класс!(HQL)
            //По итогу мы получаем результат - лист и сможем пройтись по нему циклом.
//            List<Employee> emps =session.createQuery("from Employee").getResultList(); - тут мы получаем всех работников.

            //Так мы получаем конкретного работника по какому то пункту, HQL - тот же SQL, тут зайдет любой из запросов.
            List<Employee> emps =session.createQuery("from Employee where name = 'Artem'").getResultList();


            for (Employee e: emps) {
                System.out.println(e);
            }

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}