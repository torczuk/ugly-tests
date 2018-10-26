package com.github.torczuk.model;

import java.util.List;

public class Group {
    private Long id;
    private int limit;
    private List<Student> students;

    public Group(Long id, int limit, List<Student> students) {
        this.id = id;
        this.limit = limit;
        this.students = students;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public int getLimit() {
        return limit;
    }

    public List<Student> getStudents() {
        return students;
    }

//    public boolean isOpen() {
//        return students.size() < limit;
//    }
}
