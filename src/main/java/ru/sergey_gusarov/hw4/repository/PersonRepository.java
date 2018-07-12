package ru.sergey_gusarov.hw4.repository;

import ru.sergey_gusarov.hw4.domain.Person;
import ru.sergey_gusarov.hw4.exception.DaoException;

public interface PersonRepository {
    Person findByNameAndSurname(String name, String surname) throws DaoException;
}
