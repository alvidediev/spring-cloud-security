package ru.dediev.springCloudSecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dediev.springCloudSecurity.model.entity.User;
import ru.dediev.springCloudSecurity.repository.UserRepository;
import ru.dediev.springCloudSecurity.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService<User, Long> {

    private final UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    //TODO: дописать логику для обновление прав доступа (повышение.понижение прав)
    @Override
    public User update(User user, Long id) {

        User byId = getById(id);
        return null;

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
