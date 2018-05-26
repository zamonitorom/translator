package ru.demo.translator.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kyupetrov on 21.04.2017.
 */

public class TranslatorResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("text")
    @Expose
    private List<String> text = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getText() {
        StringBuilder answer = new StringBuilder();
        for (String s:text) {
            answer.append(s).append(" ");
        }
        return answer.toString();
    }

    public void setText(List<String> text) {
        this.text = text;
    }

}