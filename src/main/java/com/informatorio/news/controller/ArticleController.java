package com.informatorio.news.controller;


import com.informatorio.news.domain.Article;
import com.informatorio.news.dto.article.ArticleBaseDTO;
import com.informatorio.news.dto.article.ArticleDTO;
import com.informatorio.news.service.ArticleService;
import com.informatorio.news.util.PageCustumerArticle;

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
    public ResponseEntity<PageCustumerArticle>  getAllArticles(@RequestParam(required = false,defaultValue = "0") int page){
        PageCustumerArticle pageCustumer = articleService.getAllArticle(page);

      return new ResponseEntity<>(pageCustumer   ,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteArticles(@PathVariable Integer id){
        return new ResponseEntity<>(articleService.deleteArticle(id),HttpStatus.NOT_FOUND);
  }

    @PutMapping("{id}")
    public ResponseEntity<ArticleBaseDTO> updateArticle(@PathVariable Integer id, @RequestBody Article article){
    ArticleBaseDTO articleBaseDTO =  articleService.updateArticle(id,article);
        return new ResponseEntity<ArticleBaseDTO>(articleBaseDTO,HttpStatus.CREATED);

    }
    @GetMapping("search")
    public ResponseEntity <List<ArticleDTO>> searchArticles( @RequestParam(name="query") @Valid @Size( min = 3, max=10 )  String query)  {
       List<ArticleDTO> articleBaseDTOS = articleService.searchArticle(query);
        return new ResponseEntity<>(articleBaseDTOS,HttpStatus.OK);
    }
    @GetMapping("filter")
    public ResponseEntity<List<ArticleDTO>> filterForPublished(@RequestParam(defaultValue = "true") Boolean published){
        List<ArticleDTO> articleBaseDTOS = articleService.filterPublish(published);
        return  new ResponseEntity<List<ArticleDTO>>(articleBaseDTOS,HttpStatus.OK);
    }
}
