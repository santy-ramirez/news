package com.informatorio.news.controller;

import com.informatorio.news.converter.ArticleConverter;
import com.informatorio.news.domain.Article;
import com.informatorio.news.dto.ArticleDTO;
import com.informatorio.news.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleConverter articleConverter;



    public ArticleController(ArticleRepository articleRepository,  ArticleConverter articleConverter) {
        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;

    }

    @PostMapping()
    public ResponseEntity<ArticleDTO>  createUser(@RequestBody  Article article){
        Article article1 = articleRepository.save(article);
        return new ResponseEntity<ArticleDTO>(articleConverter.toDto(article1), HttpStatus.CREATED) ;
    }


    @GetMapping()
    public List <Article> getAll(){

        return  articleRepository.findAll();
  }

  @DeleteMapping("/{id}")
     public void deleteArticle(@PathVariable Integer id){
        articleRepository.deleteById(id);
  }
}
