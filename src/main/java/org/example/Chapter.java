package org.example;

import javax.persistence.*;

@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private int id;

    @Column(name = "chapter_title", nullable = false, length = 100)
    private String title;

    public Chapter() {
    }

    public Chapter(String title) {
        this.title = title;
    }
}
