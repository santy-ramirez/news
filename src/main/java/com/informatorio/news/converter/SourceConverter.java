package com.informatorio.news.converter;

import com.informatorio.news.domain.Article;
import com.informatorio.news.domain.Source;
import com.informatorio.news.dto.article.ArticleBaseDTO;
import com.informatorio.news.dto.source.SourceBaseDTO;
import com.informatorio.news.dto.source.SourceDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SourceConverter {

    public SourceBaseDTO toDto(Source source){
        return new SourceBaseDTO(source.getId(),source.getName(),source.getCode(),source.getCreateAt());
    }

    public  SourceDTO toDto2(Source source){
        return new SourceDTO(source.getId(),source.getName(),source.getCode(),source.getCreateAt(),toListArticle2(source.getArticles()));
    }

    public List<ArticleBaseDTO> toListArticle2(List<Article> articles){

        List<ArticleBaseDTO> articleDTOS= articles.stream().map(article -> toConverArticleDTO(article)).collect(Collectors.toList());
        return articleDTOS;
    }
    private ArticleBaseDTO toConverArticleDTO(Article article){
        return new ArticleBaseDTO(article.getId(),article.getTitle(),article.getDescription());
    }

}
