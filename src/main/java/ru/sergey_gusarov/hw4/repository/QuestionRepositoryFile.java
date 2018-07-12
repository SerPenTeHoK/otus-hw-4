package ru.sergey_gusarov.hw4.repository;

import ru.sergey_gusarov.hw4.domain.Question;
import ru.sergey_gusarov.hw4.exception.DaoException;

import java.io.IOException;
import java.util.List;

public interface QuestionRepositoryFile {
    List<Question> findAll()
            throws IOException, DaoException;
}
