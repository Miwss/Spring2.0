package com.miws.spring.hibernate_test2.entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="department")
    private String department;
    @Column(name="salary" +
            "")
    private int salary;

    //В переменной емпДитейл -мы говорим что будем ее использовать для связи с таблицей.
    //Так же мы казалаи что эта связь будет он-ту-он
    //В Джоин колум мы указали таблицу в емплоис через которую будет осуществлятся эта связь.
    //Как это работает, мы прописвыем данную связь в классе емплои, тот в свою очередь подключен к таблице емплоис, а запись указывает связь между таблицами+
    //их тип связи и ссылку на класс который мы будем использовать, по скольку в классе дитейл мы подключили базу дитейлс
    @OneToOne
    @JoinColumn(name="details_id")
    private Detail empDetail;

    public Employee() {}

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
