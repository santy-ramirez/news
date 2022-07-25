package com.informatorio.news.controller;


import com.informatorio.news.domain.Author;
import com.informatorio.news.dto.AuthorDTO;
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
    public ResponseEntity<AuthorDTO>  createAuthor1(@RequestBody Author author){
        AuthorDTO authors = authorService.createAuthor(author);
        return new ResponseEntity(authors, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorDTO> updateAuthor( @PathVariable Integer id,@RequestBody Author author){
        AuthorDTO authorDTO = authorService.actualizarAuthor(id,author);
        return new ResponseEntity<AuthorDTO>(authorDTO,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor( @PathVariable Integer id){
      authorService.eliminarAuthor(id);
    return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
    @GetMapping()
    public ResponseEntity<List<AuthorDTO>> getAll(){
      List<AuthorDTO> authores = authorService.traerTodosLosAuhores();
       return new ResponseEntity<List<AuthorDTO>>(authores,HttpStatus.OK);

    }

    @GetMapping("/alldate")
    public List<AuthorDTO> getForDate(@RequestParam("localDate")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate){
       List <AuthorDTO> getDate = authorService.searchForDate(localDate);
        return  getDate;
    }
    @GetMapping("/test")
    public List<AuthorDTO> getAuthor(@RequestParam String query){
        List<AuthorDTO> authors = authorService.searchForFullName(query);
        return authors;
    }

}
