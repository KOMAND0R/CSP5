package com.lab5.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "student_fio")
    private String fio;
    @Column(name = "student_group")
    private String group;
    @Column(name = "student_university_name")
    private String unName;

    public Student() {}
    public Student(int id, String fio, String group, String unName) {
        this.id = id;
        this.fio = fio;
        this.group = group;
        this.unName = unName;
    }
    public int getId() {
        return id;
    }
    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public void setUnName(String unName) {
        this.unName = unName;
    }
    public String getUnName() {
        return unName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(fio, student.fio) &&
                Objects.equals(group, student.group) &&
                Objects.equals(unName, student.unName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, fio, group, unName);
    }
}