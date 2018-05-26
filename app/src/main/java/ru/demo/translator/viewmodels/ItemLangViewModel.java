package ru.demo.translator.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import ru.demo.translator.entities.Language;
import ru.mobilization.demo.translator.BR;
import rx.Subscriber;

/**
 * Created by normalteam on 22.04.17.
 */

public class ItemLangViewModel extends BaseObservable{

    private String code;
    private String title;
    private Subscriber<Language> subscriber;
    @Bindable
    public Boolean isChecked;

    ItemLangViewModel(String code, String title, Subscriber<Language> subscriber) {
        this.code = code;
        this.title = title;
        this.subscriber = subscriber;
        setChecked(false);
    }

    public void click(){
        subscriber.onNext(new Language(code,title));
    }

    @Bindable
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        notifyPropertyChanged(BR.code);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public void setChecked(Boolean checked) {
        this.isChecked = checked;
        notifyPropertyChanged(BR.isChecked);
    }
}
