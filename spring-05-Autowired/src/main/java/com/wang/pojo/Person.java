package com.wang.pojo;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/7 20:25
 */
public class Person {

    private Cat cat;
    private Dog dog;
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(Cat cat, Dog dog, String name, Integer age) {
        this.cat = cat;
        this.dog = dog;
        this.name = name;
        this.age = age;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
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

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat.toString() +
                ", dog=" + dog.toString() +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
