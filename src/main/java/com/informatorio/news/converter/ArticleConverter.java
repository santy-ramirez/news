package com.informatorio.news.converter;

import com.informatorio.news.domain.Article;
import com.informatorio.news.domain.Author;
import com.informatorio.news.domain.Source;


import com.informatorio.news.dto.article.ArticleBaseDTO;
import com.informatorio.news.dto.article.ArticleDTO;
import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.source.SourceBaseDTO;
import org.springframework.stereotype.Component;




@Component
public class ArticleConverter {


    public ArticleDTO toDto(Article article){
      return new ArticleDTO(article.getId(),article.getTitle(), article.getDescription(),article.getUrl(),article.getUrlToImage(),article.getContent(),article.getPublishedAt(),article.getPublished(), toDtoAuthorBase(article.getAuthor()), toDtoSourceBase(article.getSource()));


    }

public ArticleBaseDTO toDtoArticleBase(Article article){
        return new ArticleBaseDTO(article.getId(), article.getTitle(), article.getDescription(),article.getUrl(),article.getUrlToImage(),article.getContent(),article.getPublishedAt(),article.getPublished());
}

    private AuthorBaseDTO toDtoAuthorBase(Author author){
        return new AuthorBaseDTO(author.getName(),author.getLastname(),author.getCreateAt());
    }
    private SourceBaseDTO toDtoSourceBase(Source source){
        return new SourceBaseDTO (source.getId(),source.getName(),source.getCode(),source.getCreateAt());
    }


}
