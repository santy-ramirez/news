package com.informatorio.news.service;

import com.informatorio.news.converter.ArticleConverter;
import com.informatorio.news.converter.AuthorConverter;
import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.author.AuthorDto;
import com.informatorio.news.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired
    private final AuthorConverter authorConverter;


    @Autowired
    private final ArticleConverter articleConverter;

    public AuthorService(AuthorRepository authorRepository, AuthorConverter authorConverter,ArticleConverter articleConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
        this.articleConverter = articleConverter;
    }

    public AuthorBaseDTO createAuthor(Author author){
        Author authors = authorRepository.save(author);
        return authorConverter.toDtoAuthorBase(authors);
    }
    public AuthorDto actualizarAuthor(Integer id ,Author author){
        Author authorSelect =  authorRepository.findById(id).orElse(null);
        authorSelect.setId(id);
        authorSelect.setName(author.getName());
        authorSelect.setLastname(author.getLastname());
        Author authorUpdated = authorRepository.save(authorSelect);
        return authorConverter.toDTO(authorUpdated);
    }

    public  void eliminarAuthor(Integer id){
        authorRepository.deleteById(id);
    }

    public List<AuthorDto> traerTodosLosAuhores(){
        List<Author> author= authorRepository.findAll();
         List<AuthorDto>  authorDTOS = author.stream().map(author1 -> authorConverter.toDTO(author1)).collect(Collectors.toList());
         return authorDTOS;
    }

    public List<AuthorDto> searchForDate(LocalDate localDate){
        List <Author> getDate = authorRepository.findByCreateAt(localDate);
        return getDate.stream().map(author -> authorConverter.toDTO(author)).collect(Collectors.toList());
    }

    public List<AuthorDto> searchForFullName(String query){
        List<Author> authors = authorRepository.searchAuthor(query);
        return authors.stream().map(author -> authorConverter.toDTO(author)).collect(Collectors.toList());
    }
   
}
