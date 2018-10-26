package com.github.torczuk.model;

import java.util.List;

public interface StudentRepository {

    void save(Student student);

    Student findById(Long id);

}
