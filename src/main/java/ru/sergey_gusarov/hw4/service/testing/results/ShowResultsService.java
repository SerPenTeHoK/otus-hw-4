package ru.sergey_gusarov.hw4.service.testing.results;

import ru.sergey_gusarov.hw4.domain.results.IntervieweeResultBase;
import ru.sergey_gusarov.hw4.exception.BizLogicException;

public interface ShowResultsService {
    void showTestingResult(IntervieweeResultBase intervieweeResult) throws BizLogicException;
}
