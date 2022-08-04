package com.informatorio.news.converter;


import com.informatorio.news.domain.Article;
import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.article.ArticleBaseDTO;
import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.author.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AuthorConverter {

    @Autowired
    private  SourceConverter sourceConverter;

    public AuthorConverter(SourceConverter sourceConverter) {

        this.sourceConverter = sourceConverter;
    }


    public AuthorDTO toDTO (Author author){

       return new AuthorDTO( author.getName(), author.getLastname(), author.getCreateAt(),author.getFullName(),toListArticleDto( author.getArticles()));
    }

    public List<ArticleBaseDTO> toListArticleDto(List<Article> articles){

        List<ArticleBaseDTO> articleDTOS= articles.stream().map(article -> toArticleBaseDTO(article)).collect(Collectors.toList());
        return articleDTOS;
    }

    private ArticleBaseDTO toArticleBaseDTO(Article article){
        return new ArticleBaseDTO(article.getId(),article.getTitle(),article.getDescription(),article.getUrl(),article.getUrlToImage(),article.getContent(),article.getPublishedAt());
    }

    public AuthorBaseDTO toDtoAuthorBase(Author author){
        return new AuthorBaseDTO(author.getName(),author.getLastname(),author.getCreateAt());
    }
}
