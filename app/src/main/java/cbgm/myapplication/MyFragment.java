package cbgm.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cbgm.de.listapi.basic.CBListView;
import cbgm.de.listapi.data.CBListItem;
import cbgm.de.listapi.data.CBListMode;
import cbgm.de.listapi.data.CBModeHelper;
import cbgm.de.listapi.listener.ICBActionDelegate;
import cbgm.myapplication.base.BaseItem;
import cbgm.myapplication.base.MyHolder;
import cbgm.myapplication.base.MyMenuListener;

/**
 * Created by SA_Admin on 26.10.2017.
 */

public class MyFragment extends Fragment implements ICBActionDelegate, MyMenuListener {
    private List<CBListItem> viewItems;
    private CBListView listContainer;
    private MyAdapter adapter;
    private static final int MENU_ITEM_ITEM1 = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment, container, false);
        CBModeHelper.getInstance().setListMode(CBListMode.SWIPE);
        this.listContainer = (CBListView) rootView.findViewById(R.id.list_container);;
        this.listContainer.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        this.listContainer.setLayoutManager(llm);
        this.listContainer.setDelegateListener(this);
        this.adapter = new MyAdapter(getContext());
        this.adapter.setCustomMenuListener(this);
        loadData();
        setHasOptionsMenu(true);
        this.listContainer.init(this.viewItems, this.adapter);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.add(Menu.NONE, MENU_ITEM_ITEM1, Menu.NONE, "Sort: " + (CBModeHelper.getInstance().getListMode() == CBListMode.SORT)).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ITEM_ITEM1:
                item.setTitle("Sort: " + (CBModeHelper.getInstance().getListMode() == CBListMode.SWIPE));

                if (CBModeHelper.getInstance().getListMode() == CBListMode.SWIPE) {
                    CBModeHelper.getInstance().setListMode(CBListMode.SORT);
                    loadData();
                    this.listContainer.init(this.viewItems, this.adapter);
                } else {
                    CBModeHelper.getInstance().setListMode(CBListMode.SWIPE);
                    loadData();
                    this.listContainer.init(this.viewItems, this.adapter);
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public void loadData() {
        this.viewItems = new ArrayList<>();
        int type = 1;
        for (int i = 0; i < 10; i++) {

            if (type == 1) {
                this.viewItems.add(new FirstItem("item 11111111111" + i));
                type = 2;
            } else {
                this.viewItems.add(new SecondItem(i));
                type = 1;
            }
        }
    }

    @Override
    public void test(Object o) {
        this.listContainer.getTouchHandler().informButtonClick();
        Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void delegateDeleteAction(Object o) {
        Toast.makeText(getContext(), "delete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void delegateEditAction(Object o) {
        Toast.makeText(getContext(), "edit", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void delegateSortAction(List list) {

    }

    @Override
    public void delegateSingleClickAction(int position) {
        Toast.makeText(getContext(), "show", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void delegateLongClickAction(int position) {

    }

    @Override
    public void delegateSwipeAction() {

    }

    @Override
    public void delegateSelectAction(int position) {

    }
}
