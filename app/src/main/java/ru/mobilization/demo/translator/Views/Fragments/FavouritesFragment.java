package ru.mobilization.demo.translator.Views.Fragments;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mobilization.demo.translator.R;
import ru.mobilization.demo.translator.ViewModels.FavouritesViewModel;
import ru.mobilization.demo.translator.databinding.FragmentFavouritesBinding;

/**
 * Created by normalteam on 19.04.17.
 */

public class FavouritesFragment extends Fragment {

    private FragmentFavouritesBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourites,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FavouritesViewModel favouritesViewModel = new FavouritesViewModel();
        binding.setFavouritesVM(favouritesViewModel);

    }


}