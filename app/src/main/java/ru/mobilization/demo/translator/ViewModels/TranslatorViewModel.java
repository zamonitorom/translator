package ru.mobilization.demo.translator.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import ru.mobilization.demo.translator.BR;
import ru.mobilization.demo.translator.Models.Language;
import ru.mobilization.demo.translator.Services.DataService;
import ru.mobilization.demo.translator.Utils.MyObservableString;
import ru.mobilization.demo.translator.Utils.StringListener;
import rx.Completable;
import rx.Emitter;
import rx.Observable;
import rx.Single;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * Created by normalteam on 19.04.17.
 */

public class TranslatorViewModel extends BaseObservable {
    private final String TAG = "TranslatorViewModel";

    private DataService dataService;

    private Language langFrom;
    private Language langTo;

    private StringListener listener;

    private Observable<String> stringObservable(MyObservableString myObservableString){
        return Observable.create(subscriber ->
             listener = string -> {
                 if (!subscriber.isUnsubscribed()) {
                     subscriber.onNext(myObservableString.get());
                 }
             });
    }

    public MyObservableString textFrom = new MyObservableString(){
        @Override
        public String get() {
            return super.get();
        }

        @Override
        public void set(String value) {
            listener.onChange(value);
            super.set(value);
        }
    };
    public MyObservableString textTo;

    public TranslatorViewModel() {
        dataService = new DataService();
        langFrom = new Language("ru","Russian");
        langTo = new Language("en","English");
        textTo = new MyObservableString();
        stringObservable(textFrom)
                .debounce(500,TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
                .subscribe(s -> Log.d(TAG,"onNext + " + s));
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
