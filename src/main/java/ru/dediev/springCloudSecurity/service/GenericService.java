package ru.dediev.springCloudSecurity.service;

import ru.dediev.springCloudSecurity.exception.UserNotFoundInBaseException;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {
    T save(T t);
    Optional<T> getById(ID id) throws UserNotFoundInBaseException;
    List<T> getAll();
    void deleteById(ID id) throws UserNotFoundInBaseException;
}
