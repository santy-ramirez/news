package com.informatorio.news.util;

import com.informatorio.news.dto.author.AuthorDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public class PageCustumerAuthor {
    private HttpStatus status;
    private int page;
    private int size;
    private Long totalResult;
    private List<AuthorDTO> content;


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<AuthorDTO> getContent() {
        return content;
    }

    public void setContent(List<AuthorDTO> content) {
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

    public PageCustumerAuthor() {
    }

    public Long getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Long totalResult) {
        this.totalResult = totalResult;
    }


}
