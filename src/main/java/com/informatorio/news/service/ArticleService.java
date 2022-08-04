package com.informatorio.news.service;

import com.informatorio.news.converter.ArticleConverter;
import com.informatorio.news.domain.Article;
import com.informatorio.news.dto.article.ArticleBaseDTO;
import com.informatorio.news.repository.ArticleRepository;
import com.informatorio.news.util.PageCustumerArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleConverter articleConverter;

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
        Pageable pageable = PageRequest.of(page, 3);
        Page<Article> page1 =  articleRepository.findAll(pageable);

        PageCustumerArticle pageCustumer = new PageCustumerArticle();
        pageCustumer.setPage(page1.getSize());
        pageCustumer.setSize(page1.getTotalPages());
        pageCustumer.setTotalResult(page1.getTotalElements());
        pageCustumer.setContent(page1.getContent().stream().map(article -> articleConverter.toDto(article)).collect(Collectors.toList()));

        return  pageCustumer;
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

    public List<ArticleBaseDTO> searchArticle(String query){
        List<Article> articles = articleRepository.searchArticle(query);
        List<ArticleBaseDTO> articleBaseDTOS = articles.stream().map(article -> articleConverter.toDtoArticleBase(article)).collect(Collectors.toList());
        return  articleBaseDTOS;
    }
}
