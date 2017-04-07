package cbgm.myapplication.base;

import cbgm.de.listapi.data.CBListViewItem;

/**
 * Created by SA_Admin on 14.02.2017.
 */

public abstract class ViewItem extends CBListViewItem<MyHolder, String>  {


    public ViewItem(String item, MyHolder holder, int itemResource) {
        super(item, holder, itemResource);
    }
}
