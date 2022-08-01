package com.informatorio.news.controller;


import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.author.AuthorBaseDTO;
import com.informatorio.news.dto.author.AuthorDto;
import com.informatorio.news.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;



@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @PostMapping()
    public ResponseEntity<AuthorBaseDTO>  createAuthor1(@RequestBody Author author){
        AuthorBaseDTO authors = authorService.createAuthor(author);
        return new ResponseEntity(authors, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorDto> updateAuthor( @PathVariable Integer id,@RequestBody Author author){
        AuthorDto authorDTO = authorService.actualizarAuthor(id,author);
        return new ResponseEntity<AuthorDto>(authorDTO,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor( @PathVariable Integer id){
      authorService.eliminarAuthor(id);
    return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
    @GetMapping()
    public ResponseEntity< List<AuthorDto>> getAll(){
       List<AuthorDto> authores = authorService.traerTodosLosAuhores();
       return new ResponseEntity<List<AuthorDto>>(authores,HttpStatus.OK);

    }

    @GetMapping("/alldate")
    public List<AuthorDto> getForDate(@RequestParam("localDate")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate){
       List <AuthorDto> getDate = authorService.searchForDate(localDate);
        return  getDate;
    }
    @GetMapping("/test")
    public List<AuthorDto> getAuthor(@RequestParam String query){
        List<AuthorDto> authors = authorService.searchForFullName(query);
        return authors;
    }

}
