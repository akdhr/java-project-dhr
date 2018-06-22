package com.dhr.basics.utils.clone;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/2.
 */

public class Person implements Cloneable {
    int age;
    String name;
    Student grades;

    public void setGrades(Student gra) {
        this.grades = gra;
    }

    public Person(int a, String b, Student gra) {
        age = a;
        name = b;
        this.grades = gra;
    }

    public Person(Person p) {
        this.age = p.age;
        this.name = p.name;
        this.grades = p.grades;
    }

    @Override
    public Object clone() {
        Person per = null;
        try {
            per = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        per.grades = (Student) grades.clone();//深拷贝：就是对引用的对象单独拷贝一次哦。
        return per;
    }

}
