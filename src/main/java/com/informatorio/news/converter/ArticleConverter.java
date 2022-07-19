package com.informatorio.news.converter;

import com.informatorio.news.domain.Article;
import com.informatorio.news.dto.ArticleDTO;
import org.springframework.stereotype.Component;

@Component
public class ArticleConverter {

    public ArticleDTO toDto(Article article){
      return new ArticleDTO(article.getId(),article.getTitle(), article.getDescription(),article.getAuthor());


    }

    public  Article toEntity(ArticleDTO articleDTO){
        return new Article(articleDTO.getId(),articleDTO.getTitle(), articleDTO.getDescription(),articleDTO.getAuthor());
    }


}
