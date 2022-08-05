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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;



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
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable() Integer id, @RequestBody Author author){
        AuthorDTO authorDTO = authorService.actualizarAuthor(id,author);
        return new ResponseEntity<AuthorDTO>(authorDTO,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor( @PathVariable Integer id){
      authorService.deleteAuthor(id);
    return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
    @GetMapping()
    public ResponseEntity<PageCustumerAuthor> getAll(@RequestParam(required = false, defaultValue = "0") int page){
        PageCustumerAuthor authores = authorService.getAllAuhores(page);
       return new ResponseEntity<PageCustumerAuthor>(authores,HttpStatus.OK);

    }

    @GetMapping("/filter")
    public List<AuthorDTO> getForDate(@RequestParam("localDate")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate){
       List <AuthorDTO> getDate = authorService.searchForDate(localDate);
        return  getDate;
    }
    @GetMapping("/search")
    public List<AuthorBaseDTO> getAuthor(@RequestParam String query){
        List<AuthorBaseDTO> authors = authorService.searchForFullName(query);
        return authors;
    }

}
