package ru.mobilization.demo.translator.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import ru.mobilization.demo.translator.BR;
import ru.mobilization.demo.translator.Models.Language;
import ru.mobilization.demo.translator.Services.DataService;
import ru.mobilization.demo.translator.Services.LanguageRepo;
import ru.mobilization.demo.translator.Utils.MyObservableString;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by normalteam on 19.04.17.
 */

public class TranslatorViewModel extends BaseObservable {
    private final String TAG = "TranslatorViewModel";

    private DataService dataService;

    private Language langFrom;
    private Language langTo;

    private Subscriber<Language> languageFromSubscriber = new Subscriber<Language>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Language language) {
            setLangFrom(language);
            setChangingFrom(false);
            if(!textFrom.get().equals("")){
                textFrom.set(textFrom.get());
            }

        }
    };

    private Subscriber<Language> languageToSubscriber = new Subscriber<Language>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Language language) {
            setLangTo(language);
            if(!textFrom.get().equals("")){
                textFrom.set(textFrom.get());
            }

        }
    };

    private Observable<String> stringObservable() {
        return Observable.create(subscriber ->
            textFrom = new MyObservableString() {
                @Override
                public String get() {
                    return super.get();
                }

                @Override
                public void set(String value) {
                    setProcessing(true);
                    subscriber.onNext(value);
                    super.set(value);
                }
            });
    }

    public MyObservableString textFrom;
    private String textTo;

    @Bindable
    public ObservableArrayList<ItemLangViewModel> languagesFrom;

    @Bindable
    public ObservableArrayList<ItemLangViewModel> languagesTo;

    @Bindable
    public Boolean isProcessing;

    @Bindable
    public Boolean isChangingFrom;

    @Bindable
    public Boolean isChangingTo;

    public TranslatorViewModel() {
        dataService = new DataService();
        langTo = new Language("ru", "Russian");
        langFrom = new Language("en", "English");
        languagesFrom = new ObservableArrayList<>();
        languagesTo = new ObservableArrayList<>();
        LanguageRepo repo = new LanguageRepo();
        setChangingFrom(false);
        setChangingTo(false);
        for (Language l:repo.getAll()) {
            languagesFrom.add(new ItemLangViewModel(l.getCode(), l.getTitle(),languageFromSubscriber));
        }
        for (Language l:repo.getAll()) {
            languagesTo.add(new ItemLangViewModel(l.getCode(), l.getTitle(),languageToSubscriber));
        }
        stringObservable()
                .debounce(2000, TimeUnit.MILLISECONDS)
                .flatMap(s -> dataService.getWord(langFrom.getCode(), langTo.getCode(), textFrom.get()))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Log.d(TAG, "onNext + " + s);
                    setTextTo(s);
                    setProcessing(false);
                },throwable -> {
                    Log.d(TAG, throwable.toString());
                    setProcessing(false);
                });
    }

    public void clickFrom(){
        if(!isChangingFrom) {
            setChangingFrom(true);
        }else setChangingFrom(false);
    }

    public void clickTo(){
        if(!isChangingTo) {
            setChangingTo(true);
        }else setChangingTo(false);
    }

    public void clickChange(){
        Language buf = langFrom;
        setLangFrom(langTo);
        setLangTo(buf);
    }

    @Bindable
    public Language getLangFrom() {
        return langFrom;
    }

    private void setLangFrom(Language langFrom) {
        this.langFrom = langFrom;
        notifyPropertyChanged(BR.langFrom);
    }

    @Bindable
    public Language getLangTo() {
        return langTo;
    }

    private void setLangTo(Language langTo) {
        this.langTo = langTo;
        notifyPropertyChanged(BR.langTo);
    }

    @Bindable
    public String getTextTo() {
        return textTo;
    }

    private void setTextTo(String textTo) {
        this.textTo = textTo;
        notifyPropertyChanged(BR.textTo);
    }

    private void setProcessing(Boolean processing){
        isProcessing = processing;
        notifyPropertyChanged(BR.isProcessing);
    }
    private void setChangingFrom(Boolean changing){
        isChangingFrom = changing;
        notifyPropertyChanged(BR.isChangingFrom);
    }
    private void setChangingTo(Boolean changing){
        isChangingTo = changing;
        notifyPropertyChanged(BR.isChangingTo);
    }

}
