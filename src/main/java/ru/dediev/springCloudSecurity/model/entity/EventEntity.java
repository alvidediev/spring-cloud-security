package ru.dediev.springCloudSecurity.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(  cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_file_id")
    private FileEntity file;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
