package ru.mobilization.demo.translator.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import ru.mobilization.demo.translator.BR;
import ru.mobilization.demo.translator.Models.Language;
import ru.mobilization.demo.translator.Utils.MyObservableString;

/**
 * Created by normalteam on 19.04.17.
 */

public class TranslatorViewModel extends BaseObservable {
    private final String TAG = "TranslatorViewModel";

    private Language langFrom;
    private Language langTo;

    public MyObservableString textFrom = new MyObservableString(){
        @Override
        public String get() {
            Log.d(TAG,"get");
            return super.get();
        }

        @Override
        public void set(String value) {
            Log.d(TAG,"set = " + value);
            super.set(value);
        }
    };
    public MyObservableString textTo;


    public TranslatorViewModel() {
        langFrom = new Language("ru","Russian");
        langTo = new Language("en","English");
//        textFrom = new MyObservableString();
        textTo = new MyObservableString();
    }

    @Bindable
    public Language getLangFrom() {
        return langFrom;
    }

    public void setLangFrom(Language langFrom) {
        this.langFrom = langFrom;
        notifyPropertyChanged(BR.langFrom);
    }

    @Bindable
    public Language getLangTo() {
        return langTo;
    }

    public void setLangTo(Language langTo) {
        this.langTo = langTo;
        notifyPropertyChanged(BR.langTo);
    }
}
