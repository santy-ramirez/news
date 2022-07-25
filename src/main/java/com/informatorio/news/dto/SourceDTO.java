package com.informatorio.news.dto;

import java.time.LocalDate;

public class SourceDTO {
    private Integer id;
    private String name;
    private String code;
    private LocalDate createAt;

    public SourceDTO(Integer id, String name, String code, LocalDate createAt) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.createAt = createAt;
    }

    public SourceDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
