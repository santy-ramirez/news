package com.informatorio.news.dto;


import java.time.LocalDate;


public class AuthorDTO {

    private String name;
    private  String lastname;
    private LocalDate createAt;
    private String fullName;




    public AuthorDTO(String name, String lastname, LocalDate createAt) {
        this.name = name;
        this.lastname = lastname;
        this.createAt = createAt;
        this.fullName = name + lastname;

    }

    public AuthorDTO() {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


}
