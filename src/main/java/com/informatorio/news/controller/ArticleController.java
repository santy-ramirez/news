package com.informatorio.news.controller;

import com.informatorio.news.converter.ArticleConverter;
import com.informatorio.news.domain.Article;
import com.informatorio.news.dto.article.ArticleBaseDto;
import com.informatorio.news.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<ArticleBaseDto>  createUser(@RequestBody  Article article){
        Article article1 = articleRepository.save(article);
        return new ResponseEntity<ArticleBaseDto>(articleConverter.toDto(article1), HttpStatus.CREATED) ;
    }

    @GetMapping()
    public List <ArticleBaseDto> getAll(){
        List<Article> articles = articleRepository.findAll();
      return articles.stream().map(article -> articleConverter.toDto(article)).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
     public void deleteArticle(@PathVariable Integer id){
        articleRepository.deleteById(id);
  }

    @PutMapping("{id}")
    public ResponseEntity<ArticleBaseDto> updateArticle( @PathVariable Integer id,@RequestBody Article article){
        Article articleSelect =  articleRepository.findById(id).orElse(null);
        articleSelect.setId(id);
        articleSelect.setTitle(article.getTitle());
        articleSelect.setDescription(article.getDescription());
        Article articleUpdated = articleRepository.save(articleSelect);
        return new ResponseEntity<ArticleBaseDto>(articleConverter.toDto(articleUpdated),HttpStatus.OK);

    }
    @GetMapping("/test")
    public List<ArticleBaseDto> getArticles(@RequestParam String query){
        List<Article> articles = articleRepository.searchArticle(query);
        return articles.stream().map(article -> articleConverter.toDto(article)).collect(Collectors.toList());
    }
}
