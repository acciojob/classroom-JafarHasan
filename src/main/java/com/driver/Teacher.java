package com.driver;

public class Teacher {

    private String name;

    private int numberOfStudents;

    private int age;

    public Teacher(int age, int numberOfStudents, String name) {

        this.age = age;
        this.numberOfStudents = numberOfStudents;
        this.name = name;
    }

    public Teacher(String name,String numberOfStudents,String age){

        this.name=name;
        this.numberOfStudents=Integer.parseInt(numberOfStudents);
        this.age=Integer.parseInt(age);

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher() {

    }
}