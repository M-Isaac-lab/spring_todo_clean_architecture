package com.example.spring_demo.domain.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "images")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageModel {

    @Id
    @Column(name = "image_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Number id;

    @Column(nullable = false)
    private String image_url;

    @Column(nullable = false, name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private TodoModel todo;

    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
    }
}
