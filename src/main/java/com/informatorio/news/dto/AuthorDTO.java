package com.informatorio.news.dto;


import com.informatorio.news.domain.Article;


import java.util.ArrayList;
import java.util.List;

public class AuthorDTO {



    private Integer id;
    private String name;
    private  String lastname;
    private List<Article> articles = new ArrayList<>();


    public AuthorDTO(Integer id, String name, String lastname, List articles) {

        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.articles = articles;

    }

    public AuthorDTO() {
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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
