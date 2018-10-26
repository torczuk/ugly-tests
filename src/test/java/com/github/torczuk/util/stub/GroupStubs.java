package com.github.torczuk.util.stub;

import com.github.torczuk.model.Group;
import com.github.torczuk.model.Student;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static java.util.Arrays.asList;

public class GroupStubs {

    public static Group emptyGroup() {
        return new Group(Stubs.inc(), MAX_VALUE, new ArrayList<>());
    }

    public static Group group(Student... students) {
        List<Student> in = new ArrayList<>(asList(students));
        return new Group(Stubs.inc(), students.length + 1, in);
    }

    public static Group fullGroup(Student... students) {
        return new Group(Stubs.inc(), students.length, asList(students));
    }
}
