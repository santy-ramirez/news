package com.informatorio.news.dto;

import com.informatorio.news.domain.Author;


public class ArticleDTO {

    private Integer id;
    private String title;
    private String description;
    private Author author;



    public ArticleDTO(Integer id, String title, String description, Author author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;

    }

    public ArticleDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
