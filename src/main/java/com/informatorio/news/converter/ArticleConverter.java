package com.informatorio.news.converter;

import com.informatorio.news.domain.Article;
import com.informatorio.news.dto.ArticleDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleConverter {

@Autowired
AuthorConverter authorConverter;

    public ArticleConverter(AuthorConverter authorConverter) {
        this.authorConverter = authorConverter;
    }

    public ArticleDTO toDto(Article article){
      return new ArticleDTO(article.getId(),article.getTitle(), article.getDescription(),authorConverter.toDTO(article.getAuthor()));


    }




}
