package com.example.api.test;

import java.util.Objects;

/**
 * @program: start-TestDemo
 * @description:
 * @author: Mr.lfl
 * @create: 2019-02-28 10:45
 **/
public class TestDemo {
    public static void main(String[] args) {
        Person p1 = new Person("lfl","25");
        Person p2 = new Person("lfl","25");
        System.out.println(p1.equals(p2));
    }
}

class Person{
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        String path = TestDemo.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
    }

}
