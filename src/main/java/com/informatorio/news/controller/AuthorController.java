package com.informatorio.news.controller;


import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.author.AuthorDTO;
import com.informatorio.news.service.AuthorService;
import com.informatorio.news.util.PageCustumerAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Validated

@RestController
@RequestMapping("/author")
public class AuthorController {


    private AuthorService authorService;
    @Autowired

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @PostMapping()
    public ResponseEntity<AuthorBaseDTO>  createAuthor1(@RequestBody @Valid Author author){
        AuthorBaseDTO authors = authorService.createAuthor(author);
        return new ResponseEntity(authors, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorBaseDTO> updateAuthor(@PathVariable() Integer id, @RequestBody @Valid Author author){
        AuthorBaseDTO authorBaseDTO = authorService.updateAuthor(id,author);
        return new ResponseEntity<AuthorBaseDTO>(authorBaseDTO,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor( @PathVariable Integer id){
    return new ResponseEntity<String>( authorService.deleteAuthor(id),HttpStatus.NO_CONTENT);
    }
    @GetMapping()
    public ResponseEntity<PageCustumerAuthor> getAll(@RequestParam(required = false, defaultValue = "1") @Valid @Positive int page,
                                                     @RequestParam(required = false )@Valid @Size(min = 3,max = 10) String query ,
                                                     @RequestParam(required = false, defaultValue = "2022-08-23")@Valid
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createAt
                                                     ){
        PageCustumerAuthor authores = authorService.getAllAuthor(page,createAt,query);
       return new ResponseEntity<PageCustumerAuthor>(authores,HttpStatus.OK);

    }



}
