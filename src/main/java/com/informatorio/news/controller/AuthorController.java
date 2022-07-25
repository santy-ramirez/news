package com.informatorio.news.controller;

import com.informatorio.news.converter.AuthorConverter;
import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.AuthorDTO;
import com.informatorio.news.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


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
    public List<AuthorDTO> getAll(){
        List<Author> author= authorRepository.findAll();
       return author.stream().map(author1 -> authorConverter.toDTO(author1)).collect(Collectors.toList());

    }

    @GetMapping("/name")
    public AuthorDTO searchAuthor(@RequestParam String name){
       Author author = authorRepository.findByName(name);
        Author author1 = author;
        return authorConverter.toDTO(author1);
    }

    @GetMapping("/alldate")
    public List<Author> getForDate(@RequestParam("localDate")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate){
       List <Author> getDate = authorRepository.findByCreateAt(localDate);
        return  getDate;
    }
}
