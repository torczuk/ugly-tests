package com.github.torczuk.util.repository;

import com.github.torczuk.model.Group;
import com.github.torczuk.model.GroupRepository;
import com.github.torczuk.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryGroupRepository implements GroupRepository {

    private static final AtomicLong INC = new AtomicLong(0);

    private List<Group> groups = new ArrayList<>();

    @Override
    public void save(Group group) {
        if (group.getId() == null) {
            group.setId(INC.getAndIncrement());
        }
        groups.add(group);
    }

    @Override
    public void addStudent(Long groupId, Student student) {
        Group byId = findById(groupId);
        byId.getStudents().add(student);
    }

    @Override
    public Group findById(Long id) {
        return groups
                .stream()
                .filter(g -> g.getId().equals(id))
                .findFirst().orElse(null);
    }
}
