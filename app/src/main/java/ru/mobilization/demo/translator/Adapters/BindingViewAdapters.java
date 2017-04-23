package ru.mobilization.demo.translator.Adapters;

import android.databinding.BindingAdapter;
import android.databinding.ObservableList;
import android.graphics.Bitmap;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import ru.mobilization.demo.translator.Utils.ExtendedEditText;
import ru.mobilization.demo.translator.Utils.LayoutManagers;
import ru.mobilization.demo.translator.Utils.MyObservableString;

public class BindingViewAdapters {

    @BindingAdapter({"onClick"})
    public static void bindOnClick(View view, final Runnable runnable) {
        view.setOnClickListener(v -> runnable.run());
    }

    @BindingAdapter({"image"})
    public static void bindImage(ImageView view, Bitmap bitmap) {
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (bitmap != null) {
            view.setImageBitmap(bitmap);
        }
    }

    @BindingAdapter({"items", "itemLayout", "variable"})
    public static void setAdapter(RecyclerView recyclerView, final ObservableList items, int layoutId, int brVarId) {
        BindingRecyclerViewAdapter adapter = (BindingRecyclerViewAdapter) recyclerView.getAdapter();
        if (adapter == null) {

            adapter = new BindingRecyclerViewAdapter(brVarId, layoutId);
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
        }
        adapter.setItems(items);
        final BindingRecyclerViewAdapter finalAdapter = adapter;

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView, LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }

    @BindingAdapter({"binding"})
    public static void bindEditText(ExtendedEditText view, final MyObservableString observableString) {
        view.setTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                observableString.set(s.toString());
            }
        });

        if (observableString != null) {
            String newValue = observableString.get();
            if (!view.getText().toString().equals(newValue)) {
                view.setText(newValue);
            }
        }

    }

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

}
