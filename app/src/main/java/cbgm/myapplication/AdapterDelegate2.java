package cbgm.myapplication;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cbgm.de.listapi.basic.CBAdapterDelegate;
import cbgm.myapplication.base.BaseItem;

/**
 * Created by SA_Admin on 15.01.2018.
 */

public class AdapterDelegate2 extends CBAdapterDelegate<BaseItem> {

    @Override
    protected MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder2(MyBaseView.getView(parent.getContext()), parent, R.layout.backitem_standard2);
    }

    @Override
    protected void onBindDelegateViewHolder(final CBAdapterDelegate.CBViewHolder holder, final int position, final List<BaseItem> data) {
        final SecondItem item = (SecondItem) data.get(position);
        final MyViewHolder2 holderFinal = (MyViewHolder2) holder;
        holderFinal.name.setText(item.getNumber()+"");
        holderFinal.name.setEnabled(true);
        holderFinal.name.setTextColor(Color.BLACK);
        holderFinal.itemView.setTag(holderFinal);
    }

    @Override
    protected boolean isTypeOf(List<BaseItem> data, int position) {
        return data.get(position) instanceof SecondItem;
    }

    public class MyViewHolder2 extends CBAdapterDelegate.CBViewHolder {
        private TextView name;

        MyViewHolder2(View itemView, ViewGroup parent, int itemRessource) {
            super(itemView, parent, itemRessource, true, false);
            this.name = itemView.findViewById(R.id.txt_type);

        }
    }
}
