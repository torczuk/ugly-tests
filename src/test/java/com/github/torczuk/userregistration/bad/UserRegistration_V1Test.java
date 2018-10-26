package com.github.torczuk.userregistration.bad;

import com.github.torczuk.UserRegistration_V1;
import com.github.torczuk.model.Group;
import com.github.torczuk.model.GroupRepository;
import com.github.torczuk.model.Student;
import com.github.torczuk.model.StudentRepository;
import com.github.torczuk.util.stub.GroupStubs;
import com.github.torczuk.util.stub.StudentStubs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistration_V1Test {

    @Mock
    Group group;
    @Mock
    Student student;
    @Mock
    private GroupRepository groupRepository;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    UserRegistration_V1 userRegistration;

    @Test
    public void shouldRegisterStudentWhenNumberOfParticipantInGroupIsBelowLimit_v1() {
        when(groupRepository.findById(anyLong())).thenReturn(group);
        when(group.getId()).thenReturn(10L);
        when(group.getLimit()).thenReturn(10);
        when(group.getStudents()).thenReturn(Arrays.asList());
        when(studentRepository.findById(1L)).thenReturn(student);

        userRegistration.register(1L, 10L);

        verify(groupRepository).addStudent(10L, student);
    }

    @Test
    public void shouldRegisterStudentWhenNumberOfParticipantInGroupIsBelowLimit_v2() {
        Student student = StudentStubs.student();
        Group group = GroupStubs.emptyGroup();
        when(studentRepository.findById(student.getId())).thenReturn(student);
        when(groupRepository.findById(group.getId())).thenReturn(group);

        userRegistration.register(student.getId(), group.getId());

        verify(groupRepository).addStudent(group.getId(), student);
    }

    @Test
    public void shouldNotifyUserWhenGroupLimitIsReached() {
        Student student = StudentStubs.student();
        Group group = GroupStubs.fullGroup(StudentStubs.student());

        // what next?

    }
}