package ru.dediev.springCloudSecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dediev.springCloudSecurity.model.entity.EventEntity;
import ru.dediev.springCloudSecurity.model.entity.FileEntity;
import ru.dediev.springCloudSecurity.model.entity.Status;
import ru.dediev.springCloudSecurity.model.entity.UserEntity;
import ru.dediev.springCloudSecurity.repository.EventRepository;
import ru.dediev.springCloudSecurity.repository.FileRepository;
import ru.dediev.springCloudSecurity.repository.UserRepository;
import ru.dediev.springCloudSecurity.service.EventService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;
    private final FileRepository fileRepository;
    private final UserRepository userRepository;

    @Override
    public EventEntity save(EventEntity eventEntity) {
        final FileEntity fileToSave = eventEntity.getFile();
        final FileEntity savedFile = fileRepository.save(fileToSave);
        final UserEntity userToSave = eventEntity.getUser();
        final UserEntity savedUser = userRepository.save(userToSave);
        eventEntity.setFile(savedFile);
        eventEntity.setUser(savedUser);
        return repository.save(eventEntity);
    }

    @Override
    public Optional<EventEntity> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<EventEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public EventEntity update(EventEntity event, Long aLong) {
        final Optional<EventEntity> byId = repository.findById(aLong);
        if (byId.isPresent()){
            final EventEntity eventEntity = byId.get();
            eventEntity.setFile(event.getFile());
            eventEntity.setUser(event.getUser());
            return repository.save(eventEntity);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        final Optional<EventEntity> byId = repository.findById(id);
        if (byId.isPresent()){
            final EventEntity eventEntity = byId.get();
            eventEntity.setStatus(Status.DELETED);
            repository.save(eventEntity);
        }
    }
}
