package ru.mobilization.demo.translator.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import ru.mobilization.demo.translator.Models.Result;
import ru.mobilization.demo.translator.Services.DataRepository;
import ru.mobilization.demo.translator.Services.IResultRepository;

/**
 * Created by normalteam on 19.04.17.
 */

public class HistoryViewModel extends BaseObservable {
    private IResultRepository repository;

    @Bindable
    public ObservableArrayList<ItemHistoryViewModel> items;

    public HistoryViewModel() {
        items = new ObservableArrayList<>();
        repository = new DataRepository();
        for (Result r:repository.getAll()) {
            ItemHistoryViewModel i = new ItemHistoryViewModel();
            i.setTranslation(r.getTranslation());
            i.setFavour(r.getFavour());
            i.setText(r.getText());
            items.add(i);
        }
    }

    public void showAll(){

    }
}
