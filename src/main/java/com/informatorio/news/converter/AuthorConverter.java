package com.informatorio.news.converter;


import com.informatorio.news.domain.Article;
import com.informatorio.news.domain.Author;
import com.informatorio.news.domain.Source;
import com.informatorio.news.dto.SourceDTO;
import com.informatorio.news.dto.article.ArticleBaseDto;
import com.informatorio.news.dto.article.ArticleDto;
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

       return new AuthorDto( author.getName(), author.getLastname(),author.getCreateAt(),author.getFullName(), toListArticle2(author.getArticles()));
    }




    public List<ArticleDto> toListArticle2(List<Article> articles){

        List<ArticleDto> articleDTOS= articles.stream().map(article -> toConverArticleDTO(article)).collect(Collectors.toList());
        return articleDTOS;
    }
    private ArticleDto toConverArticleDTO(Article article){
        return new ArticleDto(article.getId(),article.getTitle(),article.getDescription(),article.);
    }
public AuthorBaseDTO todtoauthor(Author author){
        return new AuthorBaseDTO (author.getName(),author.getLastname(),author.getCreateAt());
}
public SourceDTO sourceDTO(Source source){
        return new SourceDTO(source.getId(),source.getName(),source.getCode(),source.getCreateAt());
}
}
