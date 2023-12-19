package org.example.sem4_dz;

import jakarta.persistence.*;

@Entity
@Table(name = "`library`.`book`")
public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "author")
        private String author;
        @Column(name = "pages")
        private int pages;
        @Column(name = "date")
        private int date;

    public Book(String name, String author, int pages, int date) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.date = date;
    }

    public Book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", date=" + date +
                '}';
    }
}
