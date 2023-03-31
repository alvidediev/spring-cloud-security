package ru.dediev.springCloudSecurity.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(
        value = "API to upload files to the server",
        description = "Этот контроллер позволяет загружать фотографии на локальное хранилище",
        produces = "application/json"
)
public class FileRestControllerV1 {

    @Value(value = "${file.storage}")
    private String filePath;

    private final FileServiceImpl service;

    @PostMapping("/uploadfile")
    @ApiOperation(
            value = "Save file to the storage"
    )
    public ResponseEntity saveFile(@ApiParam("MultipartFile") MultipartFile multipartFile) {
        FileEntity file = new FileEntity();
        final String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        Path path = Paths.get(filePath + fileName);
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
