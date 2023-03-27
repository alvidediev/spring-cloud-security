package ru.dediev.springCloudSecurity.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(  cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_file_id")
    private File file;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
