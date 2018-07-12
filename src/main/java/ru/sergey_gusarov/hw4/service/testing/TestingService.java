package ru.sergey_gusarov.hw4.service.testing;

import ru.sergey_gusarov.hw4.domain.Person;
import ru.sergey_gusarov.hw4.domain.Question;
import ru.sergey_gusarov.hw4.domain.results.IntervieweeResultBase;
import ru.sergey_gusarov.hw4.exception.BizLogicException;

import java.util.List;

public interface TestingService {
    IntervieweeResultBase startTest(List<Question> questions, Person interviewee) throws BizLogicException;
}
