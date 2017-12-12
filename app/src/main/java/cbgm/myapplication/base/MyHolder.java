package cbgm.myapplication.base;

import cbgm.de.listapi.basic.CBViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class MyHolder extends CBViewHolder<BaseItem> {
    public MyHolder(View itemView, Context context, ViewGroup parent, int itemResource, boolean addEdit, boolean addDelete) {
        super(itemView, context, parent, itemResource, addEdit, addDelete);
    }
}
