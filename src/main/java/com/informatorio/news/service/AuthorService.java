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
    public AuthorBaseDTO updateAuthor(Integer id , Author author){
        Author authorSelect =  authorRepository.findById(id).orElse(null);
        authorSelect.setId(id);
        authorSelect.setName(author.getName());
        authorSelect.setLastname(author.getLastname());
        Author authorUpdated = authorRepository.save(authorSelect);
        return authorConverter.toDtoAuthorBase(authorUpdated);
    }

    public String deleteAuthor(Integer id){
        authorRepository.deleteById(id);
       return "deleted author con el id " + id;
    }

    public PageCustumerAuthor getAllAuthor(int page,LocalDate createAt, String query){
    Pageable pageable = PageRequest.of(page, 3);
        PageCustumerAuthor pageCustumerAuthor = new PageCustumerAuthor();
        if( query != null){
          Page<Author> paged = authorRepository.searchAuthor(query,pageable);
            pageCustumerAuthor.setStatus(HttpStatus.OK);
            pageCustumerAuthor.setPage(paged.getSize());
            pageCustumerAuthor.setSize(paged.getTotalPages());
            pageCustumerAuthor.setTotalResult(paged.getTotalElements());
            pageCustumerAuthor.setContent(paged.getContent().stream().map(author -> authorConverter.toDTO(author)).collect(Collectors.toList()));
        }else{
            Page<Author> paged = authorRepository.findAllByCreateAtAfter(createAt,pageable);


            pageCustumerAuthor.setStatus(HttpStatus.OK);
            pageCustumerAuthor.setPage(paged.getSize());
            pageCustumerAuthor.setSize(paged.getTotalPages());
            pageCustumerAuthor.setTotalResult(paged.getTotalElements());
            pageCustumerAuthor.setContent(paged.getContent().stream().map(author -> authorConverter.toDTO(author)).collect(Collectors.toList()));
        }

         return pageCustumerAuthor;
    }


   
}
