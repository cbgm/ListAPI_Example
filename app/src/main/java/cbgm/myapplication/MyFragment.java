package cbgm.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cbgm.de.listapi.basic.CBAdapterDelegate;
import cbgm.de.listapi.basic.CBListView;
import cbgm.de.listapi.data.CBListMode;
import cbgm.de.listapi.data.CBModeHelper;
import cbgm.de.listapi.listener.ICBActionDelegate;
import cbgm.myapplication.base.BaseItem;
import cbgm.myapplication.base.MyMenuListener;

/**
 * Created by SA_Admin on 26.10.2017.
 */

public class MyFragment extends Fragment implements ICBActionDelegate<BaseItem>, MyMenuListener {
    private List<BaseItem> viewItems;
    private CBListView<BaseItem> listContainer;
    private static final int MENU_ITEM_ITEM1 = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment, container, false);
        this.listContainer = find(rootView, R.id.list_container);
        List<CBAdapterDelegate> delegates = new ArrayList<>();
        delegates.add(new AdapterDelegate1(this));
        delegates.add(new AdapterDelegate2());
        loadData();
        setHasOptionsMenu(true);
        this.listContainer.setup(this.viewItems, delegates, this);
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
                } else {
                    CBModeHelper.getInstance().setListMode(CBListMode.SWIPE);
                    loadData();
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
        for (int i = 0; i < 20; i++) {

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
    public void delegateDeleteAction(BaseItem o) {
        Toast.makeText(getContext(), "delete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void delegateEditAction(BaseItem o) {
        Toast.makeText(getContext(), "edit", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void delegateSortAction(List list) {
        Toast.makeText(getContext(), "sort", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(getContext(), "swipe", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void delegateSelectAction(int position) {
        Toast.makeText(getContext(), "select", Toast.LENGTH_SHORT).show();
    }


    @SuppressWarnings("unchecked")
    public final <T extends View> T find(View view, int id) {
        return (T)view.findViewById(id);
    }
}
