package com.oocl.test.hash;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 3/6/15
 * Time: 4:10 PM
 */
public class Teacher implements Comparable {
    private String name;
    private int age;
    private double salary;

    public Teacher() {
    }

    public Teacher(String name, int age, double salary) {
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String toString() {
        return "姓名:" + name + ",年龄:" + age + ",薪水:" + salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + age; //表明当name和age都一样时才认为两对象有相同的hashcode值
    } //它与equals()方法搭配

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Teacher)) return false;
        if (this.getClass() != obj.getClass()) return false;
        Teacher per = (Teacher) obj;
        if (this.name.equals(per.name) && this.age == per.age) {
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Object obj) {
        if (obj instanceof Teacher) {
            Teacher per = (Teacher) obj;
            //如果是String类直接调comparableTo方法
            return this.name.compareTo(per.name);
        } else {
            return 0;
        }
    }
}