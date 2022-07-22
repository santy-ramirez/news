package com.informatorio.news.converter;

import com.informatorio.news.domain.Article;
import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.ArticleDTO;
import com.informatorio.news.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorConverter {


    public AuthorDTO toDTO (Author author){

       return new AuthorDTO( author.getName(), author.getLastname());
    }


}
