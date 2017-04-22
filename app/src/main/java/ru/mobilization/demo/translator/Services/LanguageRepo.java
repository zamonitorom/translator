package ru.mobilization.demo.translator.Services;

import java.util.ArrayList;
import java.util.List;

import ru.mobilization.demo.translator.Models.Language;

/**
 * Created by normalteam on 22.04.17.
 */

public class LanguageRepo {

    public List<Language> getAll(){
        List<Language> answer = new ArrayList<>();
        answer.add(new Language("ru", "Russian"));
        answer.add(new Language("en", "English"));
        answer.add(new Language("uk", "Ukrainian"));
        answer.add(new Language("hi", "Hindi"));
        answer.add(new Language("be","Belorussian"));
        answer.add(new Language("de","German"));
        answer.add(new Language("pt","Portugal"));
        answer.add(new Language("fr","French"));
        answer.add(new Language("sv","Sweden"));
        return answer;
    }
}
