package ru.demo.translator.services;

import rx.Observable;

/**
 * Created by normalteam on 23.04.17.
 */

public interface IDataService {
    Observable<String> getWord(String codeFrom, String codeTo, String s);
}
