package com.github.torczuk.userregistration.bad;

import com.github.torczuk.UserRegistration_V2;
import com.github.torczuk.model.Group;
import com.github.torczuk.model.GroupRepository;
import com.github.torczuk.model.Student;
import com.github.torczuk.model.StudentRepository;
import com.github.torczuk.util.repository.InMemoryGroupRepository;
import com.github.torczuk.util.repository.InMemoryStudentRepository;
import com.github.torczuk.util.stub.GroupStubs;
import com.github.torczuk.util.stub.StudentStubs;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistration_V2Test {

    @Captor
    ArgumentCaptor<String> header, body, email;
    private GroupRepository groupRepository = new InMemoryGroupRepository();
    private StudentRepository studentRepository = new InMemoryStudentRepository();
    @Spy
    private UserRegistration_V2 userRegistration = new UserRegistration_V2(groupRepository, studentRepository);

    @Test
    public void shouldRegisterStudentWhenNumberOfParticipantInGroupIsBelowLimit() {
        Student student = StudentStubs.student();
        Group group = GroupStubs.fullGroup();
        studentRepository.save(student);
        groupRepository.save(group);

        //!!!!!!
        Mockito.doNothing().when(userRegistration).sendEmail(header.capture(), body.capture(), email.capture());

        userRegistration.register(student.getId(), group.getId());
        Assertions.assertThat(header.getValue()).isEqualTo("Can not register");
        Assertions.assertThat(body.getValue()).isEqualTo("Sorry the limit exceeded");
        Assertions.assertThat(email.getValue()).isEqualTo(student.getEmail());

        assertThat(groupRepository.findById(group.getId()).getStudents()).isEmpty();
    }

}
