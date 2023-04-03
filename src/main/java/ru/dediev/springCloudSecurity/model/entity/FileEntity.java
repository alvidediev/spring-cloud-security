package ru.dediev.springCloudSecurity.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "file")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "file_name")
    private String name;

    @Column(name = "file_path")
    private String path;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
