package com.informatorio.news.converter;

import com.informatorio.news.domain.Article;
import com.informatorio.news.domain.Author;
import com.informatorio.news.domain.Source;


import com.informatorio.news.dto.article.ArticleBaseDto;
import com.informatorio.news.dto.article.ArticleDto;
import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.source.SourceBaseDTO;
import org.springframework.stereotype.Component;




@Component
public class ArticleConverter {


    public ArticleDto toDto(Article article){
      return new ArticleDto(article.getId(),article.getTitle(), article.getDescription(),todtoauthor(article.getAuthor()),todsource(article.getSource()));


    }

public ArticleBaseDto toDtoArticleBase(Article article){
        return new ArticleBaseDto(article.getId(), article.getTitle(), article.getDescription());
}

    private AuthorBaseDTO todtoauthor(Author author){
        return new AuthorBaseDTO(author.getName(),author.getLastname(),author.getCreateAt());
    }
    private SourceBaseDTO todsource(Source source){
        return new SourceBaseDTO (source.getId(),source.getName(),source.getCode(),source.getCreateAt());
    }

}
