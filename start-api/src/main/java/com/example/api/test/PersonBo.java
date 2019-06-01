package com.example.api.test;

import java.util.Objects;

/**
 * @program: start-PersonBo
 * @description: 个人类
 * @author: Mr.lfl
 * @create: 2019-03-05 16:45
 **/
public class PersonBo implements Comparable<PersonBo>{
    private String name;
    private Integer age;
    private Double score;

    public PersonBo(String name, Integer age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonBo personBo = (PersonBo) o;
        return Objects.equals(name, personBo.name) &&
                Objects.equals(age, personBo.age) &&
                Objects.equals(score, personBo.score);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, score);
    }

    //为什么o.getScore() - this.score 就降序，this.score - o.getScore()就降序
    @Override
    public int compareTo(PersonBo o) {
        int num = (int)(o.getScore() - this.score);
        return num == 0 ? o.getAge().compareTo(this.age) :num; //分数是主要，年龄是次要
    }

    @Override
    public String toString() {
        return "PersonBo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
