package com.informatorio.news.util;

import com.informatorio.news.dto.article.ArticleDTO;


import java.util.List;

public class PageCustumerArticle {
    private int page;
    private int size;
    private Long totalResult;
    private List<ArticleDTO> content;


    public List<ArticleDTO> getContent() {
        return content;
    }

    public void setContent(List<ArticleDTO> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public Long getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Long totalResult) {
        this.totalResult = totalResult;
    }
}
