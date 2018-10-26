package com.github.torczuk;

import com.github.torczuk.model.Subject;
import com.github.torczuk.model.SubjectRepository;

public class SubjectProposal {

    private SubjectRepository subjectRepository;

    public SubjectProposal(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void propose(String subjectName) {
        Subject subject = subjectRepository.findByName(subjectName);

        if (subject != null) {
            subject.setPopularity(subject.getPopularity() + 1);
            subjectRepository.save(subject);
        } else {
            subjectRepository.save(new Subject(null, subjectName, null, 1));
        }
    }
}
