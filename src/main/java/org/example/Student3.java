package org.example;

public class Student3 {
    int id;
    String name;
    public Student3(int id, String name) {
        this.id = id;
        this.name = name;
    }
    void hienthi(){
        System.out.println(id+" "+name);
    }
    public static void main(String[] args) {
        Student3 s1 = new Student3(1, "Hoang");
        Student3 s2 = new Student3(2, "Thanh");
        s1.hienthi();
        s2.hienthi();
    }
}
