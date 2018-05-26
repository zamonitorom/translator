package ru.demo.translator.services;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import ru.demo.translator.entities.TranslatorResponse;
import rx.Observable;

/**
 * Created by kyupetrov on 21.04.2017.
 */

public interface Api {
    String HOST = "https://translate.yandex.net";

    @FormUrlEncoded
    @POST("/api/v1.5/tr.json/translate")
    Observable<TranslatorResponse> getTranslate(@QueryMap Map<String,String> query, @FieldMap Map<String,String> field);
}
