package ru.dediev.springCloudSecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dediev.springCloudSecurity.model.entity.FileEntity;
import ru.dediev.springCloudSecurity.repository.FileRepository;
import ru.dediev.springCloudSecurity.service.FileService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository repository;

    @Override
    public FileEntity save(FileEntity file) {
        return repository.save(file);
    }

    @Override
    public Optional<FileEntity> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<FileEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public FileEntity update(FileEntity file, Long id) {
        final Optional<FileEntity> byId = repository.findById(id);
        if (byId.isPresent()) {
            FileEntity fileEntity = byId.get();
            fileEntity.setId(file.getId());
            fileEntity.setName(file.getName());
            fileEntity.setName(fileEntity.getName());
            return repository.save(fileEntity);
        } else return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
