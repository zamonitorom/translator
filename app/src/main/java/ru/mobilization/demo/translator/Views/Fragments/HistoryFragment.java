package ru.mobilization.demo.translator.Views.Fragments;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mobilization.demo.translator.R;
import ru.mobilization.demo.translator.ViewModels.HistoryViewModel;
import ru.mobilization.demo.translator.databinding.FragmentHistoryBinding;

/**
 * Created by normalteam on 19.04.17.
 */

public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;
    private HistoryViewModel historyViewModel;
    private Boolean showAll;

    public HistoryFragment(Boolean val) {
        showAll = val;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        historyViewModel = new HistoryViewModel(showAll);
        binding.setHistoryVM(historyViewModel);

    }

}
