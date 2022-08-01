package com.informatorio.news.dto.author;

import java.time.LocalDate;

public class AuthorBaseDTO {
    private String name;
    private  String lastname;
    private LocalDate createAt;

    public AuthorBaseDTO(String name, String lastname, LocalDate createAt) {
        this.name = name;
        this.lastname = lastname;
        this.createAt = createAt;
    }

    public AuthorBaseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
