package com.github.torczuk.userregistration.better;

import com.github.torczuk.UserRegistration_V1;
import com.github.torczuk.model.Group;
import com.github.torczuk.model.GroupRepository;
import com.github.torczuk.model.Student;
import com.github.torczuk.model.StudentRepository;
import com.github.torczuk.util.stub.GroupStubs;
import com.github.torczuk.util.repository.InMemoryGroupRepository;
import com.github.torczuk.util.repository.InMemoryStudentRepository;
import com.github.torczuk.util.stub.StudentStubs;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRegistration_V1Test {

    private GroupRepository groupRepository = new InMemoryGroupRepository();
    private StudentRepository studentRepository = new InMemoryStudentRepository();
    private UserRegistration_V1 userRegistration = new UserRegistration_V1(groupRepository, studentRepository);

    @Test
    public void shouldRegisterStudentWhenNumberOfParticipantInGroupIsBelowLimit() {
        Student student = StudentStubs.student();
        Group group = GroupStubs.emptyGroup();
        studentRepository.save(student);
        groupRepository.save(group);

        userRegistration.register(student.getId(), group.getId());

        assertThat(groupRepository.findById(group.getId()).getStudents()).contains(student);
    }

}
