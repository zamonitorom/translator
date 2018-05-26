package ru.demo.translator.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by normalteam on 22.04.17.
 */

public class Result extends RealmObject {
    @PrimaryKey
    private String text;
    @Required
    private String translation;
    @Required
    private Boolean isFavour;

    private String direction;

    public Result() {
    }

    public Result(String text, String translation, Boolean isFavour, String direction) {
        this.text = text;
        this.translation = translation;
        this.isFavour = isFavour;
        this.direction = direction;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Boolean getFavour() {
        return isFavour;
    }

    public void setFavour(Boolean favour) {
        isFavour = favour;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
