package com.informatorio.news.service;

import com.informatorio.news.converter.AuthorConverter;
import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.AuthorDTO;
import com.informatorio.news.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public AuthorService(AuthorRepository authorRepository, AuthorConverter authorConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
    }

    public AuthorDTO createAuthor( Author author){
        Author authors = authorRepository.save(author);
        return authorConverter.toDTO(authors);
    }
    public AuthorDTO actualizarAuthor(Integer id ,Author author){
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

    public List<AuthorDTO> traerTodosLosAuhores(){
        List<Author> author= authorRepository.findAll();
       List<AuthorDTO> authorDTOS = author.stream().map(author1 -> authorConverter.toDTO(author1)).collect(Collectors.toList());
       return  authorDTOS;
    }

    public List<AuthorDTO> searchForDate(LocalDate localDate){
        List <Author> getDate = authorRepository.findByCreateAt(localDate);
        return getDate.stream().map(author -> authorConverter.toDTO(author)).collect(Collectors.toList());
    }

    public List<AuthorDTO> searchForFullName(String query){
        List<Author> authors = authorRepository.searchAuthor(query);
        return authors.stream().map(author -> authorConverter.toDTO(author)).collect(Collectors.toList());
    }
}
