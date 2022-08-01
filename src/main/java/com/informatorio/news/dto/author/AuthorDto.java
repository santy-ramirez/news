package com.informatorio.news.dto.author;

import com.informatorio.news.dto.article.ArticleBaseDto;

import java.time.LocalDate;
import java.util.List;

public class AuthorDto extends AuthorBaseDTO {
    private String fullName;

   private List<ArticleBaseDto> articlesdto;

    public AuthorDto(String name, String lastname, LocalDate createAt, String fullName, List<ArticleBaseDto> articleBaseDtos) {
    }

    public AuthorDto(String fullName, List<ArticleBaseDto> articlesdto) {
        this.fullName = fullName;
        this.articlesdto = articlesdto;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<ArticleBaseDto> getArticlesdto() {
        return articlesdto;
    }

    public void setArticlesdto(List<ArticleBaseDto> articlesdto) {
        this.articlesdto = articlesdto;
    }
}
