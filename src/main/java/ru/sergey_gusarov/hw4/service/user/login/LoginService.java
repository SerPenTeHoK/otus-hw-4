package ru.sergey_gusarov.hw4.service.user.login;

import ru.sergey_gusarov.hw4.domain.Person;
import ru.sergey_gusarov.hw4.exception.DaoException;

public interface LoginService {
    Person getUser() throws DaoException;
}
