package ru.dediev.springCloudSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dediev.springCloudSecurity.model.entity.UserEntity;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByFirstNameAndLastName(String firstname, String lastname);
}
