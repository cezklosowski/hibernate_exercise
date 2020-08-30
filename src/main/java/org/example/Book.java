package org.example;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_title", nullable = false, length = 100)
    private String title;

    @Column(name = "book_date", nullable = false)
    private LocalDate date;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Chapter> chapters;

    public Book() {
    }

    public Book(String title, LocalDate date, List<Chapter> chapters) {
        this.title = title;
        this.date = date;
        this.chapters = chapters;
    }

}
