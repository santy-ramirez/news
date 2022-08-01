package com.informatorio.news.dto.source;


import com.informatorio.news.dto.article.ArticleBaseDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SourceDTO extends SourceBaseDTO{

    private List<ArticleBaseDto> articles = new ArrayList<>();

    public SourceDTO(Integer id, String name, String code, LocalDate createAt, List<ArticleBaseDto> articles){
        this.setId(id);
        this.setName(name);
        this.setCode(code);
        this.setCreateAt(createAt);
        this.articles = articles;
    }

    public List<ArticleBaseDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleBaseDto> articles) {
        this.articles = articles;
    }
}
