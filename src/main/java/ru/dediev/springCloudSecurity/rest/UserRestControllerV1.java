package ru.dediev.springCloudSecurity.rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dediev.springCloudSecurity.exception.UserNotFoundInBaseException;
import ru.dediev.springCloudSecurity.model.entity.UserEntity;
import ru.dediev.springCloudSecurity.service.UserService;

import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserRestControllerV1 {

    private final UserService service;

    @GetMapping("/get/{id}")
    public Optional<UserEntity> getById(@PathVariable Long id) throws UserNotFoundInBaseException {
        return service.getById(id);
    }

    @GetMapping("/getall")
    public List<UserEntity> getAllUsers(){
        return service.getAll();
    }

    @PostMapping("/register")
    public ResponseEntity save(UserEntity user){
        service.save(user);
        return ResponseEntity.ok("User: " + user + "successfully added");
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            service.deleteById(id);
        } catch (UserNotFoundInBaseException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("User deleted");
    }
}
