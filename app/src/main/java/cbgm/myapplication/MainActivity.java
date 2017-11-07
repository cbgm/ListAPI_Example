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
/*    private static final int MENU_ITEM_ITEM1 = 1;
    List<ViewItem> test;
    CBListView listContainer;
    MyAdapter adapter;*/

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        if (findViewById(R.id.fragment_holder) != null) {

            // The detail container view will be present only in the large-screen layouts
            // (res/layout-sw600dp). If this view is present, then the activity should be
            // in two-pane mode.

            // Replacing the container dynamically using a fragment transaction.
            // Check if savedInstance is null because
            // If we rotate the phone, the system saves the fragment state in the saved state bundle (savedInstanceState)
            // and is smart enough to restore this state.
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_holder, new MyFragment(), "MYFRAG_TAG")
                        .commit();
            }
        }
    /*    this.listContainer = (CBListView) findViewById(R.id.list_container);
        this.listContainer.setDelegateListener(this);
        this.adapter = initAdapter();
        listContainer.setAdapter(this.adapter);*/
    }

    /*public MyAdapter initAdapter() {
        this.test = new ArrayList<>();
        int type = 1;
        test = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            if (type == 1) {
                String item = "item 11111111111" + i;
                MyListViewItem li = new MyListViewItem(item, new MyViewHolder(), R.layout.backitem_standard, this, -1);
                test.add(li);
                type = 2;
            } else {
                String item = "item " + i;
                MyListViewItemSec li2 = new MyListViewItemSec(item, new MyViewHolder2(), R.layout.backitem_standard2, -1);
                test.add(li2);
                type = 1;
            }
        }
        return new MyAdapter(this, test, CBListMode.SWIPE);
    }*/


   /* public List<ViewItem> getUpdatedData() {
        return this.test;
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menu.add(Menu.NONE, MENU_ITEM_ITEM1, Menu.NONE, "Sort: " + isSortMode).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*switch (item.getItemId()) {
            case MENU_ITEM_ITEM1:
                this.isSortMode = !this.isSortMode;
                item.setTitle("Sort: " + isSortMode);
                updateData();
                updateAdapter();
                return true;

            default:
                return false;
        }*/
        return false;
    }
}

