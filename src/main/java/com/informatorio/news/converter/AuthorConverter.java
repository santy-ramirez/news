package com.informatorio.news.converter;


import com.informatorio.news.domain.Article;
import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.article.ArticleBaseDto;
import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.author.AuthorDto;
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


    public AuthorDto toDTO (Author author){

       return new AuthorDto( author.getName(), author.getLastname(),author.getCreateAt(),author.getFullName(),toListArticle2( author.getArticles()));
    }

    public List<ArticleBaseDto> toListArticle2(List<Article> articles){

        List<ArticleBaseDto> articleDTOS= articles.stream().map(article -> toConverArticleDTO(article)).collect(Collectors.toList());
        return articleDTOS;
    }

    private ArticleBaseDto toConverArticleDTO(Article article){
        return new ArticleBaseDto(article.getId(),article.getTitle(),article.getDescription());
    }

    public AuthorBaseDTO toDtoAuthorBase(Author author){
        return new AuthorBaseDTO(author.getName(),author.getLastname(),author.getCreateAt());
    }
}
