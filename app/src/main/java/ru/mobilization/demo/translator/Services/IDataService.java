package ru.mobilization.demo.translator.Services;

import ru.mobilization.demo.translator.Models.TranslatorResponse;
import rx.Observable;

/**
 * Created by normalteam on 23.04.17.
 */

public interface IDataService {
    Observable<String> getWord(String codeFrom, String codeTo, String s);
}
