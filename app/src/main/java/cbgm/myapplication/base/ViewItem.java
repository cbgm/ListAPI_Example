package cbgm.myapplication.base;


import cbgm.de.listapi.basic.CBListViewItem;

public abstract class ViewItem extends CBListViewItem<MyHolder, String> {


    public ViewItem(String item, MyHolder holder, int itemResource, int firstSelectedPos) {
        super(item, holder, itemResource);
    }
}
