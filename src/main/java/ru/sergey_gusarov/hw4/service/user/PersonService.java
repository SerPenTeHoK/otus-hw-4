package ru.sergey_gusarov.hw4.service.user;

import ru.sergey_gusarov.hw4.domain.Person;
import ru.sergey_gusarov.hw4.exception.DaoException;

public interface PersonService {
    Person getByNameAndSurname(String name, String surname) throws DaoException;
}
