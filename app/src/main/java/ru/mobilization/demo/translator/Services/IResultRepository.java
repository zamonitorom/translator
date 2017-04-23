package ru.mobilization.demo.translator.Services;

import java.util.List;

import ru.mobilization.demo.translator.Models.Result;

/**
 * Created by normalteam on 22.04.17.
 */

public interface IResultRepository {
    void add(String text, String result, Boolean isFavour);
    void update(String text, String result, Boolean isFavour);
    void delete(String text);
    Result get(String text);
    List<Result> getAll();
}
