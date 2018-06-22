package com.dhr.basics.utils.clone;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/2.
 */

public class Body {
    public static void main(String[] args) {
//        Person p1 = new Person(10, "wang");
//        Person p2 = (Person) p1.clone();
//        System.out.println(p1);//输出堆内存的地址
//        System.out.println(p2);
//        System.out.println(p1 == p2);
//        System.out.println(p1.equals(p2));


        /*Student stu=new Student();
        stu.setGrade("100");
        Person p1=new Person(10,"wang",stu);
        Person p2 = (Person)  p1.clone();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == p2);
        System.out.println(p1.grades==p2.grades);

        stu.setGrade("200");
        System.out.println(p2.grades.grade);
        System.out.println(p1.grades.grade);*/


        Student stu = new Student();
        stu.setGrade("100");
        Person p1 = new Person(10, "wang", stu);
        Person p2 = (Person) p1.clone();
        System.out.println(p1.grades == p2.grades);

        stu.setGrade("200");
        System.out.println(p2.grades.grade);
        System.out.println(p1.grades.grade);
    }
}
