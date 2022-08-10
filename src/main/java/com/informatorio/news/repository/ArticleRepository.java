package com.informatorio.news.repository;

import com.informatorio.news.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository  extends JpaRepository<Article,Integer> {

    @Query("SELECT p FROM Article p WHERE " +
            "p.title LIKE CONCAT('%',:query, '%')")
    List<Article> searchArticle(String query);
}
