package com.github.torczuk.util.repository;

import com.github.torczuk.model.Student;
import com.github.torczuk.model.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryStudentRepository implements StudentRepository {
    private static final AtomicLong INC = new AtomicLong(0);

    private List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        if (student.getId() == null) {
            student.setId(INC.getAndIncrement());
        }
        students.add(student);
    }

    @Override
    public Student findById(Long id) {
        return students
                .stream()
                .filter(g -> g.getId().equals(id))
                .findFirst().orElse(null);
    }
}
