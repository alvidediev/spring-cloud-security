package ru.dediev.springCloudSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dediev.springCloudSecurity.model.entity.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
