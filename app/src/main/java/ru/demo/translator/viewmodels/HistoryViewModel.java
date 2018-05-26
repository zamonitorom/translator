package ru.demo.translator.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import ru.demo.translator.services.DataRepository;
import ru.demo.translator.entities.Result;
import ru.demo.translator.services.IResultRepository;

/**
 * Created by normalteam on 19.04.17.
 */

public class HistoryViewModel extends BaseObservable {
    private IResultRepository repository;

    @Bindable
    public ObservableArrayList<ItemHistoryViewModel> items;

    public HistoryViewModel(Boolean showAll) {
        items = new ObservableArrayList<>();
        repository = new DataRepository();
        if (showAll) {
            showAll();
        }else {
            showFavour();
        }
    }

    private void showFavour() {
        for (Result r : repository.getAll()) {
            if(r.getFavour()) {
                ItemHistoryViewModel i = new ItemHistoryViewModel();
                i.setTranslation(r.getTranslation());
                i.setFavour(r.getFavour());
                i.setText(r.getText());
                items.add(i);
            }
        }
    }

    private void showAll() {
        for (Result r : repository.getAll()) {
            ItemHistoryViewModel i = new ItemHistoryViewModel();
            i.setTranslation(r.getTranslation());
            i.setFavour(r.getFavour());
            i.setText(r.getText());
            items.add(i);
        }
    }
}
