package com.informatorio.news.service;

import com.informatorio.news.converter.ArticleConverter;
import com.informatorio.news.domain.Article;
import com.informatorio.news.dto.article.ArticleBaseDTO;
import com.informatorio.news.dto.article.ArticleDTO;
import com.informatorio.news.repository.ArticleRepository;
import com.informatorio.news.util.PageCustumerArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {


    private ArticleRepository articleRepository;

    private ArticleConverter articleConverter;
    @Autowired
    public ArticleService(ArticleRepository articleRepository,  ArticleConverter articleConverter) {
        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;


    }
    //Create author
    public ArticleBaseDTO CreateArticle(Article article){
        Article articleNew = articleRepository.save(article);
        return articleConverter.toDtoArticleBase(articleNew);
    }

    //Get All Articles Created
    public PageCustumerArticle getAllArticle(int page){
        Pageable pageable = PageRequest.of(page,3 );
        Page<Article> authorsPaged =  articleRepository.findAll(pageable);

         //List<Article> articles=  authorsPaged.getContent().stream().filter(article -> article.getPublished().equals(published)).collect(Collectors.toList());
        PageCustumerArticle pageCustumerArticle = new PageCustumerArticle();
         pageCustumerArticle.setStatus(HttpStatus.OK);
        pageCustumerArticle.setPage( authorsPaged.getTotalPages());
        pageCustumerArticle.setSize(authorsPaged.getSize());
        pageCustumerArticle.setTotalResult(authorsPaged.getTotalElements());
        pageCustumerArticle.setContent(authorsPaged.getContent().stream().map(article -> articleConverter.toDto(article)).collect(Collectors.toList()));

        return  pageCustumerArticle;
    }

    //Delete Article
    public String deleteArticle(Integer id){
        articleRepository.deleteById(id);
        String confirmationMessage = "deleted author with id:" + id;
        return confirmationMessage;
    }

    //Update Article

    public ArticleBaseDTO updateArticle(Integer id,Article article){
        Article articleSelect =  articleRepository.findById(id).orElse(null);
        articleSelect.setId(id);
        articleSelect.setTitle(article.getTitle());
        articleSelect.setDescription(article.getDescription());
        Article articleUpdated = articleRepository.save(articleSelect);
        return articleConverter.toDto(articleUpdated);
    }

    public List<ArticleDTO> searchArticle(String query){
        List<Article> articles = articleRepository.searchArticle(query);
        List<ArticleDTO> articleBaseDTOS = articles.stream().map(article -> articleConverter.toDto(article)).collect(Collectors.toList());
        return  articleBaseDTOS;
    }

    public List<ArticleDTO> filterPublish(Boolean published) {
        List<Article> articles = articleRepository.findAll();
       List<Article> articleFilter= articles.stream().filter(article -> article.getPublished().equals(published)).collect(Collectors.toList());
    List<ArticleDTO> articleBaseDTOS  = articleFilter.stream().map(article -> articleConverter.toDto(article)).collect(Collectors.toList());
    return articleBaseDTOS;
    }
}
