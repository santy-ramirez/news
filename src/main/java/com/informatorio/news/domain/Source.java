package com.informatorio.news.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String code;
    private LocalDate createAt;
    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();

    public Source(Integer id, String name, String code, LocalDate createAt,List<Article> articles) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.createAt = createAt;
        this.articles = articles;
    }

    public Source() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
