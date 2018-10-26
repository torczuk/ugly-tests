package com.github.torczuk;

import com.github.torczuk.infrastructure.EmailSender;
import com.github.torczuk.infrastructure.TextSender;
import com.github.torczuk.model.Group;
import com.github.torczuk.model.GroupRepository;
import com.github.torczuk.model.Student;
import com.github.torczuk.model.StudentRepository;

public class UserRegistration_V2 {

    private GroupRepository groupRepository;
    private StudentRepository studentRepository;

    public UserRegistration_V2(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public void register(Long studentId, Long classId) {

        Group group = groupRepository.findById(classId);
        Student student = studentRepository.findById(studentId);

        //check if to many people have registered
        if (group.getStudents().size() >= group.getLimit()) {
            if (student.getEmail() != null) {
                sendEmail("Can not register", "Sorry the limit exceeded", student.getEmail());

            } else if (student.getPhone() != null) {
                TextSender textSender = new TextSender();
                textSender.send("Sorry the limit exceeded, Call us ...", student.getPhone());
            }
            return;
        }


        //user can not register twice
        if (group.getStudents().contains(student)) {
            throw new IllegalArgumentException();
        }
        groupRepository.addStudent(group.getId(), student);
    }

    public void sendEmail(String header, String body, String email) {
        EmailSender emailSender = new EmailSender();
        emailSender.send(header, body, email);
    }
}
