package ru.dediev.springCloudSecurity.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "file")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Integer id;

    @Column(name = "file_name")
    private String name;

    @Column(name = "file_path")
    private String path;

    @OneToOne(mappedBy = "file", cascade = CascadeType.ALL)
    private EventEntity event;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
