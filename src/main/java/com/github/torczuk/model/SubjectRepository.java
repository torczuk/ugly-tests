package com.github.torczuk.model;

public interface SubjectRepository {

    Subject findByName(String name);

    void save(Subject subject);

    <T> Subject findBy(String property, T value);
}
