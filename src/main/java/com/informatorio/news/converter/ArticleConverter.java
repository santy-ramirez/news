package com.informatorio.news.converter;

import com.informatorio.news.domain.Article;
import com.informatorio.news.domain.Author;
import com.informatorio.news.domain.Source;


import com.informatorio.news.dto.SourceDTO;
import com.informatorio.news.dto.article.ArticleBaseDto;
import com.informatorio.news.dto.author.AuthorBaseDTO;
import org.springframework.stereotype.Component;




@Component
public class ArticleConverter {


    public ArticleBaseDto toDto(Article article){
      return new ArticleBaseDto(article.getId(),article.getTitle(), article.getDescription());


    }



    private AuthorBaseDTO todtoauthor(Author author){
        return new AuthorBaseDTO(author.getName(),author.getLastname(),author.getCreateAt());
    }
    private SourceDTO todsource(Source source){
        return new SourceDTO(source.getId(),source.getName(),source.getCode(),source.getCreateAt());
    }

}
