package com.informatorio.news.config;

public class ApiSubError {
    private final  String field;
    private final String menssage;

    public ApiSubError(String field, String menssage) {
        this.field = field;
        this.menssage = menssage;
    }



    public String getField() {
        return field;
    }

    public String getMenssage() {
        return menssage;
    }
}
