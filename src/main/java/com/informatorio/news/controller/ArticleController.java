package com.informatorio.news.controller;


import com.informatorio.news.domain.Article;
import com.informatorio.news.dto.article.ArticleBaseDTO;
import com.informatorio.news.service.ArticleService;
import com.informatorio.news.util.PageCustumerArticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;




@Validated
@RestController
@RequestMapping("/article")
@CrossOrigin("*")
public class ArticleController {



    private ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping()
    public ResponseEntity<ArticleBaseDTO>  createArticles(@RequestBody @Valid Article article){
        ArticleBaseDTO articleBaseDTO = articleService.CreateArticle(article);
        return new ResponseEntity<ArticleBaseDTO>(articleBaseDTO, HttpStatus.CREATED) ;
    }

    @GetMapping()
    public ResponseEntity<PageCustumerArticle>  getAllArticles(@RequestParam(required = false,defaultValue = "1")@Valid @Positive int page,
                                                               @RequestParam(required = false, defaultValue = "true") Boolean published,
                                                                        @RequestParam(required = false) @Valid @Size( min = 3, max=10 ) String query

                                                               ){
        PageCustumerArticle pageCustumer = articleService.getAllArticle(page,published,query);

      return new ResponseEntity<>(pageCustumer   ,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteArticles(@PathVariable Integer id){
        return new ResponseEntity<>(articleService.deleteArticle(id),HttpStatus.NOT_FOUND);
  }

    @PutMapping("{id}")
    public ResponseEntity<ArticleBaseDTO> updateArticle(@PathVariable Integer id, @RequestBody @Valid Article article){
    ArticleBaseDTO articleBaseDTO =  articleService.updateArticle(id,article);
        return new ResponseEntity<ArticleBaseDTO>(articleBaseDTO,HttpStatus.CREATED);

    }



}
