package ru.dediev.springCloudSecurity.service;

import ru.dediev.springCloudSecurity.model.entity.UserEntity;

import java.util.Optional;

public interface UserService extends GenericService<UserEntity, Long>{
    Optional<UserEntity> getByFirstnameAndLastname(String firstname, String lastname);
}
