package com.github.torczuk.model;

public interface GroupRepository {

    void save(Group group);

    void addStudent(Long groupId, Student student);

    Group findById(Long id);

}
