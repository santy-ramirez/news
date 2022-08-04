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

    public  SourceDTO toDto(Source source){
        return new SourceDTO(source.getId(),source.getName(),source.getCode(),source.getCreateAt(),toListArticleDto(source.getArticles()));
    }

    public SourceBaseDTO toSourceBaseDTO(Source source){
        return new SourceBaseDTO(source.getId(),source.getName(),source.getCode(),source.getCreateAt());
    }
    public List<ArticleBaseDTO> toListArticleDto(List<Article> articles){

        List<ArticleBaseDTO> articleDTOS= articles.stream().map(article -> toArticleBaseDTO(article)).collect(Collectors.toList());
        return articleDTOS;
    }
    private ArticleBaseDTO toArticleBaseDTO(Article article){
        return new ArticleBaseDTO(article.getId(),article.getTitle(),article.getDescription(),article.getUrl(),article.getUrlToImage(),article.getContent(),article.getPublishedAt());
    }

}
