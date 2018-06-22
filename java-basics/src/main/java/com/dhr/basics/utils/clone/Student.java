package com.dhr.basics.utils.clone;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/2.
 */

public class Student implements Cloneable{
    String grade;
    public Student(){
    }
    public void  setGrade(String a){
        this.grade=a;
    }
    public Object clone(){
        Student stu=null;
        try {
            stu=(Student)super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stu;
    }
}
