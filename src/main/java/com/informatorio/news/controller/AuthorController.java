package com.informatorio.news.controller;

import com.informatorio.news.converter.AuthorConverter;
import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.AuthorDTO;
import com.informatorio.news.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    private AuthorConverter authorConverter;

    public AuthorController(AuthorRepository authorRepository, AuthorConverter authorConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
    }

    @PostMapping()
    public ResponseEntity<AuthorDTO>  createAuthor(@RequestBody Author author){
        Author authors = authorRepository.save(author);
        return new ResponseEntity(authorConverter.toDTO(authors), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorDTO> updateAuthor( @PathVariable Integer id,@RequestBody Author author){
        Author authorSelect =  authorRepository.findById(id).orElse(null);
        authorSelect.setId(id);
        authorSelect.setName(author.getName());
        authorSelect.setLastname(author.getLastname());
        Author authorUpdated = authorRepository.save(authorSelect);
        return new ResponseEntity<AuthorDTO>(authorConverter.toDTO(authorUpdated),HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public void deleteAuthor( @PathVariable Integer id){
         authorRepository.deleteById(id);

    }
    @GetMapping()
    public List<Author> getAll(){
        return authorRepository.findAll();
    }
}
