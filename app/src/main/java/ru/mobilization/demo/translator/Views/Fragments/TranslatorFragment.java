package ru.mobilization.demo.translator.Views.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mobilization.demo.translator.R;
import ru.mobilization.demo.translator.ViewModels.TranslatorViewModel;
import ru.mobilization.demo.translator.Views.MainActivity;
import ru.mobilization.demo.translator.databinding.FragmentTranslatorBinding;

public class TranslatorFragment extends Fragment {

    private FragmentTranslatorBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_translator,container,false);
        View view = binding.getRoot();
        Activity activity = new Activity();
        if(activity instanceof MainActivity){

        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TranslatorViewModel translatorViewModel = new TranslatorViewModel();
        binding.setTranslatorVM(translatorViewModel);

    }


}
