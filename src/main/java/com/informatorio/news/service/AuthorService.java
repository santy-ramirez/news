package com.informatorio.news.service;

import com.informatorio.news.converter.ArticleConverter;
import com.informatorio.news.converter.AuthorConverter;
import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.author.AuthorDTO;
import com.informatorio.news.repository.AuthorRepository;
import com.informatorio.news.util.PageCustumerAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AuthorService {


    private final AuthorRepository authorRepository;

    private final AuthorConverter authorConverter;



    private final ArticleConverter articleConverter;
    @Autowired

    public AuthorService(AuthorRepository authorRepository, AuthorConverter authorConverter,ArticleConverter articleConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
        this.articleConverter = articleConverter;
    }

    public AuthorBaseDTO createAuthor(Author author){
        Author authors = authorRepository.save(author);
        return authorConverter.toDtoAuthorBase(authors);
    }
    public AuthorDTO actualizarAuthor(Integer id , Author author){
        Author authorSelect =  authorRepository.findById(id).orElse(null);
        authorSelect.setId(id);
        authorSelect.setName(author.getName());
        authorSelect.setLastname(author.getLastname());
        Author authorUpdated = authorRepository.save(authorSelect);
        return authorConverter.toDTO(authorUpdated);
    }

    public  void deleteAuthor(Integer id){
        authorRepository.deleteById(id);
    }

    public PageCustumerAuthor getAllAuhores(int page){
    Pageable pageable = PageRequest.of(page, 3);
        Page<Author> page1 = authorRepository.findAll(pageable);


    PageCustumerAuthor pageCustumer = new PageCustumerAuthor();
        pageCustumer.setStatus(HttpStatus.OK);
        pageCustumer.setPage(page1.getSize());
        pageCustumer.setSize(page1.getTotalPages());
        pageCustumer.setTotalResult(page1.getTotalElements());
    pageCustumer.setContent(page1.getContent().stream().map(author -> authorConverter.toDTO(author)).collect(Collectors.toList()));


         return pageCustumer;
    }

    public List<AuthorDTO> searchForDate(LocalDate localDate){
        List <Author> getDate = authorRepository.findByCreateAt(localDate);
        return getDate.stream().map(author -> authorConverter.toDTO(author)).collect(Collectors.toList());
    }

    public List<AuthorBaseDTO> searchForFullName(String query){
        List<Author> authors = authorRepository.searchAuthor(query);
        return authors.stream().map(author -> authorConverter.toDtoAuthorBase(author)).collect(Collectors.toList());
    }
   
}
