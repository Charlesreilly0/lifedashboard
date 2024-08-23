package com.charlesreilly.lifedashboard.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "emails")
@Data
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String bodySnippet;

    @Column(nullable = false)
    private LocalDateTime receivedAt;

    @Column(nullable = false)
    private boolean isPriority;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
