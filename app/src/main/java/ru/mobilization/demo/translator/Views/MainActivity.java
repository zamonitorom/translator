package ru.mobilization.demo.translator.Views;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import ru.mobilization.demo.translator.R;
import ru.mobilization.demo.translator.Utils.ContextUtill;
import ru.mobilization.demo.translator.Views.Fragments.FavouritesFragment;
import ru.mobilization.demo.translator.Views.Fragments.HistoryFragment;
import ru.mobilization.demo.translator.Views.Fragments.TranslatorFragment;

public class MainActivity extends AppCompatActivity {

    public FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_translate:
                    fragmentManager.beginTransaction().replace(R.id.container, new TranslatorFragment()).commit();
                    return true;
                case R.id.navigation_history:
                    fragmentManager.beginTransaction().replace(R.id.container, new HistoryFragment()).commit();
                    return true;
                case R.id.navigation_favourites:
                    fragmentManager.beginTransaction().replace(R.id.container, new FavouritesFragment()).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContextUtill.SetTopContext(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, new TranslatorFragment()).commit();

    }

}
