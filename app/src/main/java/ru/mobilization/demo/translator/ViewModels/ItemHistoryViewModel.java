package ru.mobilization.demo.translator.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import ru.mobilization.demo.translator.BR;
import ru.mobilization.demo.translator.Services.DataRepository;
import ru.mobilization.demo.translator.Services.IResultRepository;

/**
 * Created by normalteam on 23.04.17.
 */

public class ItemHistoryViewModel extends BaseObservable {

    private IResultRepository repository;

    private String text;
    private String translation;
    @Bindable
    public Boolean isFavour;

    public ItemHistoryViewModel() {
        repository = new DataRepository();
    }

    public void click(){
        if(isFavour) {
            setFavour(false);
        } else {
            setFavour(true);
        }
        repository.update(text,translation,isFavour);
    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Bindable
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
        notifyPropertyChanged(BR.translation);
    }

    public void setFavour(Boolean favour) {
        isFavour = favour;
        notifyPropertyChanged(BR.isFavour);
    }
}
