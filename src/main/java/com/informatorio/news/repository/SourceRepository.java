package com.informatorio.news.repository;

import com.informatorio.news.domain.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends JpaRepository<Source,Integer> {

    @Query("SELECT n FROM Source n WHERE " +
            "n.name LIKE CONCAT('%',:q, '%')")
    Page<Source> findByName(String q, Pageable pageable);
}
