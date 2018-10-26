package com.github.torczuk.subjectproposal.ugly;

import com.github.torczuk.SubjectProposal;
import com.github.torczuk.model.Subject;
import com.github.torczuk.model.SubjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class SubjectProposalTest {

    @Captor
    private ArgumentCaptor<Subject> subjectCaptor;
    @Mock
    private SubjectRepository subjectRepository;
    @InjectMocks
    private SubjectProposal subjectProposal;

    @Test
    public void shouldCreateNewSubjectIfItDoesNotExist_v1() {
        String name = "History of Singapore";

        subjectProposal.propose(name);

        verify(subjectRepository).save(any(Subject.class));
    }

    @Test
    public void shouldCreateNewSubjectIfItDoesNotExist_v2() {
        String name = "History of Singapore";

        subjectProposal.propose(name);

        // equals and #code ?
        verify(subjectRepository).save(new Subject(null, name, null, 1));
        //what if not equals and #code? e.g. save on object from external library?
    }

    @Test
    public void shouldCreateNewSubjectIfItDoesNotExist_v3() {
        String notExistingSubject = "History of Singapore";

        subjectProposal.propose(notExistingSubject);

        verify(subjectRepository).save(subjectCaptor.capture());
        Subject subject = subjectCaptor.getValue();
        assertThat(subject.getId()).isNull();
        assertThat(subject.getName()).isEqualTo(notExistingSubject);
        //... rest of the properties
    }

    @Test
    public void shouldUpdatePopularityOfSubjectIfItExists() {
        String name = "History of Singapore";
        given(subjectRepository.findByName(name)).willReturn(new Subject(1L, name, null, 2));

        subjectProposal.propose(name);

        verify(subjectRepository).save(subjectCaptor.capture());
        Subject subject = subjectCaptor.getValue();
        assertThat(subject.getPopularity()).isEqualTo(3);
    }
}