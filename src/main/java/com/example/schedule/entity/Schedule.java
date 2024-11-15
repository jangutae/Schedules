package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule() {

    }

    public Schedule(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Schedule(String title) {
        this.title = title;
    }

//    public void setUser(User user) {
//        this.user = user;
//    }


}
