package ru.mobilization.demo.translator.Services;

import android.util.Log;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mobilization.demo.translator.Models.Result;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by kyupetrov on 21.04.2017.
 */

public class DataService implements IDataService {
    private final String TAG = "DataService";

    private Retrofit retrofit;

    private Api api;
    private IResultRepository repository;

    public DataService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.HOST)
                .client(okHttpClient)
                .build();

        api = retrofit.create(Api.class);
        repository = new DataRepository();
    }

    public Observable<String> getWord(String codeFrom, String codeTo, String s) {
        return Observable.create(subscriber -> {
            Result result = repository.get(s);
            final String[] response = new String[1];
            if (result == null) {
                HashMap<String, String> query = new HashMap<>();
                query.put("lang", codeFrom + "-" + codeTo);
                query.put("key", "trnsl.1.1.20170420T144606Z.543f8a29067f6714.5bd2c9ea2764197909d38cb0548292aa34b6adfb");
                query.put("text", s);
                Log.d(TAG, "getWord");
                HashMap<String, String> field = new HashMap<>();
                api.getTranslate(query, field)
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(translatorResponse -> {
                            response[0] = translatorResponse.getText();
                        }, throwable -> {
                        }, () -> {
                            repository.add(s, response[0], false);
                            subscriber.onNext(response[0]);
                        });
            } else {
                subscriber.onNext(result.getTranslation());
            }
        });

    }
}
