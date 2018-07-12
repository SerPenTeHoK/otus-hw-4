package ru.sergey_gusarov.hw4.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.sergey_gusarov.hw4.domain.Person;
import ru.sergey_gusarov.hw4.domain.Question;
import ru.sergey_gusarov.hw4.domain.results.IntervieweeResultBase;
import ru.sergey_gusarov.hw4.exception.BizLogicException;
import ru.sergey_gusarov.hw4.exception.DaoException;
import ru.sergey_gusarov.hw4.repository.QuestionRepositoryFile;
import ru.sergey_gusarov.hw4.service.testing.TestingService;
import ru.sergey_gusarov.hw4.service.testing.results.ShowResultsService;
import ru.sergey_gusarov.hw4.service.user.login.LoginService;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Service
public class StartTestImpl implements StartTest {
    private final Logger log = LoggerFactory.getLogger(StartTestImpl.class);

    private final QuestionRepositoryFile questionRepositoryFile;
    private final LoginService loginService;
    private final TestingService testingService;
    private final ShowResultsService showResultsService;
    private final MessageSource messageSource;

    public StartTestImpl(QuestionRepositoryFile questionRepositoryFile, LoginService loginService, TestingService testingService, ShowResultsService showResultsService, MessageSource messageSource) {
        this.questionRepositoryFile = questionRepositoryFile;
        this.loginService = loginService;
        this.testingService = testingService;
        this.showResultsService = showResultsService;
        this.messageSource = messageSource;
    }

    @Override
    public int run() {
        //Locale.setDefault(Locale.ENGLISH);  // - для настройки, если не выбирается автоматически
        Locale.setDefault(new Locale("ru", "RU"));
        System.out.println(Locale.getDefault());
        try {
            Person interviewee = loginService.getUser();
            List<Question> questions = questionRepositoryFile.findAll();
            IntervieweeResultBase intervieweeResult = testingService.startTest(questions, interviewee);
            showResultsService.showTestingResult(intervieweeResult);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("\n" + messageSource.getMessage("main.exception", null, Locale.getDefault()));
            log.error("Real error", ex);
            return 1;
        } catch (DaoException ex) {
            ex.printStackTrace();
            ex.printMessage();
            log.error("Dao error", ex);
            return 1;
        } catch (BizLogicException ex) {
            ex.printStackTrace();
            ex.printMessage();
            log.error("Logic error", ex);
            return 1;
        }
        System.out.println("\n" + messageSource.getMessage("main.end.test", null, Locale.getDefault()));
        return 0;
    }
}
