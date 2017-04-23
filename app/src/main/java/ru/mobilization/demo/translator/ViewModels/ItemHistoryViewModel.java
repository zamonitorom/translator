package ru.mobilization.demo.translator.ViewModels;

import android.databinding.BaseObservable;

/**
 * Created by normalteam on 23.04.17.
 */

public class ItemHistoryViewModel extends BaseObservable {
    private String text;
    private String translation;
    private Boolean isFavour;

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
}
