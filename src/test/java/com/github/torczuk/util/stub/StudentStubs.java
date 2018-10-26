package com.github.torczuk.util.stub;

import com.github.torczuk.model.Student;

public class StudentStubs {

    public static Student student() {
        return new Student(Stubs.inc(), Stubs.uuid(), Stubs.uuid(), Stubs.uuid(), Stubs.uuid());
    }
}
