package com.informatorio.news.util;

import com.informatorio.news.dto.author.AuthorDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageCustumer  {
    private int page;
    private int size;
    private List<AuthorDto> content;




    public List<AuthorDto> getContent() {
        return content;
    }

    public void setContent(List<AuthorDto> content) {
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

    public PageCustumer() {
    }
}
