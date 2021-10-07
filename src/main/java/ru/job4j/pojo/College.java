package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Гарри Джеймсович Поттер ");
        student.setGroup("Грифендор-91 ");
        student.setDateEnrolment("01.09.1991");
        System.out.println(student.getFullName() + student.getGroup() + student.getDateEnrolment());
     }
}
