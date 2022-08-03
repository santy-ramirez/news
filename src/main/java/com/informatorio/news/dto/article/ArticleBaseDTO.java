package com.informatorio.news.dto.article;

public class ArticleBaseDTO {
    Integer id;
    private String title;
    private String description;

    public ArticleBaseDTO(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public ArticleBaseDTO() {
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
}
