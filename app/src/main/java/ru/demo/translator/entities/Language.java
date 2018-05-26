package ru.demo.translator.entities;

/**
 * Created by kyupetrov on 21.04.2017.
 */

public class Language {
    private String code;
    private String title;
    public Language(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
