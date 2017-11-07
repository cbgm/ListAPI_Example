package cbgm.myapplication.base;

import cbgm.de.listapi.data.CBListViewItem;

public abstract class ViewItem extends CBListViewItem<MyHolder, String>  {


    public ViewItem(String item, MyHolder holder, int itemResource, int firstSelectedPos) {
        super(item, holder, itemResource, firstSelectedPos);
    }
}
