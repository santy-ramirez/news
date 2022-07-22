package com.informatorio.news.dto;




public class AuthorDTO {

    private String name;
    private  String lastname;
    private String fullName;




    public AuthorDTO(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


}
