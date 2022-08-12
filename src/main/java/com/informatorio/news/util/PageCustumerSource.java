package com.informatorio.news.util;


import com.informatorio.news.dto.source.SourceDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public class PageCustumerSource {
    private HttpStatus status;
    private int page;
    private int size;
    private Long totalResult;
    private List<SourceDTO> content;



    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
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

    public List<SourceDTO> getContent() {
        return content;
    }

    public void setContent(List<SourceDTO> content) {
        this.content = content;
    }
}
