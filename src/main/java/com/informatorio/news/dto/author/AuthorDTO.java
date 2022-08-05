package com.informatorio.news.dto.author;

import com.informatorio.news.dto.article.ArticleBaseDTO;

import java.time.LocalDate;
import java.util.List;

public class AuthorDTO extends AuthorBaseDTO {
    private String fullName;

   private List<ArticleBaseDTO> articles;

    public AuthorDTO(String name, String lastname, LocalDate createAt,String fullName, List<ArticleBaseDTO> articleBaseDtos) {
        super(name,lastname,createAt);
        this.fullName =fullName;
        this.articles = articleBaseDtos;
    }

    public AuthorDTO(String fullName, List<ArticleBaseDTO> articlesdto) {
        this.fullName = fullName;
        this.articles = articlesdto;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<ArticleBaseDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleBaseDTO> articles) {
        this.articles = articles;
    }
}
