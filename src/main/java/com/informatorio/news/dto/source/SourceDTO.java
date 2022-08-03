package com.informatorio.news.dto.source;


import com.informatorio.news.dto.article.ArticleBaseDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SourceDTO extends SourceBaseDTO{

    private List<ArticleBaseDTO> articles = new ArrayList<>();

    public SourceDTO(Integer id, String name, String code, LocalDate createAt, List<ArticleBaseDTO> articles){
        this.setId(id);
        this.setName(name);
        this.setCode(code);
        this.setCreateAt(createAt);
        this.articles = articles;
    }

    public List<ArticleBaseDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleBaseDTO> articles) {
        this.articles = articles;
    }
}
