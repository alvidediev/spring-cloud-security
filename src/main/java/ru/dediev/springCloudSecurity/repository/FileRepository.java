package ru.dediev.springCloudSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dediev.springCloudSecurity.model.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
