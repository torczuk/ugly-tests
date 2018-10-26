package com.github.torczuk.util.repository;

import com.github.torczuk.model.Subject;
import com.github.torczuk.model.SubjectRepository;
import com.github.torczuk.util.Beans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class InMemorySubjectRepository implements SubjectRepository {
    private static final AtomicLong INC = new AtomicLong(0);

    private List<Subject> subjects = new ArrayList<>();

    @Override
    public Subject findByName(String name) {
        return subjects.stream()
                .filter(s -> name.equals(s.getName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Subject subject) {
        if (subject.getId() == null) {
            subject.setId(INC.getAndIncrement());
        }
        subjects.add(subject);
    }

    @Override
    public <T> Subject findBy(String property, T value) {
        return subjects.stream()
                .filter(s -> Beans.getProperty(s, property) != null)
                .findFirst()
                .orElse(null);
    }

}
