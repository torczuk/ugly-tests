package com.github.torczuk.model;

import java.util.Objects;
import java.util.UUID;

public class Subject {
    private Long id;
    private String name;
    private Long teacherId;
    private int popularity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return popularity == subject.popularity &&
                Objects.equals(name, subject.name) &&
                Objects.equals(teacherId, subject.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teacherId, popularity);
    }

    public Subject(Long id, String name, Long teacherId, int popularity) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
        this.popularity = popularity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
