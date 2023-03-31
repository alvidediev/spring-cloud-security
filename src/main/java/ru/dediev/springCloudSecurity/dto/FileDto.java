package ru.dediev.springCloudSecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class FileDto {

    @NonNull
    private String name;
    @NonNull
    private MultipartFile file;
}
