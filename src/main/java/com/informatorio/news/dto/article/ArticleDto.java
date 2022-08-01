package com.informatorio.news.dto.article;

import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.source.SourceBaseDTO;

public class ArticleDto extends ArticleBaseDto{
    private AuthorBaseDTO author;
    private SourceBaseDTO source;

    public ArticleDto(Integer id, String title, String description,AuthorBaseDTO author,SourceBaseDTO source) {

        this.setId(id);
        this.setTitle(title);
        this.setDescription(description);
        this.author = author;
        this.source = source;
    }

    public ArticleDto() {
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
