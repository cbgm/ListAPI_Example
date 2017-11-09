package cbgm.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import cbgm.de.listapi.data.CBListView;
import cbgm.de.listapi.listener.CBListMode;
import cbgm.de.listapi.listener.ICBActionDelegate;
import cbgm.myapplication.base.MyMenuListener;
import cbgm.myapplication.base.ViewItem;

public class MainActivity /*extends CBListActivity<ViewItem, MyAdapter>*/ extends AppCompatActivity{

    @Override
    public void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        if (findViewById(R.id.fragment_holder) != null) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_holder, new MyFragment(), "MYFRAG_TAG")
                        .commit();
            }
        }
    }
}

