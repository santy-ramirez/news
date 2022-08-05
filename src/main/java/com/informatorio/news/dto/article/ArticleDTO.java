package com.informatorio.news.dto.article;

import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.source.SourceBaseDTO;

import java.time.LocalDate;

public class ArticleDTO extends ArticleBaseDTO {
    private AuthorBaseDTO author;
    private SourceBaseDTO source;

    public ArticleDTO(Integer id, String title, String description, String url, String urlToImage, String content, LocalDate publishedAt, AuthorBaseDTO author, SourceBaseDTO source) {

        super(id,title,description,url,urlToImage,content,publishedAt);
        this.author = author;
        this.source = source;
    }




    public AuthorBaseDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBaseDTO author) {
        this.author = author;
    }

    public SourceBaseDTO getSource() {
        return source;
    }

    public void setSource(SourceBaseDTO source) {
        this.source = source;
    }
}
