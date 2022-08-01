package com.informatorio.news.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Integer id;
    @NotBlank

    private String name;
    private  String lastname;

    private String fullName ;
    private LocalDate createAt;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();


    public Author(Integer id, String name, String lastname,LocalDate createAt, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.createAt = createAt;
        this.articles = articles;
        this.fullName = name + lastname;

    }
    public Author(Integer id, String name, String lastname,LocalDate createAt) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.createAt = createAt;


    }

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
