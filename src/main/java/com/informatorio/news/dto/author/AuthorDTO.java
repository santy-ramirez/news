package com.informatorio.news.dto.author;

import com.informatorio.news.dto.article.ArticleBaseDTO;

import java.time.LocalDate;
import java.util.List;

public class AuthorDTO extends AuthorBaseDTO {
    private String fullName;

   private List<ArticleBaseDTO> articlesdto;

    public AuthorDTO(String name, String lastname, LocalDate createAt,String fullName, List<ArticleBaseDTO> articleBaseDtos) {
        this.setName(name);
        this.setLastname(lastname);
        this.setCreateAt(createAt);
        this.fullName= fullName;
        this.articlesdto = articleBaseDtos;
    }

    public AuthorDTO(String fullName, List<ArticleBaseDTO> articlesdto) {
        this.fullName = fullName;
        this.articlesdto = articlesdto;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<ArticleBaseDTO> getArticlesdto() {
        return articlesdto;
    }

    public void setArticlesdto(List<ArticleBaseDTO> articlesdto) {
        this.articlesdto = articlesdto;
    }
}
