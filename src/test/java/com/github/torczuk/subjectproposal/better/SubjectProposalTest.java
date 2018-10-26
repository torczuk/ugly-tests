package com.github.torczuk.subjectproposal.better;

import com.github.torczuk.SubjectProposal;
import com.github.torczuk.model.Subject;
import com.github.torczuk.model.SubjectRepository;
import com.github.torczuk.util.repository.InMemorySubjectRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubjectProposalTest {

    private SubjectRepository subjectRepository = new InMemorySubjectRepository();
    private SubjectProposal subjectProposal = new SubjectProposal(subjectRepository);

    @Test
    public void shouldCreateNewSubjectIfItDoesNotExist() {
        String name = "History of Singapore";

        subjectProposal.propose(name);

        Subject saved = subjectRepository.findByName(name);
        assertThat(saved).isNotNull();
        assertThat(saved.getPopularity()).isEqualTo(1);
    }

    @Test
    public void shouldUpdatePopularityOfSubjectIfItExists() {
        String name = "History of Singapore";
        subjectRepository.save(new Subject(null, name, null, 1));

        subjectProposal.propose(name);

        Subject updated = subjectRepository.findByName(name);
        assertThat(updated).isNotNull();
        assertThat(updated.getPopularity()).isEqualTo(2);
    }
}
