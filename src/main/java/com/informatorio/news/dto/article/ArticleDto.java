package com.informatorio.news.dto.article;

import com.informatorio.news.dto.author.AuthorBaseDTO;

public class ArticleDto extends ArticleBaseDto{
    private AuthorBaseDTO author;

    public ArticleDto(AuthorBaseDTO author) {
        this.author = author;
    }

    public ArticleDto() {
    }

    public AuthorBaseDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBaseDTO author) {
        this.author = author;
    }
}
