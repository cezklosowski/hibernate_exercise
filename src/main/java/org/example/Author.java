package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "author_first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "author_last_name", nullable = false, length = 100)
    private String lastName;

    @ManyToMany//(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",                   // name -> nazwa tabeli pośredniczącej
            joinColumns = @JoinColumn(name = "author_id"), // joinColumns -> nazwa kolumny z kluczem encji Author
            inverseJoinColumns = @JoinColumn(name = "book_id")) // inverseJoinColumns -> nazwa kolumny z kluczem encji Book
    private List<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName, List<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }
}
