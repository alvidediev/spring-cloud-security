package ru.dediev.springCloudSecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dediev.springCloudSecurity.model.entity.Role;
import ru.dediev.springCloudSecurity.model.entity.Status;
import ru.dediev.springCloudSecurity.model.entity.UserEntity;
import ru.dediev.springCloudSecurity.repository.UserRepository;
import ru.dediev.springCloudSecurity.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserEntity save(UserEntity user) {
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
        return repository.save(user);
    }

    @Override
    public Optional<UserEntity> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public UserEntity update(UserEntity user, Long aLong) {
        final Optional<UserEntity> byId = repository.findById(aLong);
        if (byId.isPresent()) {
            final UserEntity userEntity = byId.get();
            userEntity.setRole(user.getRole());
            return repository.save(userEntity);
        } else return null;
    }

    @Override
    public void deleteById(Long aLong) {
        final Optional<UserEntity> userById = repository.findById(aLong);
        if (userById.isPresent()) {
            final UserEntity userEntity = userById.get();
            userEntity.setStatus(Status.DELETED);
            repository.save(userEntity);
        }
    }
}
