package com.informatorio.news.controller;

import com.informatorio.news.config.CustumExcepcionHandler;
import com.informatorio.news.domain.Article;
import com.informatorio.news.dto.article.ArticleBaseDTO;
import com.informatorio.news.service.ArticleService;
import com.informatorio.news.util.PageCustumerArticle;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;



@Validated
@RestController
@RequestMapping("/article")
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
    public ResponseEntity<PageCustumerArticle>  getAllArticles(@RequestParam(required = false,defaultValue = "0") int page){
        PageCustumerArticle pageCustumer = articleService.getAllArticle(page);

      return new ResponseEntity<>(pageCustumer   ,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteArticles(@PathVariable Integer id){
        articleService.deleteArticle(id);
        String confirmationMessage = "deleted author with id number:" + id;
        return new ResponseEntity<>(confirmationMessage,HttpStatus.NOT_FOUND);
  }

    @PutMapping("{id}")
    public ResponseEntity<ArticleBaseDTO> updateArticle(@PathVariable Integer id, @RequestBody Article article){
    ArticleBaseDTO articleBaseDTO =  articleService.updateArticle(id,article);
        return new ResponseEntity<ArticleBaseDTO>(articleBaseDTO,HttpStatus.CREATED);

    }
    @GetMapping("search")
    public ResponseEntity <List<ArticleBaseDTO>> searchArticles( @RequestParam(name="query") @Valid @Size( min = 3, max=10 )  String query)  {
       List<ArticleBaseDTO> articleBaseDTOS = articleService.searchArticle(query);
        return new ResponseEntity<>(articleBaseDTOS,HttpStatus.OK);
    }
}
