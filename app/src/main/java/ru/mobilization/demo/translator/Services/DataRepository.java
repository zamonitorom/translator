package ru.mobilization.demo.translator.Services;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import ru.mobilization.demo.translator.Models.Result;
import ru.mobilization.demo.translator.Utils.ContextUtill;

/**
 * Created by normalteam on 22.04.17.
 */

public class DataRepository implements IResultRepository{

    private Realm realm;

    public DataRepository() {
        Realm.init((Activity)ContextUtill.GetTopContext());
    }

    @Override
    public void add(String text, String translation, Boolean isFavour) {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Result result1 = realm.createObject(Result.class,text);
        result1.setTranslation(translation);
        result1.setFavour(isFavour);
        realm.commitTransaction();
    }

    @Override
    public void update(String text, String result, Boolean isFavour) {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Result result1 = realm.where(Result.class).equalTo("text",text).findFirst();
        result1.setFavour(isFavour);
        result1.setTranslation(result);
        realm.commitTransaction();
    }

    @Override
    public void delete(String text) {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Result result = realm.where(Result.class).equalTo("text",text).findFirst();
        result.deleteFromRealm();
        realm.commitTransaction();
    }

    @Override
    public Result get(String text) {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Result answer = realm.where(Result.class).equalTo("text",text).findFirst();
        realm.commitTransaction();
        return answer;
    }

    @Override
    public List<Result> getAll() {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        ArrayList list = new ArrayList(realm.where(Result.class).findAll());
        realm.commitTransaction();
        return list;
    }
}
