package cbgm.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

