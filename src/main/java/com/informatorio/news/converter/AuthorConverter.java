package com.informatorio.news.converter;

import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    public AuthorDTO toDTO (Author author){
       return new AuthorDTO(author.getId(), author.getName(), author.getLastname(), author.getArticles());
    }
}
