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
   // @Query(value = "SELECT * FROM Article  WHERE Article.published=published")


    Page<Article> findAllByPublished(Boolean published, Pageable pageable);
    @Query("SELECT p FROM Article p WHERE " +
            "p.title LIKE CONCAT('%',:query, '%')")
    Page<Article> searchArticle(String query,Pageable pageable);
}
