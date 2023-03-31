package ru.dediev.springCloudSecurity.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.dediev.springCloudSecurity.model.entity.FileEntity;
import ru.dediev.springCloudSecurity.service.impl.FileServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/filestorage")
@Tag(name = "File uploading service", description = "the fileuploading swagger api")
public class FileRestControllerV1 {

    @Value(value = "${file.storage}")
    private String filePath;

    private final FileServiceImpl service;

    @PostMapping("/uploadfile")
    public ResponseEntity saveFile(MultipartFile multipartFile) {
        FileEntity file = new FileEntity();
        final String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        Path path = Paths.get( filePath + fileName);
        try {
            Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        file.setName(fileName);
        file.setPath(String.valueOf(path));
        service.save(file);
        return ResponseEntity.ok("File: " + fileName + " successfully uploaded");
    }
}
