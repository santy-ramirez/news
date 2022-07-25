package com.informatorio.news.dto;

import com.informatorio.news.domain.Author;


public class ArticleDTO {

    private Integer id;
    private String title;
    private String description;

    private AuthorDTO authorDTO;

    private SourceDTO sourceDTO;



    public ArticleDTO(Integer id, String title, String description ) {
        this.id = id;
        this.title = title;
        this.description = description;


    }

    public ArticleDTO() {
    }

    public ArticleDTO(Integer id, String title, String description, AuthorDTO authorDTO,SourceDTO sourceDTO) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authorDTO = authorDTO;
        this.sourceDTO = sourceDTO;
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


    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

    public SourceDTO getSourceDTO() {
        return sourceDTO;
    }

    public void setSourceDTO(SourceDTO sourceDTO) {
        this.sourceDTO = sourceDTO;
    }
}
