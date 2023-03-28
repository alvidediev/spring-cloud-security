package ru.dediev.springCloudSecurity.service;

import ru.dediev.springCloudSecurity.model.entity.User;

import java.util.List;

public interface UserService<T, ID> {

    T getById(ID id);

    List<User> getAll();

    T update(T t ,ID id);

    void delete(ID id);
}
